package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.common.FileProcessor;
import com.pokemon.pokemonapi.pokemon.dto.PokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PokemonService {

    public final static String DATA_FILE_NAME = "pokemon.json";

    private final FileProcessor fileProcessor;

    @Autowired
    public PokemonService(
            FileProcessor fileProcessor
    ) {
        this.fileProcessor = fileProcessor;
    }

    public List<Pokemon> getAllPokemon() {
        return this.fileProcessor.readAsList(DATA_FILE_NAME, Pokemon[].class);
    }

    public Pokemon getPokemonById(Integer id) {
        List<Pokemon> pokemons = this.getAllPokemon();

        for (Pokemon pokemon : pokemons) {
            if (pokemon.getId().equals(id)) {
                return pokemon;
            }
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public void savePokemon(PokemonDto dto) {
        List<Pokemon> existingPokemonData =
                this.fileProcessor.readAsList(PokemonService.DATA_FILE_NAME, Pokemon[].class);

        Pokemon p = new Pokemon(
                existingPokemonData.size(),
                dto.level(),
                dto.name(),
                dto.species(),
                dto.type(),
                LocalDateTime.now()
        );

        for (Pokemon pokemon : existingPokemonData) {
            if (
                    pokemon.getSpecies().equals(p.getSpecies())
                            && pokemon.getName().equals(p.getName())
                            && pokemon.getName().equals(p.getName())
            ) {
                throw new ResponseStatusException(HttpStatus.CONFLICT);
            }
        }

        existingPokemonData.add(p);

        this.fileProcessor.update(PokemonService.DATA_FILE_NAME, existingPokemonData);
    }
}
