package com.pokemon.pokemonapi.pokemon.dto;

import com.pokemon.pokemonapi.common.Constants;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record SaveOrUpdatePokemonDto(
    @Size(min = 3)
    @Pattern(regexp = Constants.ALPHABETIC_REGEX)
    String species,
    @Size(min = 3)
    @Pattern(regexp =  Constants.ALPHABETIC_REGEX)
    String type
) {}
