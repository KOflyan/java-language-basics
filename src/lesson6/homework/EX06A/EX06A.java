package lesson6.homework.EX06A;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class EX06A {

    public final static String OUTPUT_FILE_PATH = "src/lesson6/homework/princessesToSave.txt";


    public static List<List<String>> read(String inputFilePath) throws FileProcessingFailedException {
        List<List<String>> result;

        try (InputStream input = Files.newInputStream(Path.of(inputFilePath))) {
            InputStreamReader ir = new InputStreamReader(input);
            BufferedReader r = new BufferedReader(ir);

            result = r.lines()
                    .skip(3)
                    .map(EX06A::decodeLine)
                    .map(EX06A::extractInformation)
                    .toList();

        } catch (Exception e) {
            throw new FileProcessingFailedException(inputFilePath);
        }

        return result;
    }

    public static String decodeLine(String line) {
        return new String(Base64.getDecoder().decode(line));
    }

    public static List<String> extractInformation(String line) {
        return Arrays.asList(line.trim().split("\\s\\s+"));
    }

    public static boolean isWorthSaving(String status) {
        final Set<String> statusesToFilterOut = new HashSet<>(
                Arrays.asList("EATEN", "SAVED", "SLAYED THE DRAGON HERSELF")
        );

        return !statusesToFilterOut.contains(status);
    }

    public static List<List<String>> filterByStatus(List<List<String>> lines) {
        return lines.stream().filter((line) -> isWorthSaving(line.get(1))).toList();
    }

    public static List<List<String>> sortByStatus(List<List<String>> lines) {
        final Map<String, Integer> statuses = new HashMap<>(){{
            put("FIGHTS FOR LIFE", 1);
            put("INJURED", 2);
            put("IN PANIC", 3);
            put("BORED", 4);
        }};

        return lines.stream().sorted(Comparator.comparingInt(a -> statuses.get(a.get(1)))).toList();
    }

    public static void processInputFileAndTransform(String inputFilePath) throws FileProcessingFailedException {
        var lines = read(inputFilePath);

        var filteredLines = filterByStatus(lines);
        var sortedLines = sortByStatus(filteredLines);

        try (FileWriter fw = new FileWriter("src/lesson6/homework/princessesToSave.txt")) {
            BufferedWriter w = new BufferedWriter(fw);

            for (int i = 0; i < sortedLines.size(); i++) {
                var line = sortedLines.get(i);

                w.write(String.join("\n", line));

                if (i < sortedLines.size() - 1) {
                    w.write("\n");
                    w.newLine();
                }
            }
            w.flush();
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileProcessingFailedException {

        var encodedString = "c3VjY2VzcyE=";
        System.out.println(decodeLine(encodedString)); // -> success!

        System.out.println(extractInformation(
                "Marni                         FIGHTS FOR LIFE               Old Shack                     Will rule the kingdom"
        )); // -> ["Marni", "FIGHTS FOR LIFE", "Old Shack", "Will rule the kingdom"]

        List<List<String>> princesses = read("src/lesson6/homework/data/input.txt");

        System.out.println(princesses.size()); // -> 300
        System.out.println(princesses.get(0)); // -> ["Lilla", "BORED", "Abandoned Prison", "Will rule the kingdom"]
        System.out.println(princesses.get(princesses.size() - 1)); // -> ["Kellia", "BORED", "Old Shack", "None"]

        princesses = new ArrayList<>();

        princesses.add(Arrays.asList("Lilla", "BORED", "Abandoned Prison", "Will rule the kingdom"));
        princesses.add(Arrays.asList("Millicent", "FIGHTS FOR LIFE", "High Mountain", "Will rule the kingdom"));
        princesses.add(Arrays.asList("Greer", "EATEN", "Heaven", "Sassy"));
        princesses.add(Arrays.asList("Jolene", "IN PANIC", "Dungeon", "Pretty"));
        princesses.add(Arrays.asList("Felita", "SLAYED THE DRAGON HERSELF", "Library", "Will rule the kingdom"));
        princesses.add(Arrays.asList("Nataline", "SAVED", "Pub", "Likes books"));
        princesses.add(Arrays.asList("Thia", "INJURED", "Abandoned Prison", "Likes books"));

        var filtered = filterByStatus(princesses);

        System.out.println(filtered); // -> [[Lilla, BORED, Abandoned Prison, Will rule the kingdom], [Millicent, FIGHTS FOR LIFE, High Mountain, Will rule the kingdom], [Jolene, IN PANIC, Dungeon, Pretty], [Thia, INJURED, Abandoned Prison, Likes books]]
        System.out.println(sortByStatus(filtered)); // -> [[Millicent, FIGHTS FOR LIFE, High Mountain, Will rule the kingdom], [Thia, INJURED, Abandoned Prison, Likes books], [Jolene, IN PANIC, Dungeon, Pretty], [Lilla, BORED, Abandoned Prison, Will rule the kingdom]]

        processInputFileAndTransform("src/lesson6/homework/data/input.txt"); // compare to tests/correctOutput.txt
    }
}
