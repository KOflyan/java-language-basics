package com.pokemon.pokemonapi.trainer.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateTrainerDto(

        @NotNull
        @Size(min = 2)
        String name,
        String currentLocation,
        List<String> pokemonToCatch
) {
}
