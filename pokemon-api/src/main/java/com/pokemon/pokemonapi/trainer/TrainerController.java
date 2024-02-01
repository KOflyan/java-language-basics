package com.pokemon.pokemonapi.trainer;

import com.pokemon.pokemonapi.trainer.dto.CreateTrainerDto;
import com.pokemon.pokemonapi.trainer.dto.PatchTrainerDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {
    private final TrainerService service;

    @Autowired
    public TrainerController(TrainerService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void saveTrainer(@Valid @RequestBody CreateTrainerDto createTrainerDto) {
        this.service.saveTrainer(createTrainerDto);
    }

    @GetMapping
    public List<Trainer> getAllTrainers() {
        return this.service.getAllTrainers();
    }

    @GetMapping("/{id}")
    public Trainer getTrainerById(@PathVariable("id") Integer id) {
        return this.service.getTrainerById(id);
    }

    @PatchMapping("/{id}")
    public void updateTrainerById(@PathVariable("id") Integer id, @Valid PatchTrainerDto patchTrainerDto) {
        this.service.updateTrainerById(id, patchTrainerDto);
    }

    @PatchMapping("/{trainerId}/addPokemon/{pokemonId}")
    public void catchPokemon(@PathVariable("trainerId") Integer trainerId, @PathVariable("pokemonId") Integer pokemonId) {
        this.service.catchPokemon(trainerId, pokemonId);
    }
    @PatchMapping("/{id}/addPokemonToCatch/{species}")
    public void addPokemonToCatch(@PathVariable("id") Integer id, @PathVariable("species") String species) {
        this.service.addPokemonToCatch(id, species);
    }
}
