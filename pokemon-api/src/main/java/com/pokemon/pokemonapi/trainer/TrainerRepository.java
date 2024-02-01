package com.pokemon.pokemonapi.trainer;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    Optional<Trainer> findByUsername(String username);

    @EntityGraph(attributePaths = { "caughtPokemon", "pokemonToCatch", "caughtPokemon.pokemon" })
    @Query("SELECT t FROM trainer t ORDER BY t.id ASC")
    List<Trainer> findAllWithRelations();

    @EntityGraph(attributePaths = { "caughtPokemon", "pokemonToCatch" })
    Optional<Trainer> findFirstById(Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE trainer SET name = ?1, location = ?2 WHERE id = ?3")
    void update(String name, String location, Integer id);
}
