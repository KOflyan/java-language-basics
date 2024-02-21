package com.pokemon.pokemonapi.trainer.dto;

import com.pokemon.pokemonapi.security.Role;

public record LoginResponseDto(
    String token,
    Role role
) {}
