package com.pokemon.pokemonapi.trainer.dto;

import com.pokemon.pokemonapi.common.Constants;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record AddPokemonDto(
        @Length(min = 2)
        @Pattern(regexp = Constants.ALPHABETIC_REGEX)
        String name,
        @Min(1)
        @Max(100)
        Integer level
) {}
