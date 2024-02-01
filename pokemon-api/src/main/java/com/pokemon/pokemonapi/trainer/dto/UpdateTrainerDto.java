package com.pokemon.pokemonapi.trainer.dto;

import com.pokemon.pokemonapi.common.Constants;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public record UpdateTrainerDto(
    @Length(min = 2)
    @Pattern(regexp = Constants.ALPHABETIC_REGEX)
    String name,
    String location
) {}
