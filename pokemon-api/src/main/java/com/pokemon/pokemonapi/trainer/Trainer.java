package com.pokemon.pokemonapi.trainer;

import com.pokemon.pokemonapi.pokemon.Pokemon;
import com.pokemon.pokemonapi.security.Role;
import com.pokemon.pokemonapi.trainer_pokemon.TrainerPokemon;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.*;

import java.time.LocalDateTime;
import java.util.Set;

@NoArgsConstructor
@Getter @Setter
@Entity(name = "trainer")
public class Trainer {
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column
    private String location;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "trainer", fetch = FetchType.LAZY)
    @SQLRestriction("is_caught")
    private Set<TrainerPokemon> caughtPokemon;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "trainer_pokemon",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id")
    )
    @SQLJoinTableRestriction("NOT is_caught")
    private Set<Pokemon> pokemonToCatch;
}
