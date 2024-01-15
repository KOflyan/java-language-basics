package lesson6.homework.EX06B.tests;

import lesson6.homework.EX06B.FileProcessingFailedException;
import lesson6.homework.EX06B.EX06B;
import lesson6.homework.EX06B.InvalidPrincessException;
import lesson6.homework.EX06B.Princess;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class EX06BTest {

    @Test
    public void testDecode() {
        assertEquals(
                "Libby                         SLAYED THE DRAGON HERSELF     Library                       Likes books\n",
                EX06B.decodeLine("TGliYnkgICAgICAgICAgICAgICAgICAgICAgICAgU0xBWUVEIFRIRSBEUkFHT04gSEVSU0VMRiAgICAgTGlicmFyeSAgICAgICAgICAgICAgICAgICAgICAgTGlrZXMgYm9va3MK")
        );
        assertEquals(
                "Janie                         EATEN                         Heaven                        Can cook\n",
                EX06B.decodeLine("SmFuaWUgICAgICAgICAgICAgICAgICAgICAgICAgRUFURU4gICAgICAgICAgICAgICAgICAgICAgICAgSGVhdmVuICAgICAgICAgICAgICAgICAgICAgICAgQ2FuIGNvb2sK")
        );
        assertEquals(
                "Philippa                      SLAYED THE DRAGON HERSELF     Library                       Afraid of spiders\n",
                EX06B.decodeLine("UGhpbGlwcGEgICAgICAgICAgICAgICAgICAgICAgU0xBWUVEIFRIRSBEUkFHT04gSEVSU0VMRiAgICAgTGlicmFyeSAgICAgICAgICAgICAgICAgICAgICAgQWZyYWlkIG9mIHNwaWRlcnMK")
        );
        assertEquals(
                "Janis                         INJURED                       Ancient Ruins                 Likes books\n",
                EX06B.decodeLine("SmFuaXMgICAgICAgICAgICAgICAgICAgICAgICAgSU5KVVJFRCAgICAgICAgICAgICAgICAgICAgICAgQW5jaWVudCBSdWlucyAgICAgICAgICAgICAgICAgTGlrZXMgYm9va3MK")
        );
    }

    @Test
    public void testExtractInformation() throws InvalidPrincessException {
        assertEquals(
                new Princess("Diane", "SLAYED THE DRAGON HERSELF", "Library", "Programmer"),
                EX06B.extractInformation(
                        "Diane                         SLAYED THE DRAGON HERSELF     Library                       Programmer\n"
                )
        );

        assertEquals(
                new Princess("Janie", "EATEN", "Heaven", "Can cook"),
                EX06B.extractInformation(
                        "Janie                         EATEN                         Heaven                        Can cook\n"
                )
        );

        assertThrows(
                InvalidPrincessException.class,
                () -> EX06B.extractInformation(
                        "Janie                         None                         Heaven                        Can cook\n"

                )
        );

        assertThrows(
                InvalidPrincessException.class,
                () -> EX06B.extractInformation(
                        "None                         EATEN                         Heaven                        Can cook\n"

                )
        );

        assertThrows(
                InvalidPrincessException.class,
                () -> EX06B.extractInformation(
                        "Janie                         EATEN                         None                        Can cook\n"

                )
        );
    }

    @Test
    public void testReadWithIncorrectPath() {
        assertThrows(FileProcessingFailedException.class, () -> EX06B.read("nonexistent.txt"));
    }

    @Test
    public void testFilterByStatus() {
        List<Princess> initial = new ArrayList<>();
        List<Princess> expected = new ArrayList<>();

        initial.add(new Princess("Tate", "INJURED", "Ancient Ruins", "Can cook"));
        initial.add(new Princess("Charita", "INJURED", "Old Shack", "Afraid of spiders"));
        initial.add(new Princess("Nikoletta", "BORED", "High Mountain", "Sassy"));
        initial.add(new Princess("Linnell", "EATEN", "Underworld", "Can cook"));
        initial.add(new Princess("Alex", "SLAYED THE DRAGON HERSELF", "Library", "Will rule the kingdom"));
        initial.add(new Princess("Krystalle", "FIGHTS FOR LIFE", "Dungeon", "Pretty"));
        initial.add(new Princess("Inger", "SAVED", "Ancient Ruins", "None"));
        initial.add(new Princess("Alix", "IN PANIC", "Dungeon", "None"));

        expected.add(initial.get(0));
        expected.add(initial.get(1));
        expected.add(initial.get(2));
        expected.add(initial.get(5));
        expected.add(initial.get(7));

        assertEquals(
                expected,
                EX06B.filterByStatus(initial)
        );
    }

    @Test
    public void testSortByStatus() throws InvalidPrincessException {
        List<Princess> initial = new ArrayList<>();
        List<Princess> expected = new ArrayList<>();


        initial.add(new Princess("Alix", "IN PANIC", "Dungeon", "None"));
        initial.add(new Princess("Lurette", "INJURED", "Misty Swamp", "Sassy"));
        initial.add(new Princess("Leigh", "BORED", "High Mountain", "Programmer"));
        initial.add(new Princess("Doti", "BORED", "Old Shack", "Can cook"));
        initial.add(new Princess("Gianna", "FIGHTS FOR LIFE", "Dungeon", "Programmer"));
        initial.add(new Princess("Charla", "BORED", "Old Shack", "Programmer"));
        initial.add(new Princess("Rozina", "FIGHTS FOR LIFE", "Ancient Ruins", "Will rule the kingdom"));
        initial.add(new Princess("Ashly", "FIGHTS FOR LIFE", "Dungeon", "None"));
        initial.add(new Princess("Claretta", "INJURED", "High Mountain", "Programmer"));
        initial.add(new Princess("Anderea", "IN PANIC", "Old Shack", "Afraid of spiders"));


        expected.add(new Princess("Gianna", "FIGHTS FOR LIFE", "Dungeon", "Programmer"));
        expected.add(new Princess("Rozina", "FIGHTS FOR LIFE", "Ancient Ruins", "Will rule the kingdom"));
        expected.add(new Princess("Ashly", "FIGHTS FOR LIFE", "Dungeon", "None"));
        expected.add(new Princess("Lurette", "INJURED", "Misty Swamp", "Sassy"));
        expected.add(new Princess("Claretta", "INJURED", "High Mountain", "Programmer"));
        expected.add(new Princess("Alix", "IN PANIC", "Dungeon", "None"));
        expected.add(new Princess("Anderea", "IN PANIC", "Old Shack", "Afraid of spiders"));
        expected.add(new Princess("Leigh", "BORED", "High Mountain", "Programmer"));
        expected.add(new Princess("Doti", "BORED", "Old Shack", "Can cook"));
        expected.add(new Princess("Charla", "BORED", "Old Shack", "Programmer"));


        assertEquals(
                expected,
                EX06B.sortByStatus(initial)
        );
    }

    @Test
    public void testSortByPlaceEmptyInput() throws InvalidPrincessException {
        assertEquals(new ArrayList<>(), EX06B.sortByPlace(new ArrayList<>()));
    }

    @Test
    public void testSortByPlace() throws InvalidPrincessException {

        List<Princess> initial = new ArrayList<>(Arrays.asList(
                new Princess("Millicent", "FIGHTS FOR LIFE", "High Mountain", "Will rule the kingdom"),
                new Princess("Albina", "FIGHTS FOR LIFE ","Ancient Ruins", "Sassy"),
                new Princess("Marni", "FIGHTS FOR LIFE", "Old Shack", "Will rule the kingdom"),
                new Princess("Albina", "FIGHTS FOR LIFE ","Ancient Ruins", "Sassy"),
                new Princess("Mona", "FIGHTS FOR LIFE", "High Mountain", "Will rule the kingdom"),
                new Princess("Paulette", "INJURED", "Dark Cave", "Can cook"),
                new Princess("Natalie", "INJURED", "High Mountain", "Afraid of spiders"),
                new Princess("Michel", "INJURED", "Old Shack", "Afraid of spiders"),
                new Princess("Caroline", "INJURED", "Dark Cave", "Can cook")
        ));
        List<Princess> expected = new ArrayList<>(Arrays.asList(
                new Princess("Millicent", "FIGHTS FOR LIFE", "High Mountain", "Will rule the kingdom"),
                new Princess("Mona", "FIGHTS FOR LIFE", "High Mountain", "Will rule the kingdom"),
                new Princess("Albina", "FIGHTS FOR LIFE ","Ancient Ruins", "Sassy"),
                new Princess("Albina", "FIGHTS FOR LIFE ","Ancient Ruins", "Sassy"),
                new Princess("Marni", "FIGHTS FOR LIFE", "Old Shack", "Will rule the kingdom"),
                new Princess("Paulette", "INJURED", "Dark Cave", "Can cook"),
                new Princess("Caroline", "INJURED", "Dark Cave", "Can cook"),
                new Princess("Natalie", "INJURED", "High Mountain", "Afraid of spiders"),
                new Princess("Michel", "INJURED", "Old Shack", "Afraid of spiders")
        ));

        assertEquals(
                expected,
                EX06B.sortByPlace(initial)
        );
    }

    @Test
    public void testSortByPlaceInvalidPrincessException() {
        assertThrows(InvalidPrincessException.class, () -> EX06B.sortByPlace(
                Collections.singletonList(new Princess("Julia", "None", "Dark Cave", "Can cook")))
        );

        for (String status : Arrays.asList("SAVED", "SLAYED THE DRAGON HERSELF")) {
            assertThrows(InvalidPrincessException.class, () -> EX06B.sortByPlace(
                    Collections.singletonList(new Princess("Julia", status, "Dark Cave", "Can cook")))

            );
        }
    }

    @Test
    public void testOutput() throws FileProcessingFailedException, InvalidPrincessException {
        String inputPath = "src/lesson6/homework/EX06B/data/input.txt";
        String correctOutputPath = "src/lesson6/homework/EX06B/tests/correctOutput.txt";

        EX06B.processInputFileAndTransform(inputPath);

        String expectedContent, actualContent;

        try (
                InputStream is = Files.newInputStream(Path.of(correctOutputPath));
                InputStream is2 = Files.newInputStream(Path.of(EX06B.OUTPUT_FILE_PATH))
        ) {
            BufferedReader r1 = new BufferedReader(new InputStreamReader(is));
            BufferedReader r2 = new BufferedReader(new InputStreamReader(is2));

            actualContent = r1.lines().collect(Collectors.joining());
            expectedContent = r2.lines().collect(Collectors.joining());

        } catch (Exception e) {
            e.printStackTrace();
            fail(e.getMessage());

            return;
        }

        assertEquals(
                expectedContent,
                actualContent
        );
    }
}
