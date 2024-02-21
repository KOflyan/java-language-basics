package com.pokemon.pokemonapi.trainer.dto;

import com.pokemon.pokemonapi.common.Constants;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.util.List;

public record SaveTrainerDto(
        @Length(min = 2)
        @Pattern(regexp = Constants.ALPHABETIC_REGEX)
        String name,
        @Length(min = 5)
        String username,
        @Length(min = 5)
        String password,
        String location,
        List<Integer> pokemonToCatch
) {}
