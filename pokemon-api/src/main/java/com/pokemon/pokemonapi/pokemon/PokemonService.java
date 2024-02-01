package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.common.FileProcessor;
import com.pokemon.pokemonapi.pokemon.dto.PokemonDto;
import com.pokemon.pokemonapi.trainer.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PokemonService {

    public final static String POKEMON_FILE_NAME = "pokemon.json";
    public final static String TRAINER_FILE_NAME = "trainer.json";

    private final FileProcessor fileProcessor;
    private final PokemonRepository pokemonRepository;


    @Autowired
    public PokemonService(
            FileProcessor fileProcessor, PokemonRepository pokemonRepository
    ) {
        this.fileProcessor = fileProcessor;
        this.pokemonRepository = pokemonRepository;
    }

    public void savePokemon(PokemonDto dto) {
        List<Pokemon> existingPokemonData =
                this.fileProcessor.readAsList(PokemonService.POKEMON_FILE_NAME, Pokemon[].class);

        Pokemon p = new Pokemon(
                existingPokemonData.size(),
                dto.level(),
                dto.name(),
                dto.species(),
                dto.type(),
                LocalDateTime.now()
        );

        if (existingPokemonData.stream().anyMatch(pk ->
                pk.getName().equals(p.getName()) &&
                        pk.getSpecies().equals(p.getSpecies()) &&
                        pk.getType().equals(p.getType()))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }

        existingPokemonData.add(p);

        this.fileProcessor.update(PokemonService.POKEMON_FILE_NAME, existingPokemonData);
    }

    public List<Pokemon> getAllPokemon() {
        return this.pokemonRepository.findAll();
//        return this.fileProcessor.readAsList(PokemonService.POKEMON_FILE_NAME, Pokemon[].class);
    }

    public Pokemon getPokemonById(Integer id) {
        List<Pokemon> filteredPokemon = getAllPokemon().stream().filter(p -> p.getId().equals(id)).toList();
        if (filteredPokemon.size() != 1) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return filteredPokemon.getFirst();
    }

    public void updatePokemon(Integer id, PokemonDto dto) {
        Pokemon pokemon = getPokemonById(id);

        if (pokemon == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        pokemon.setLevel(dto.level());
        pokemon.setSpecies(dto.species());
        pokemon.setType(dto.type());
        pokemon.setName(dto.name());

        this.fileProcessor.update(PokemonService.POKEMON_FILE_NAME, getAllPokemon());
    }

    private List<Trainer> getAllTrainers() {
        return this.fileProcessor.readAsList(PokemonService.TRAINER_FILE_NAME, Trainer[].class);
    }

    public Trainer getTrainerByPokemonId(Integer id) {
        List<Trainer> trainers = getAllTrainers();
        for (Trainer trainer : trainers) {
            for (Pokemon pokemon : trainer.getPokemon()) {
                if (pokemon.getId().equals(id)) {
                    return trainer;
                }
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void transferPokemon(Integer id, Integer fromTrainerId, Integer toTrainerId) {
        List<Trainer> allTrainers = getAllTrainers();
        Trainer fromTrainer = getTrainerById(fromTrainerId, allTrainers);
        Trainer toTrainer = getTrainerById(toTrainerId, allTrainers);
        Pokemon pokemon = getPokemonById(id);

        if (fromTrainerId.equals(toTrainerId) ||
                !fromTrainer.getPokemon().contains(pokemon)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        List<Pokemon> updatedPokemonList = toTrainer.getPokemon();
        updatedPokemonList.add(pokemon);
        toTrainer.setPokemon(updatedPokemonList);

        toTrainer.getPokemonToCatch().removeIf(species -> species.equals(pokemon.getSpecies()));
        fromTrainer.getPokemon().removeIf(p -> p.getId().equals(id));

        this.fileProcessor.update(TRAINER_FILE_NAME, allTrainers);
    }

    private Trainer getTrainerById(Integer id, List<Trainer> trainers) {
        for (Trainer trainer : trainers) {
            if (trainer.getId().equals(id)) {
                return trainer;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
}
