package com.pokemon.pokemonapi.pokemon;

import java.time.LocalDateTime;

public record Pokemon(
    Integer id,
    Integer level,
    String name,
    String species,
    String type,
    LocalDateTime createdAt
) {}
