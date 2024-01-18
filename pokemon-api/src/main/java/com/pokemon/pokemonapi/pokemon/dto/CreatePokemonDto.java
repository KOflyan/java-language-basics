package com.pokemon.pokemonapi.pokemon.dto;

public record CreatePokemonDto(
    String name,
    Integer level,
    String species,
    String type
) {}
