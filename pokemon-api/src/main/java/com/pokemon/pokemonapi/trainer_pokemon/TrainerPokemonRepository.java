package com.pokemon.pokemonapi.trainer_pokemon;

import com.pokemon.pokemonapi.trainer.Trainer;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TrainerPokemonRepository extends JpaRepository<TrainerPokemon, Integer> {

    boolean existsByPokemonIdAndTrainerIdAndIsCaughtIsTrue(Integer pokemonId, Integer trainerId);

    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = "INSERT INTO trainer_pokemon (trainer_id, pokemon_id, is_caught) VALUES (?1, ?2, false)"
    )
    void insertPokemonToCatch(Integer trainerId, Integer pokemonId);

    @Transactional
    @Modifying
    @Query(
            nativeQuery = true,
            value = """
    INSERT INTO trainer_pokemon (trainer_id, pokemon_id, name, level, is_caught)
    VALUES (?1, ?2, ?3, ?4, true)
    ON CONFLICT (trainer_id, pokemon_id) DO UPDATE
    SET trainer_id = ?1, pokemon_id = ?2, name = ?3, level = ?4, is_caught = true;
"""
    )
    void upsert(Integer trainerId, Integer pokemonId, String name, Integer level);

    @Transactional
    @Modifying
    @Query("UPDATE trainer_pokemon SET trainerId = ?1 WHERE trainerId = ?2 AND pokemonId = ?3")
    void updateTrainerId(Integer updateToTrainerId, Integer updateFromTrainerId, Integer pokemonId);

    @Query("SELECT t FROM trainer t JOIN FETCH trainer_pokemon tp ON tp.trainerId = t.id AND tp.pokemonId = ?1 AND tp.isCaught")
    List<Trainer> findAllTrainersForPokemon(Integer id);

}
