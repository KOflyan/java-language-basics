package com.pokemon.pokemonapi.pokemon.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record PokemonDto(
    @Size(min = 2)
    @Pattern(regexp = "[a-zA-Z]+")
    String name,
    @Min(1)
    @Max(100)
    Integer level,
    @Size(min = 3)
    String species,
    @Size(min = 3)
    String type
) {}
