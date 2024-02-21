package com.pokemon.pokemonapi.trainer;

import com.pokemon.pokemonapi.pokemon.Pokemon;
import com.pokemon.pokemonapi.pokemon.PokemonRepository;
import com.pokemon.pokemonapi.security.CurrentUser;
import com.pokemon.pokemonapi.security.Role;
import com.pokemon.pokemonapi.trainer.dto.AddPokemonDto;
import com.pokemon.pokemonapi.trainer.dto.GetTrainerDto;
import com.pokemon.pokemonapi.trainer.dto.SaveTrainerDto;
import com.pokemon.pokemonapi.trainer.dto.UpdateTrainerDto;
import com.pokemon.pokemonapi.trainer_pokemon.TrainerPokemon;
import com.pokemon.pokemonapi.trainer_pokemon.TrainerPokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;
    private final PokemonRepository pokemonRepository;
    private final TrainerPokemonRepository trainerPokemonRepository;

    private final CurrentUser currentUser;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public TrainerService(
            TrainerRepository trainerRepository,
            PokemonRepository pokemonRepository,
            TrainerPokemonRepository trainerPokemonRepository,
            PasswordEncoder passwordEncoder,
            CurrentUser currentUser
    ) {
        this.trainerRepository = trainerRepository;
        this.pokemonRepository = pokemonRepository;
        this.trainerPokemonRepository = trainerPokemonRepository;
        this.currentUser = currentUser;
        this.passwordEncoder = passwordEncoder;
    }

    public Optional<Trainer> getTrainerByUsernameAndPassword(String username, String plainPassword) {
        Optional<Trainer> trainer = this.trainerRepository.findByUsername(username);

        if (trainer.isEmpty() || !this.passwordEncoder.matches(plainPassword, trainer.get().getPassword())) {
            return Optional.empty();
        }

        return trainer;
    }

    public List<GetTrainerDto> getAllTrainersWithPokemon() {
        List<Trainer> trainers = this.trainerRepository.findAllWithRelations();

        return trainers.stream().map(this::mapToGetTrainerDto).toList();
    }

    public GetTrainerDto getTrainerById(Integer id) {
        User user = this.currentUser.get();
        Trainer loggedInTrainer =
                this.trainerRepository
                        .findByUsername(user.getUsername())
                        .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));

        if (
                loggedInTrainer.getRole().equals(Role.USER) &&
                       !loggedInTrainer.getId().equals(id)
        ) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }

        Optional<Trainer> trainer = this.trainerRepository.findFirstById(id);

        if (trainer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return this.mapToGetTrainerDto(trainer.get());
    }

    @Transactional
    public void saveTrainer(SaveTrainerDto dto) {
        Trainer trainer = new Trainer();

        trainer.setUsername(dto.username());
        trainer.setPassword(
                this.passwordEncoder.encode(dto.password())
        );
        trainer.setName(dto.name());
        trainer.setLocation(dto.location());
        trainer.setRole(Role.USER);

        Trainer savedTrainer;

        try {
            savedTrainer = this.trainerRepository.save(trainer);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Trainer with this username already exists.");
        }

        if (dto.pokemonToCatch() == null || dto.pokemonToCatch().size() == 0) {
            return;
        }

        List<Pokemon> pokemonToCatch = this.pokemonRepository.findAllByIdIn(dto.pokemonToCatch());

        this.trainerPokemonRepository.saveAllAndFlush(
                pokemonToCatch.stream().map((p) -> new TrainerPokemon(
                        false,
                        p,
                        savedTrainer
                )).toList()
        );
    }

    public void saveTrainer(UpdateTrainerDto trainerDto, Integer id) {
        this.trainerRepository.update(trainerDto.name(), trainerDto.location(), id);
    }

    public void addPokemon(Integer trainerId, Integer pokemonId, AddPokemonDto dto) {
        try {
            this.trainerPokemonRepository.upsert(trainerId, pokemonId, dto.name(), dto.level());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    public void addPokemonToCatch(Integer trainerId, Integer pokemonId) {
        try {
            this.trainerPokemonRepository.insertPokemonToCatch(trainerId, pokemonId);
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    private GetTrainerDto.CaughtPokemon extractCaughtPokemonData(TrainerPokemon trainerPokemon) {
        Pokemon pokemon = trainerPokemon.getPokemon();

        return new GetTrainerDto.CaughtPokemon(
                trainerPokemon.getPokemonId(),
                trainerPokemon.getName(),
                trainerPokemon.getLevel(),
                pokemon.getSpecies(),
                pokemon.getType()
        );
    }

    private GetTrainerDto mapToGetTrainerDto(Trainer t) {
        List<GetTrainerDto.CaughtPokemon> caughtPokemon = t.getCaughtPokemon()
                .stream()
                .map(this::extractCaughtPokemonData)
                .toList();

        return new GetTrainerDto(
                t.getId(),
                t.getName(),
                t.getLocation(),
                t.getRole(),
                caughtPokemon,
                t.getPokemonToCatch().stream().toList(),
                t.getCreatedAt()
        );
    }
}
