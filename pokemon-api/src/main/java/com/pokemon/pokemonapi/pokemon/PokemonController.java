package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.pokemon.dto.CreatePokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void savePokemon(@RequestBody CreatePokemonDto pokemonDto) {
        this.pokemonService.savePokemon(pokemonDto);
    }
}
