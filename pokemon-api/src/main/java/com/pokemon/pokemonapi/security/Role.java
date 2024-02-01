package com.pokemon.pokemonapi.security;

import lombok.Getter;

public enum Role {
    ADMIN("ADMIN"),
    USER("USER");

    @Getter
    private final String role;

    Role(String role) {
        this.role = role;
    }
}
