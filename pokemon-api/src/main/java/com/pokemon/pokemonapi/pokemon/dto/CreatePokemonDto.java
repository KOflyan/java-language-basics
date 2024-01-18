package com.pokemon.pokemonapi.pokemon.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public record CreatePokemonDto(
    @Pattern(regexp="^[A-Za-z]*$",message = "{validation.name.is_not_alphabetical}")
    @Min(value = 2, message = "{validation.name.size.too_short}")
    String name,
    @Min(value = 1, message = "{validation.level.too_small}")
    @Max(value = 100, message = "{validation.level.too_big}")
    Integer level,
    @Pattern(regexp="^[A-Za-z]*$",message = "{validation.species.is_not_alphabetical}")
    @Min(value = 3, message = "{validation.species.size.too_short}")
    String species,
    @Pattern(regexp="^[A-Za-z]*$",message = "{validation.type.is_not_alphabetical}")
    @Min(value = 3, message = "{validation.type.size.too_short}")
    String type
) {}
