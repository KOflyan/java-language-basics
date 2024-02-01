package com.pokemon.pokemonapi.trainer.dto;

import jakarta.validation.constraints.Size;

public record PatchTrainerDto(
        @Size(min = 2)
        String name,
        String currentLocation
) {
        public boolean isValid() {
                return this.name != null || this.currentLocation != null;
        }
}
