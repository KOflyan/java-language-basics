package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.pokemon.dto.SaveOrUpdatePokemonDto;
import com.pokemon.pokemonapi.trainer.Trainer;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
@SecurityRequirement(name = "bearerAuth")
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
        @Valid @RequestBody SaveOrUpdatePokemonDto pokemonDto
    ) {
        this.pokemonService.savePokemon(pokemonDto, id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePokemon(@Valid @RequestBody SaveOrUpdatePokemonDto pokemonDto) {
        this.pokemonService.savePokemon(pokemonDto);
    }

    @GetMapping("{id}/trainer")
    public List<Trainer> getPokemonTrainers(@PathVariable("id") Integer pokemonId) {
        return this.pokemonService.getPokemonTrainers(pokemonId);
    }

    @PatchMapping("{id}/transfer/{fromTrainerId}/{toTrainerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void transferPokemon(
            @PathVariable("id") Integer pokemonId,
            @PathVariable("fromTrainerId") Integer fromTrainerId,
            @PathVariable("toTrainerId") Integer toTrainerId
    ) {
        if (fromTrainerId.equals(toTrainerId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        this.pokemonService.transferPokemon(pokemonId, fromTrainerId, toTrainerId);
    }
}
