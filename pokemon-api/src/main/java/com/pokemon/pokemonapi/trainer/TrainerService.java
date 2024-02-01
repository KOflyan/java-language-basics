package com.pokemon.pokemonapi.trainer;

import com.pokemon.pokemonapi.common.FileProcessor;
import com.pokemon.pokemonapi.pokemon.Pokemon;
import com.pokemon.pokemonapi.pokemon.PokemonService;
import com.pokemon.pokemonapi.trainer.dto.CreateTrainerDto;
import com.pokemon.pokemonapi.trainer.dto.PatchTrainerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerService {
    public final static String TRAINER_FILE_NAME = "trainer.json";
    public final static String POKEMON_FILE_NAME = "pokemon.json";
    private final FileProcessor fileProcessor;
    private final PokemonService pokemonService;

    @Autowired
    public TrainerService(FileProcessor processor, PokemonService pokemonService) {
        this.fileProcessor = processor;
        this.pokemonService = pokemonService;
    }

    public void saveTrainer(CreateTrainerDto createTrainerDto) {
        List<Trainer> trainers = getAllTrainers();

        Trainer newTrainer = new Trainer(
                trainers.toArray().length,
                createTrainerDto.name(),
                createTrainerDto.currentLocation(),
                new ArrayList<>(),
                createTrainerDto.pokemonToCatch() == null ? new ArrayList<>() : createTrainerDto.pokemonToCatch(),
                LocalDateTime.now()
        );

        trainers.add(newTrainer);
        this.fileProcessor.update(TRAINER_FILE_NAME, createTrainerDto);
    }

    public List<Trainer> getAllTrainers() {
        return this.fileProcessor.readAsList(TRAINER_FILE_NAME, Trainer[].class);
    }

    public Trainer getTrainerById(Integer id) {
        return getTrainerById(id, getAllTrainers());
    }

    public Trainer getTrainerById(Integer id, List<Trainer> trainers) {
        for (Trainer trainer : trainers) {
            if (trainer.getId().equals(id)) {
                return trainer;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void updateTrainerById(Integer id, PatchTrainerDto patchTrainerDto) {
        if (!patchTrainerDto.isValid()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        Trainer trainer = getTrainerById(id);
        if (patchTrainerDto.name() != null) {
            trainer.setName(patchTrainerDto.name());
        }
        if (patchTrainerDto.currentLocation() != null) {
            trainer.setCurrentLocation(patchTrainerDto.currentLocation());
        }
    }

    public void catchPokemon(Integer trainerId, Integer pokemonId) {
        Pokemon pokemon = this.pokemonService.getPokemonById(pokemonId);
        Trainer trainer = getTrainerById(trainerId);
        List<Trainer> allTrainers = getAllTrainers();

        if (trainer.getPokemon().contains(pokemon)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        for (Trainer rival : allTrainers) {
            if (rival.getPokemon().contains(pokemon)) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }

        trainer.getPokemonToCatch().removeIf(species -> species.equals(pokemon.getSpecies()));
        trainer.getPokemon().add(pokemon);
        this.fileProcessor.update(TRAINER_FILE_NAME, allTrainers);
    }

    public void addPokemonToCatch(Integer id, String species) {
        List<Trainer> allTrainers = getAllTrainers();
        Trainer trainer = getTrainerById(id, allTrainers);

        if (species.length() < 3) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if (trainer.getPokemonToCatch().contains(species.toLowerCase())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }


        trainer.getPokemonToCatch().add(species.toLowerCase());
        this.fileProcessor.update(TRAINER_FILE_NAME, allTrainers);
    }
}
