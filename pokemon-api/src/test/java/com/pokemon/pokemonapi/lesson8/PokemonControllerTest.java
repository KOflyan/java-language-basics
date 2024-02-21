//package com.pokemon.pokemonapi.lesson8;
//
//import com.pokemon.pokemonapi.TestDataGenerator;
//import com.pokemon.pokemonapi.pokemon.Pokemon;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class PokemonControllerTest extends IntegrationTestWithMockedFileProcessor {
//    @Nested
//    @DisplayName("GET /pokemon")
//    class GetPokemon {
//        @DisplayName("When endpoint is called, then should return all pokemon which were previously saved")
//        @Test
//        public void testGetAllPokemon() throws Exception {
//            mockMvc.perform(get("/pokemon"))
//                    .andExpect(status().isOk())
//                    .andExpect(content().json(objectMapper.writeValueAsString(pokemon)));
//        }
//    }
//
//    @Nested
//    @DisplayName("POST /pokemon")
//    class SavePokemon {
//        @DisplayName("When valid data & not duplicated data is provided, then should save data an return 201")
//        @Test
//        public void testSavePokemonWithValidDataAndNoConflict() throws Exception {
//            var payload = "{\"name\":\"Whiskers\",\"level\":4,\"species\":\"vaporeon\",\"type\":\"water\"}";
//
//            mockMvc.perform(
//                            post("/pokemon")
//                                    .content(payload)
//                                    .contentType(MediaType.APPLICATION_JSON)
//                    )
//                    .andExpect(status().is(HttpStatus.CREATED.value()));
//
//            var addedPokemon = updatedPokemonData.getLast();
//
//            assertThat(addedPokemon)
//                    .returns(4, Pokemon::getLevel)
//                    .returns("Whiskers", Pokemon::getName)
//                    .returns("vaporeon", Pokemon::getSpecies)
//                    .returns("water", Pokemon::getType);
//        }
//
//        @DisplayName("When duplicated data is provided, then should throw CONFLICT exception")
//        @Test
//        public void testSavePokemonWithValidDataAndDuplicate() throws Exception {
//            var payload = "{\"name\":\"Pika\",\"level\":4,\"species\":\"pikachu\",\"type\":\"electric\"}";
//
//            mockMvc.perform(
//                            post("/pokemon")
//                                    .content(payload)
//                                    .contentType(MediaType.APPLICATION_JSON)
//                    )
//                    .andExpect(status().is(HttpStatus.CONFLICT.value()));
//
//            verify(fileProcessorMock, never()).read(any(), any());
//            verify(fileProcessorMock, never()).update(any(), any());
//        }
//
//        @DisplayName("When invalid data is provided, then should throw BAD_REQUEST exception")
//        @Test
//        public void testSavePokemonWithInValidData() throws Exception {
//            mockMvc.perform(
//                            post("/pokemon")
//                                    .content("{\"name\":\"Whiskers\",\"level\":-1,\"species\":\"vaporeon\",\"type\":\"water\"}")
//                                    .contentType(MediaType.APPLICATION_JSON)
//                    )
//                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
//
//            mockMvc.perform(
//                            post("/pokemon")
//                                    .content("{\"name\":\"Whi2skers\",\"level\": 5,\"species\":\"vaporeon\",\"type\":\"water\"}")
//                                    .contentType(MediaType.APPLICATION_JSON)
//                    )
//                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
//
//            mockMvc.perform(
//                            post("/pokemon")
//                                    .content("{\"name\":\"Whiskers\",\"level\": 5,\"species\":\"vaporeon\",\"type\":\"w\"}")
//                                    .contentType(MediaType.APPLICATION_JSON)
//                    )
//                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
//        }
//    }
//
//    @Nested
//    @DisplayName("GET /pokemon/{id}")
//    class GetPokemonById {
//        @DisplayName("When pokemon with this id exists, then should return this pokemon)")
//        @Test
//        public void getPokemonByIdWithExistingPokemon() throws Exception {
//            mockMvc.perform(get("/pokemon/1"))
//                    .andExpect(status().isOk())
//                    .andExpect(content().json(objectMapper.writeValueAsString(pokemon.get(0))));
//        }
//
//        @DisplayName("When pokemon with this id does not exist, then should throw NOT_FOUND error")
//        @Test
//        public void getPokemonByIdWithNonExistent() throws Exception {
//            mockMvc.perform(get("/pokemon/999"))
//                    .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
//        }
//    }
//
//    @Nested
//    @DisplayName("PATCH /pokemon/{id}")
//    class UpdatePokemon {
//        @DisplayName("When updating existing pokemon, then should update the corresponding data")
//        @Test
//        public void updatePokemonByIdWithExistingPokemon() throws Exception {
//            mockMvc.perform(patch("/pokemon/1").content("{\"name\":\"Whiskers\",\"level\":4,\"species\":\"vaporeon\",\"type\":\"water\"}").contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().is(HttpStatus.NO_CONTENT.value()));
//
//            var updatedPokemon = updatedPokemonData.getFirst();
//
//            assertThat(updatedPokemon)
//                    .returns(1, Pokemon::getId)
//                    .returns(4, Pokemon::getLevel)
//                    .returns("Whiskers", Pokemon::getName)
//                    .returns("vaporeon", Pokemon::getSpecies)
//                    .returns("water", Pokemon::getType);
//        }
//
//        @DisplayName("When pokemon with this id does not exist, then should throw NOT_FOUND exception")
//        @Test
//        public void updatePokemonByIdWithNonExistentPokemon() throws Exception {
//            mockMvc.perform(patch("/pokemon/999").content("{\"name\":\"Whiskers\",\"level\":4,\"species\":\"vaporeon\",\"type\":\"water\"}").contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
//        }
//
//        @DisplayName("When invalid data is provided, then should throw BAD_REQUEST exception")
//        @Test
//        public void updatePokemonByIdWithInvalidData() throws Exception {
//            List<Pokemon> data = TestDataGenerator.getPokemonData();
//
//            when(fileProcessorMock.readAsList(any(), eq(Pokemon[].class))).thenReturn(data);
//
//            mockMvc.perform(patch("/pokemon/1").content("{\"name\":\"\",\"level\":4,\"species\":\"vaporeon\",\"type\":\"water\"}").contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
//
//            mockMvc.perform(patch("/pokemon/1").content("{\"name\":\"Whiskers\",\"level\":4,\"species\":\"vaporeon\",\"type\":\"w\"}").contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
//
//            mockMvc.perform(patch("/pokemon/1").content("{\"name\":\"Whiskers\",\"level\":null,\"species\":\"vaporeon\",\"type\":\"water\"}").contentType(MediaType.APPLICATION_JSON))
//                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
//        }
//    }
//
//    @Nested
//    @DisplayName("GET /api/pokemon/{id}/trainer")
//    class GetPokemonTrainer {
//        @DisplayName("When pokemon has an assigned trainer and exists in the db, then should return the pokemon data")
//        @Test
//        public void updatePokemonByIdWithExistingPokemon() throws Exception {
//            mockMvc.perform(
//                    get("/pokemon/1/trainer")
//                            .content("{\"name\":\"Whiskers\",\"level\":null,\"species\":\"vaporeon\",\"type\":\"water\"}")
//                    )
//                    .andExpect(status().isOk());
//        }
//
//        @DisplayName("When pokemon with this id does not exist, then should throw NOT_FOUND exception")
//        @Test
//        public void transferNonExistentPokemon() throws Exception {
//            mockMvc.perform(get("/pokemon/999/trainer"))
//                    .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
//        }
//
//        @DisplayName("When pokemon with this id does not have a trainer, then should return null")
//        @Test
//        public void transferPokemonWithoutTrainer() throws Exception {
//            mockMvc.perform(get("/pokemon/3/trainer"))
//                    .andExpect(status().is(HttpStatus.NOT_FOUND.value()));
//        }
//    }
//
//    @Nested
//    @DisplayName("PATCH /api/pokemon/{id}/transfer/{fromTrainerId}/{toTrainerId}")
//    class TransferPokemon {
//        @DisplayName("When pokemon with this id does not belong to the trainer, then should throw BAD_REQUEST exception")
//        @Test
//        public void transferPokemonWithoutTrainer() throws Exception {
//            mockMvc.perform(get("/pokemon/1/trainer/2/1"))
//                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
//        }
//
//        @DisplayName("When transfer is attempted for the same trainer, then should throw BAD_REQUEST exception")
//        @Test
//        public void transferPokemonToTheSameTrainer() throws Exception {
//            mockMvc.perform(get("/pokemon/1/trainer/1/1"))
//                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
//        }
//
//        @DisplayName("When pokemon can be transferred, then should do the transfer")
//        @Test
//        public void transferPokemon() throws Exception {
//            mockMvc.perform(get("/pokemon/1/transfer/1/2"))
//                    .andExpect(status().isOk());
//
//            var trainerWithoutPokemon = updatedTrainerData.get(0);
//            var trainerWithNewPokemon = updatedTrainerData.get(1);
//
//            assertThat(trainerWithoutPokemon.pokemon()).doesNotContain(pokemon.get(0));
//            assertThat(trainerWithNewPokemon.pokemon()).contains(pokemon.get(0));
//        }
//    }
//}
