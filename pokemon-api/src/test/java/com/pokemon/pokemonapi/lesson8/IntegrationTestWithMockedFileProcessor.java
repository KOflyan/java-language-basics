//package com.pokemon.pokemonapi.lesson8;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.pokemon.pokemonapi.BaseIntegrationTest;
//import com.pokemon.pokemonapi.TestDataGenerator;
//import com.pokemon.pokemonapi.common.FileProcessor;
//import com.pokemon.pokemonapi.pokemon.Pokemon;
//import com.pokemon.pokemonapi.trainer.Trainer;
//import org.junit.jupiter.api.BeforeEach;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.when;
//
//public abstract class IntegrationTestWithMockedFileProcessor extends BaseIntegrationTest {
//    @Autowired
//    protected ObjectMapper objectMapper;
//
//    @MockBean
//    protected FileProcessor fileProcessorMock;
//
//    protected List<Pokemon> pokemon;
//    protected List<Trainer> trainers;
//    protected List<Pokemon> updatedPokemonData;
//    protected List<Trainer> updatedTrainerData;
//
//    @BeforeEach
//    public void before() {
//        pokemon = TestDataGenerator.getPokemonData();
//        trainers = TestDataGenerator.getTrainerData();
//
//        updatedPokemonData = new ArrayList<>();
//        updatedTrainerData = new ArrayList<>();
//
//        when(fileProcessorMock.readAsList(any(), eq(Pokemon[].class))).thenReturn(pokemon);
//        when(fileProcessorMock.readAsList(any(), eq(Trainer[].class))).thenReturn(trainers);
//
//        when(fileProcessorMock.update(eq("pokemon.json"), any()))
//                .then((invocation) -> updatedPokemonData.addAll(invocation.getArgument(1)));
//
//        when(fileProcessorMock.update(eq("trainer.json"), any()))
//                .then((invocation) -> updatedPokemonData.addAll(invocation.getArgument(1)));
//    }
//}
