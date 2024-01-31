package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.pokemon.dto.SaveOrUpdatePokemonDto;
import com.pokemon.pokemonapi.trainer.Trainer;
import com.pokemon.pokemonapi.trainer_pokemon.TrainerPokemonRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {
    private final PokemonRepository pokemonRepository;
    private final TrainerPokemonRepository trainerPokemonRepository;

    @Autowired
    public PokemonService(
            PokemonRepository pokemonRepository,
            TrainerPokemonRepository trainerPokemonRepository
    ) {
        this.pokemonRepository = pokemonRepository;
        this.trainerPokemonRepository = trainerPokemonRepository;
    }

    public List<Pokemon> getAllPokemon() {
        return this.pokemonRepository.findAllByOrderByIdAsc();
    }

    public Pokemon getPokemonById(Integer id) {
        Optional<Pokemon> pokemon = this.pokemonRepository.findById(id);

        if (pokemon.isPresent()) {
            return pokemon.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void savePokemon(SaveOrUpdatePokemonDto dto) {
        Pokemon p = new Pokemon();

        p.setType(dto.type());
        p.setSpecies(dto.species());

        try {
            this.pokemonRepository.save(p);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
    }

    public void savePokemon(SaveOrUpdatePokemonDto dto, Integer id) {
        if (!this.pokemonRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        this.pokemonRepository.update(id, dto.species(), dto.type());
    }

    public List<Trainer> getPokemonTrainers(Integer pokemonId) {
        return this.trainerPokemonRepository.findAllTrainersForPokemon(pokemonId);
    }

    @Transactional
    public void transferPokemon(Integer pokemonId, Integer fromTrainerId, Integer toTrainerId) {
        if (!this.trainerPokemonRepository.existsByPokemonIdAndTrainerIdAndIsCaughtIsTrue(pokemonId, fromTrainerId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.trainerPokemonRepository.updateTrainerId(toTrainerId, fromTrainerId, pokemonId);
    }
}