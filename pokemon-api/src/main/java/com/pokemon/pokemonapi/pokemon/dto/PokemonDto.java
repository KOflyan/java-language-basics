package com.pokemon.pokemonapi.pokemon.dto;

import jakarta.validation.constraints.*;

public record PokemonDto(
    @Pattern(regexp="[A-Za-z]+")
    @Size(min = 3)
    @NotNull
    String name,
    @Min(value = 1)
    @Max(value = 100)
    @NotNull
    Integer level,
    @Size(min = 3)
    @NotNull
    String species,
    @Size(min = 3)
    @NotNull
    String type
) {}
