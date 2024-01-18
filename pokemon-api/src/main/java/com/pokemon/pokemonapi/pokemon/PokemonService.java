package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.common.FileProcessor;
import com.pokemon.pokemonapi.pokemon.dto.CreatePokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PokemonService {

    private final static String DATA_FILE_NAME = "pokemon.json";

    private final FileProcessor fileProcessor;

    @Autowired
    public PokemonService(
            FileProcessor fileProcessor
    ) {
        this.fileProcessor = fileProcessor;
    }

    public void savePokemon(CreatePokemonDto dto) {
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

        existingPokemonData.add(p);

        this.fileProcessor.update(PokemonService.DATA_FILE_NAME, existingPokemonData);
    }
}
