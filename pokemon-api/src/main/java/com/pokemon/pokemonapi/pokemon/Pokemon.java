package com.pokemon.pokemonapi.pokemon;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Pokemon{
    private Integer id;
    private Integer level;
    private String name;
    private String species;
    private String type;
    private LocalDateTime createdAt;
}

