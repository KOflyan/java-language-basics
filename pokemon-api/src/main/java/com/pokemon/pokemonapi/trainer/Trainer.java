package com.pokemon.pokemonapi.trainer;

import com.pokemon.pokemonapi.pokemon.Pokemon;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class Trainer{
        private Integer id;
        private String name;
        private String currentLocation;
        private List<Pokemon> pokemon;
        private List<String> pokemonToCatch;
        private LocalDateTime createdAt;
}
