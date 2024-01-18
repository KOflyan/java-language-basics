package com.pokemon.pokemonapi.pokemon;

import com.pokemon.pokemonapi.pokemon.dto.CreatePokemonDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @PostMapping()
    public ResponseEntity<HttpStatus> savePokemon(@Valid CreatePokemonDto pokemonDto) {
        this.pokemonService.savePokemon(pokemonDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public List<Pokemon> getAllPokemon() {
        return this.pokemonService.getAllPokemon();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemon(@Value("id") Integer id) {
        Pokemon pokemon = this.pokemonService.getPokemon(id);
        if (pokemon == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<HttpStatus> patchPokemon(@Value("id") Integer id, @Valid CreatePokemonDto) {
        boolean resp = this.pokemonService.updatePokemon(id);
        if (resp) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
