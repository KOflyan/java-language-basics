package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.pokemon.dto.CreatePokemonDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return this.pokemonService.getAllPokemon();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePokemon(@RequestBody CreatePokemonDto pokemonDto) {
        this.pokemonService.savePokemon(pokemonDto);
    }
}
