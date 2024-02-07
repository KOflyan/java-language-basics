package com.pokemon.pokemonapi.trainer_pokemon;

import com.pokemon.pokemonapi.pokemon.Pokemon;
import com.pokemon.pokemonapi.trainer.Trainer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity(name = "trainer_pokemon")
@NoArgsConstructor
@Getter @Setter
public class TrainerPokemon {

    public TrainerPokemon(Boolean isCaught, Pokemon pokemon, Trainer trainer) {
        this.isCaught = isCaught;
        this.pokemon = pokemon;
        this.trainer = trainer;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "is_caught")
    private Boolean isCaught;

    @Column(name = "created_at")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "trainer_id", insertable = false, updatable = false)
    private Integer trainerId;

    @Column(name = "pokemon_id", insertable = false, updatable = false)
    private Integer pokemonId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pokemon_id", nullable = false)
    private Pokemon pokemon;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Trainer trainer;
}
