package com.pokemon.pokemonapi.trainer;

import com.pokemon.pokemonapi.trainer.dto.AddPokemonDto;
import com.pokemon.pokemonapi.trainer.dto.GetTrainerDto;
import com.pokemon.pokemonapi.trainer.dto.SaveTrainerDto;
import com.pokemon.pokemonapi.trainer.dto.UpdateTrainerDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<GetTrainerDto> getAllTrainers() {
        return this.trainerService.getAllTrainersWithPokemon();
    }

    @GetMapping("/{id}")
    public GetTrainerDto getTrainerById(@PathVariable("id") Integer id) {
        return this.trainerService.getTrainerById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveTrainer(@Valid @RequestBody SaveTrainerDto trainerDto) {
        this.trainerService.saveTrainer(trainerDto);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTrainer(
            @PathVariable("id") Integer id,
            @Valid @RequestBody UpdateTrainerDto trainerDto
    ) {
        this.trainerService.saveTrainer(trainerDto, id);

    }

    @PatchMapping("/{id}/addPokemon/{pokemonId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addPokemon(
            @PathVariable("id") Integer trainerId,
            @PathVariable("pokemonId") Integer pokemonId,
            @Valid @RequestBody AddPokemonDto dto
    ) {
        this.trainerService.addPokemon(trainerId, pokemonId, dto);
    }

    @PatchMapping("/{id}/addPokemonToCatch/{pokemonId}")
    public void addPokemonToCatch(
        @PathVariable("id") Integer trainerId,
        @PathVariable("pokemonId") Integer pokemonId
    ) {
        this.trainerService.addPokemonToCatch(trainerId, pokemonId);
    }
}
