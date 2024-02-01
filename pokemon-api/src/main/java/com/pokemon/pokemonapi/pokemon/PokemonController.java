package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.pokemon.dto.PokemonDto;
import com.pokemon.pokemonapi.trainer.Trainer;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePokemon(@Valid @RequestBody PokemonDto pokemonDto) {
        this.pokemonService.savePokemon(pokemonDto);
    }

    @GetMapping("/{id}")
    public Pokemon getPokemonById(@PathVariable("id") Integer id) {
        return this.pokemonService.getPokemonById(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchPokemon(@PathVariable("id") Integer id, @Valid @RequestBody PokemonDto pokemonDto) {
        this.pokemonService.updatePokemon(id, pokemonDto);
    }

    @GetMapping("/{id}/trainer")
    public Trainer getTrainerByPokemonId(@PathVariable("id") Integer id) {
        return this.pokemonService.getTrainerByPokemonId(id);
    }

    @GetMapping("/{id}/transfer/{fromTrainerId}/{toTrainerId}")
    public void transferPokemon(@PathVariable("id") Integer id, @PathVariable("fromTrainerId") Integer fromTrainerId, @PathVariable("toTrainerId") Integer toTrainerId) {
        this.pokemonService.transferPokemon(id, fromTrainerId, toTrainerId);
    }
}
