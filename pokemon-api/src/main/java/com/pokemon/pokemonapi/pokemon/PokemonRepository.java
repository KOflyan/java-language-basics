package com.pokemon.pokemonapi.pokemon;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    List<Pokemon> findAllByIdIn(List<Integer> ids);
    List<Pokemon> findAllByOrderByIdAsc();
    @Transactional
    @Modifying
    @Query("UPDATE pokemon SET species = ?2, type = ?3 WHERE id = ?1")
    void update(Integer id, String species, String type);
}
