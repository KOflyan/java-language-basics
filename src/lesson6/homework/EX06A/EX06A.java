package lesson6.homework.EX06A;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.function.Function;

public class EX06A {

    public final static String OUTPUT_FILE_PATH = "src/lesson6/homework/EX06A/princessesToSave.txt";
    private static List<String> statuses = List.of(new String[]{"INJURED", "BORED", "EATEN", "SAVED",
            "IN PANIC", "SLAYED THE DRAGON HERSELF",
            "FIGHTS FOR LIFE"});
    private static List<String> dangerousLocations = List.of(new String[]{"Dark Cave", "Dungeon", "Old Shack",
            "High Mountain", "Abandoned Prison",
            "Misty Swamp", "Ancient Ruins"});
    private static List<String> safeLocations = List.of(new String[]{"Castle", "Pub", "Town Hall", "Office",
            "Library"});
    private static List<String> afterlifeLocations = List.of(new String[]{"Underworld", "Heaven"});
    private static List<String> details = List.of(new String[]{"Pretty", "Can cook", "Likes books", "Programmer",
            "Will rule the kingdom", "Afraid of spiders",
            "Sassy", "None"});

    public static List<List<String>> read(String inputFilePath) throws FileProcessingFailedException {
        List<String> data;
        List<List<String>> princesses = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
            data = reader.lines().toList();
        } catch (Exception e) {
            throw new FileProcessingFailedException(inputFilePath);
        }

        for (int i = 0; i < data.size(); i++) {
            if (i > 2) {
                princesses.add(extractInformation(decodeLine(data.get(i))));
            }
        }
        return princesses;
    }

    public static String decodeLine(String line) {
        return new String(Base64.getDecoder().decode(line));
    }

    public static List<String> extractInformation(String line) {
        List<String> lines = List.of(line.trim().split("\\s\\s+"));
        List<String> info = new ArrayList<>();

        for (int i = 0, step = 1; step < lines.size() && info.size() < 4; step++) {
            switch (info.size()) {
                case 0: {
                    if (lines.get(step).toUpperCase().equals(lines.get(step))) {
                        info.add(String.join(" ", lines.subList(i, step)));
                        i = step;
                    }
                }
                case 1: {
                    if (!lines.get(step).toUpperCase().equals(lines.get(step))) {
                        info.add(String.join(" ", lines.subList(i, step)));
                        i = step;
                    }
                }
                case 2: {
                    String location = String.join(" ", lines.subList(i, step));
                    if (dangerousLocations.contains(location) ||
                            safeLocations.contains(location) ||
                            afterlifeLocations.contains(location)) {
                        info.add(location);
                        info.add(String.join(" ", lines.subList(step, lines.size())));
                    }
                }
            }
        }

        return info;
    }

    public static List<List<String>> filterByStatus(List<List<String>> lines) {
        List<String> badStatuses = List.of(new String[]{"EATEN", "SAVED", "SLAYED THE DRAGON HERSELF"});
        lines.removeIf((princess) -> badStatuses.contains(princess.get(1)));
        return lines;
    }

    public static List<List<String>> sortByStatus(List<List<String>> lines) {
        Function<String, Integer> statusImportance = (String status) -> switch (status) {
            case "FIGHTS FOR LIFE" -> 0;
            case "INJURED" -> 1;
            case "IN PANIC" -> 2;
            case "BORED" -> 3;
            default -> Integer.MAX_VALUE;
        };

        lines.sort(Comparator.comparingInt(a -> statusImportance.apply(a.get(1))));
        return lines;
    }

    public static void processInputFileAndTransform(String inputFilePath) throws FileProcessingFailedException {
        List<List<String>> data = read(inputFilePath);
        List<List<String>> processedData = sortByStatus(filterByStatus(data));
        try {
            FileWriter writer = new FileWriter("src/lesson6/homework/EX06A/princessesToSave.txt");
            writer.write(String.join("\n\n", processedData.stream().map((a) -> String.join("\n", a)).toList()));
            writer.close();
        } catch (Exception e) {
            throw new FileProcessingFailedException("src/lesson6/homework/EX06A/princessesToSave.txt");
        }
    }

    public static void main(String[] args) throws FileProcessingFailedException {
        var encodedString = "c3VjY2VzcyE=";
        System.out.println(decodeLine(encodedString)); // -> success!

        System.out.println(extractInformation(
                "Marni                         FIGHTS FOR LIFE               Old Shack                     Will rule the kingdom"
        )); // -> ["Marni", "FIGHTS FOR LIFE", "Old Shack", "Will rule the kingdom"]

        List<List<String>> princesses = read("src/lesson6/homework/EX06A/data/input.txt");

        System.out.println(princesses.size()); // -> 300
        System.out.println(princesses.getFirst()); // -> ["Lilla", "BORED", "Abandoned Prison", "Will rule the kingdom"]
        System.out.println(princesses.getLast()); // -> ["Kellia", "BORED", "Old Shack", "None"]

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

        processInputFileAndTransform("src/lesson6/homework/EX06A/data/input.txt"); // compare to tests/correctOutput.txt
    }
}
