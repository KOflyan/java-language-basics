package com.pokemon.pokemonapi.pokemon;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pokemon")
public class Pokemon {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String species;

    @Column
    private String type;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;
}
