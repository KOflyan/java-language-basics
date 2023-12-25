package lesson6.homework.EX06A.tests;

import lesson6.homework.EX06A.EX06A;
import lesson6.homework.EX06A.FileProcessingFailedException;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class EX06ATest {
    @Test
    public void testDecode() {
        assertEquals(
                "Libby                         SLAYED THE DRAGON HERSELF     Library                       Likes books\n",
                EX06A.decodeLine("TGliYnkgICAgICAgICAgICAgICAgICAgICAgICAgU0xBWUVEIFRIRSBEUkFHT04gSEVSU0VMRiAgICAgTGlicmFyeSAgICAgICAgICAgICAgICAgICAgICAgTGlrZXMgYm9va3MK")
        );
        assertEquals(
                "Janie                         EATEN                         Heaven                        Can cook\n",
                EX06A.decodeLine("SmFuaWUgICAgICAgICAgICAgICAgICAgICAgICAgRUFURU4gICAgICAgICAgICAgICAgICAgICAgICAgSGVhdmVuICAgICAgICAgICAgICAgICAgICAgICAgQ2FuIGNvb2sK")
        );
        assertEquals(
                "Philippa                      SLAYED THE DRAGON HERSELF     Library                       Afraid of spiders\n",
                EX06A.decodeLine("UGhpbGlwcGEgICAgICAgICAgICAgICAgICAgICAgU0xBWUVEIFRIRSBEUkFHT04gSEVSU0VMRiAgICAgTGlicmFyeSAgICAgICAgICAgICAgICAgICAgICAgQWZyYWlkIG9mIHNwaWRlcnMK")
        );
        assertEquals(
                "Janis                         INJURED                       Ancient Ruins                 Likes books\n",
                EX06A.decodeLine("SmFuaXMgICAgICAgICAgICAgICAgICAgICAgICAgSU5KVVJFRCAgICAgICAgICAgICAgICAgICAgICAgQW5jaWVudCBSdWlucyAgICAgICAgICAgICAgICAgTGlrZXMgYm9va3MK")
        );
    }

    @Test
    public void testExtractInformation() {
        assertEquals(
                new ArrayList<>(Arrays.asList("Libby", "SLAYED THE DRAGON HERSELF", "Library", "Likes books")),
                EX06A.extractInformation(
                        "Libby                         SLAYED THE DRAGON HERSELF     Library                       Likes books\n"
                )
        );
        assertEquals(
                new ArrayList<>(Arrays.asList("Janie", "EATEN", "Heaven", "Can cook")),
                EX06A.extractInformation(
                        "Janie                         EATEN                         Heaven                        Can cook\n"
                )
        );
        assertEquals(
                new ArrayList<>(Arrays.asList("Philippa", "SLAYED THE DRAGON HERSELF", "Library", "Afraid of spiders")),
                EX06A.extractInformation(
                        "Philippa                      SLAYED THE DRAGON HERSELF     Library                       Afraid of spiders\n"
                )
        );
        assertEquals(
                new ArrayList<>(Arrays.asList("Janis", "INJURED", "Ancient Ruins", "Likes books")),
                EX06A.extractInformation(
                        "Janis                         INJURED                       Ancient Ruins                 Likes books\n"
                )
        );
    }

    @Test
    public void testRead() throws FileProcessingFailedException {
        String path = "src/lesson6/homework/tests/testFile.txt";

        try (FileWriter fw = new FileWriter(path)) {
            BufferedWriter w = new BufferedWriter(fw);

            w.write(
"""
TkFNRSAgICAgICAgICAgICAgICAgICAgICAgICAgU1RBVFVTICAgICAgICAgICAgICAgICAgICAgICAgTE9DQVRJT04gICAgICAgICAgICAgICAgICAgICAgREVUQUlMUwo=
PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PT09PQo=
Cg==
TGlsbGEgICAgICAgICAgICAgICAgICAgICAgICAgQk9SRUQgICAgICAgICAgICAgICAgICAgICAgICAgQWJhbmRvbmVkIFByaXNvbiAgICAgICAgICAgICAgV2lsbCBydWxlIHRoZSBraW5nZG9tCg==
TWlsbGljZW50ICAgICAgICAgICAgICAgICAgICAgRklHSFRTIEZPUiBMSUZFICAgICAgICAgICAgICAgSGlnaCBNb3VudGFpbiAgICAgICAgICAgICAgICAgV2lsbCBydWxlIHRoZSBraW5nZG9tCg==
R3JlZXIgICAgICAgICAgICAgICAgICAgICAgICAgRUFURU4gICAgICAgICAgICAgICAgICAgICAgICAgSGVhdmVuICAgICAgICAgICAgICAgICAgICAgICAgU2Fzc3kK
TGliYnkgICAgICAgICAgICAgICAgICAgICAgICAgU0xBWUVEIFRIRSBEUkFHT04gSEVSU0VMRiAgICAgTGlicmFyeSAgICAgICAgICAgICAgICAgICAgICAgTGlrZXMgYm9va3MK
THVyZXR0ZSAgICAgICAgICAgICAgICAgICAgICAgRklHSFRTIEZPUiBMSUZFICAgICAgICAgICAgICAgQW5jaWVudCBSdWlucyAgICAgICAgICAgICAgICAgQ2FuIGNvb2sK
QXNobGllICAgICAgICAgICAgICAgICAgICAgICAgSU4gUEFOSUMgICAgICAgICAgICAgICAgICAgICAgSGlnaCBNb3VudGFpbiAgICAgICAgICAgICAgICAgU2Fzc3kK
Q29va2llICAgICAgICAgICAgICAgICAgICAgICAgSU5KVVJFRCAgICAgICAgICAgICAgICAgICAgICAgQWJhbmRvbmVkIFByaXNvbiAgICAgICAgICAgICAgV2lsbCBydWxlIHRoZSBraW5nZG9tCg==
Q2FsaWRhICAgICAgICAgICAgICAgICAgICAgICAgQk9SRUQgICAgICAgICAgICAgICAgICAgICAgICAgTWlzdHkgU3dhbXAgICAgICAgICAgICAgICAgICAgU2Fzc3kK
SGVybWlhICAgICAgICAgICAgICAgICAgICAgICAgRUFURU4gICAgICAgICAgICAgICAgICAgICAgICAgSGVhdmVuICAgICAgICAgICAgICAgICAgICAgICAgU2Fzc3kK
QnVubmllICAgICAgICAgICAgICAgICAgICAgICAgRUFURU4gICAgICAgICAgICAgICAgICAgICAgICAgSGVhdmVuICAgICAgICAgICAgICAgICAgICAgICAgQ2FuIGNvb2sK
TWFybmkgICAgICAgICAgICAgICAgICAgICAgICAgRklHSFRTIEZPUiBMSUZFICAgICAgICAgICAgICAgT2xkIFNoYWNrICAgICAgICAgICAgICAgICAgICAgV2lsbCBydWxlIHRoZSBraW5nZG9tCg==
U2hlbGwgICAgICAgICAgICAgICAgICAgICAgICAgU0xBWUVEIFRIRSBEUkFHT04gSEVSU0VMRiAgICAgVG93biBIYWxsICAgICAgICAgICAgICAgICAgICAgU2Fzc3kK
WW9zaGkgICAgICAgICAgICAgICAgICAgICAgICAgRUFURU4gICAgICAgICAgICAgICAgICAgICAgICAgVW5kZXJ3b3JsZCAgICAgICAgICAgICAgICAgICAgQ2FuIGNvb2sK
RHVsY2luZSAgICAgICAgICAgICAgICAgICAgICAgSU5KVVJFRCAgICAgICAgICAgICAgICAgICAgICAgQWJhbmRvbmVkIFByaXNvbiAgICAgICAgICAgICAgQ2FuIGNvb2sK                
""");
            w.flush();
        } catch (Exception e) {
            e.printStackTrace();

            fail(e.getMessage());
        }

        var lines = EX06A.read(path);

        assertEquals(
                new ArrayList<>(
                        Arrays.asList(
                                "Lilla", "BORED", "Abandoned Prison", "Will rule the kingdom"
                        )
                ),
                lines.get(0)
        );

        assertEquals(
                new ArrayList<>(
                        Arrays.asList(
                                "Calida", "BORED", "Misty Swamp", "Sassy"
                        )
                ),
                lines.get(lines.size() / 2)
        );

        assertEquals(
                new ArrayList<>(
                        Arrays.asList(
                                "Dulcine", "INJURED", "Abandoned Prison", "Can cook"
                        )
                ),
                lines.get(lines.size() - 1)
        );

        File f = new File(path);

        f.delete();
    }

    @Test
    public void testReadWithIncorrectPath() {
        assertThrows(FileProcessingFailedException.class, () -> EX06A.read("nonexistent.txt"));
    }

    @Test
    public void testFilterByStatus() {
        List<List<String>> initial = new ArrayList<>();
        List<List<String>> expected = new ArrayList<>();

        initial.add(Arrays.asList("Tate", "INJURED", "Ancient Ruins", "Can cook"));
        initial.add(Arrays.asList("Charita", "INJURED", "Old Shack", "Afraid of spiders"));
        initial.add(Arrays.asList("Nikoletta", "BORED", "High Mountain", "Sassy"));
        initial.add(Arrays.asList("Linnell", "EATEN", "Underworld", "Can cook"));
        initial.add(Arrays.asList("Alex", "SLAYED THE DRAGON HERSELF", "Library", "Will rule the kingdom"));
        initial.add(Arrays.asList("Krystalle", "FIGHTS FOR LIFE", "Dungeon", "Pretty"));
        initial.add(Arrays.asList("Inger", "SAVED", "Ancient Ruins", "None"));
        initial.add(Arrays.asList("Alix", "IN PANIC", "Dungeon", "None"));

        expected.add(initial.get(0));
        expected.add(initial.get(1));
        expected.add(initial.get(2));
        expected.add(initial.get(5));
        expected.add(initial.get(7));

        assertEquals(
                expected,
                EX06A.filterByStatus(initial)
        );
    }

    @Test
    public void testSortByStatus() {
        List<List<String>> initial = new ArrayList<>();
        List<List<String>> expected = new ArrayList<>();


        initial.add(Arrays.asList("Alix", "IN PANIC", "Dungeon", "None"));
        initial.add(Arrays.asList("Lurette", "INJURED", "Misty Swamp", "Sassy"));
        initial.add(Arrays.asList("Leigh", "BORED", "High Mountain", "Programmer"));
        initial.add(Arrays.asList("Doti", "BORED", "Old Shack", "Can cook"));
        initial.add(Arrays.asList("Gianna", "FIGHTS FOR LIFE", "Dungeon", "Programmer"));
        initial.add(Arrays.asList("Charla", "BORED", "Old Shack", "Programmer"));
        initial.add(Arrays.asList("Rozina", "FIGHTS FOR LIFE", "Ancient Ruins", "Will rule the kingdom"));
        initial.add(Arrays.asList("Ashly", "FIGHTS FOR LIFE", "Dungeon", "None"));
        initial.add(Arrays.asList("Claretta", "INJURED", "High Mountain", "Programmer"));
        initial.add(Arrays.asList("Anderea", "IN PANIC", "Old Shack", "Afraid of spiders"));


        expected.add(Arrays.asList("Gianna", "FIGHTS FOR LIFE", "Dungeon", "Programmer"));
        expected.add(Arrays.asList("Rozina", "FIGHTS FOR LIFE", "Ancient Ruins", "Will rule the kingdom"));
        expected.add(Arrays.asList("Ashly", "FIGHTS FOR LIFE", "Dungeon", "None"));
        expected.add(Arrays.asList("Lurette", "INJURED", "Misty Swamp", "Sassy"));
        expected.add(Arrays.asList("Claretta", "INJURED", "High Mountain", "Programmer"));
        expected.add(Arrays.asList("Alix", "IN PANIC", "Dungeon", "None"));
        expected.add(Arrays.asList("Anderea", "IN PANIC", "Old Shack", "Afraid of spiders"));
        expected.add(Arrays.asList("Leigh", "BORED", "High Mountain", "Programmer"));
        expected.add(Arrays.asList("Doti", "BORED", "Old Shack", "Can cook"));
        expected.add(Arrays.asList("Charla", "BORED", "Old Shack", "Programmer"));


        assertEquals(
                expected,
                EX06A.sortByStatus(initial)
        );
    }

    @Test
    public void testOutput() throws FileProcessingFailedException {
        String inputPath = "src/lesson6/homework/EX06A/data/input.txt";
        String correctOutputPath = "src/lesson6/homework/EX06A/tests/correctOutput.txt";

        EX06A.processInputFileAndTransform(inputPath);

        String expectedContent, actualContent;

        try (
                InputStream is = Files.newInputStream(Path.of(correctOutputPath));
                InputStream is2 = Files.newInputStream(Path.of(EX06A.OUTPUT_FILE_PATH))
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
