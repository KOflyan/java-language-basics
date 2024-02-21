package com.pokemon.pokemonapi.trainer;

import com.pokemon.pokemonapi.security.JwtService;
import com.pokemon.pokemonapi.trainer.dto.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainer")
@SecurityRequirement(name = "bearerAuth")
@CrossOrigin
public class TrainerController {

    private final TrainerService trainerService;
    private final JwtService jwtService;

    @Autowired
    public TrainerController(
            TrainerService trainerService,
            JwtService jwtService
    ) {
        this.trainerService = trainerService;
        this.jwtService = jwtService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
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

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto dto) {
        Optional<Trainer> trainer = trainerService.getTrainerByUsernameAndPassword(dto.username(), dto.password());

        if (trainer.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or password is incorrect.");
        }

        return new LoginResponseDto(
                this.jwtService.createToken(trainer.get()),
                trainer.get().getRole()
        );
    }
}
