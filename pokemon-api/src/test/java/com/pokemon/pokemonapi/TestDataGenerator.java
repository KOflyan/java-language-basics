//package com.pokemon.pokemonapi;
//
//import com.pokemon.pokemonapi.pokemon.Pokemon;
//import com.pokemon.pokemonapi.trainer.Trainer;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class TestDataGenerator {
//
//    public static List<Pokemon> getPokemonData() {
//        return new ArrayList<>(Arrays.asList(
//                new Pokemon(1, 1, "Pika", "pikachu", "electric", LocalDateTime.now()),
//                new Pokemon(2, 3, "Fuf", "flaafy", "electric", LocalDateTime.now()),
//                new Pokemon(3, 4, "Puff", "jigglypuff", "fairy/normal", LocalDateTime.now()),
//                new Pokemon(4, 4, "Bo", "snorlax", "normal", LocalDateTime.now())
//        ));
//    }
//
//    public static List<Trainer> getTrainerData() {
//        return new ArrayList<>(Arrays.asList(
//                new Trainer(
//                        1,
//                        "Ash",
//                        "Ancient ruins",
//                        List.of(new Pokemon(1, 1, "Pika", "pikachu", "electric", LocalDateTime.now())),
//                        List.of("jigglypuff"),
//                        LocalDateTime.now()
//                ),
//                new Trainer(
//                        2,
//                        "Leon",
//                        null,
//                        Arrays.asList(
//                                new Pokemon(3, 4, "Puff", "jigglypuff", "fairy/normal", LocalDateTime.now()),
//                                new Pokemon(4, 4, "Bo", "snorlax", "normal", LocalDateTime.now())
//                        ),
//                        List.of("glaceon"),
//                        LocalDateTime.now()
//                )
//        ));
//    }
//}
