package com.pokemon.pokemonapi.trainer;

import com.pokemon.pokemonapi.pokemon.Pokemon;

import java.time.LocalDateTime;
import java.util.List;

public record Trainer(
        Integer id,
        String name,
        String currentLocation,
        List<Pokemon> pokemon,
        List<String> pokemonToCatch,
        LocalDateTime createdAt
) {}
