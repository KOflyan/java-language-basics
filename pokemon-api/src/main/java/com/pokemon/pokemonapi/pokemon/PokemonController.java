package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.pokemon.dto.PokemonDto;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable("id") Integer id) {
        return this.pokemonService.getPokemonById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePokemonById(
        @PathVariable("id") Integer id,
        @Valid @RequestBody PokemonDto pokemonDto
    ) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePokemon(@Valid @RequestBody PokemonDto pokemonDto) {
        this.pokemonService.savePokemon(pokemonDto);
    }
}
