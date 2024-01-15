package lesson6.homework.EX06B;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class EX06B {

    public static final String OUTPUT_FILE_PATH = "src/lesson6/homework/EX06B/princessesToSave.txt";

    private static final List<String> dangerousLocations = List.of(new String[]{"Dark Cave", "Dungeon", "Old Shack",
            "High Mountain", "Abandoned Prison",
            "Misty Swamp", "Ancient Ruins"});
    private static final List<String> safeLocations = List.of(new String[]{"Castle", "Pub", "Town Hall", "Office",
            "Library"});
    private static final List<String> afterlifeLocations = List.of(new String[]{"Underworld", "Heaven"});
    private static final String HEADER =
            """
                    NAME                STATUS              PLACE               DETAILS
                    ====================================================================

                    """;

    public static List<Princess> read(String inputFilePath) throws FileProcessingFailedException, InvalidPrincessException {
        List<String> data;
        List<Princess> princesses = new ArrayList<>();
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

    public static Princess extractInformation(String line) throws InvalidPrincessException {
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
                            afterlifeLocations.contains(location) ||
                        location.equals("None")) {
                        info.add(location);
                        info.add(String.join(" ", lines.subList(step, lines.size())));
                    }
                }
            }
        }

        Princess princess = new Princess(info.getFirst(), info.get(1), info.get(2), info.getLast());
        if (princess.isInvalid()) throw new InvalidPrincessException("Invalid princess!");

        return princess;
    }

    public static List<Princess> sortByPlace(List<Princess> princesses) throws InvalidPrincessException {
        validatePrincesses(princesses);

        Comparator<Princess> comparator = (a,b) -> {
            if (a.getStatusValue() != b.getStatusValue() || a.location().equals(b.location())) return 0;
            int aMinInt = Integer.MAX_VALUE;
            int bMinInt = Integer.MAX_VALUE;
            for (int i = princesses.size()-1; i > -1; i--) {
                Princess p = princesses.get(i);
                if (a.getStatusValue() == p.getStatusValue() && a.location().equals(p.location())) {
                    aMinInt = i;
                } else if (b.getStatusValue() == p.getStatusValue() && b.location().equals(p.location())) {
                    bMinInt = i;
                }
            }
            return aMinInt - bMinInt;
        };

        princesses.sort(comparator);
        return princesses;
    }

    public static List<Princess> filterByStatus(List<Princess> princesses) {
        List<String> badStatuses = List.of(new String[]{"EATEN", "SAVED", "SLAYED THE DRAGON HERSELF"});
        princesses.removeIf((princess) -> badStatuses.contains(princess.status()));
        return princesses;
    }

    public static List<Princess> sortByStatus(List<Princess> lines) throws InvalidPrincessException {
        validatePrincesses(lines);
        lines.sort(Comparator.comparingInt(Princess::getStatusValue));
        return lines;
    }

    private static void validatePrincesses(List<Princess> lines) throws InvalidPrincessException {
        for (Princess princess : lines) {
            if (princess.isInvalid()) {
                throw new InvalidPrincessException("Invalid princess!");
            } else if (princess.isDealtWith()) {
                throw new InvalidPrincessException(String.format("The princess is already %s!", princess.status()));
            }
        }
        ;
    }

    public static void processInputFileAndTransform(String inputFilePath) throws FileProcessingFailedException, InvalidPrincessException {
        List<Princess> data = read(inputFilePath);
        List<Princess> processedData = sortByPlace(sortByStatus(filterByStatus(data)));
        try {
            FileWriter writer = new FileWriter(OUTPUT_FILE_PATH);
            writer.write(HEADER);
            writer.write(String.join("\n", processedData.stream().map(Princess::toString).toList()));
            writer.close();
        } catch (Exception e) {
            throw new FileProcessingFailedException(OUTPUT_FILE_PATH);
        }
    }

    public static void main(String[] args) throws FileProcessingFailedException, InvalidPrincessException {
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
        System.out.println(sortByPlace(initial).toString().replaceAll(",", "\n"));
        // processInputFileAndTransform("src/lesson6/homework/EX06B/data/input.txt"); // compare to tests/correctOutput.txt
    }
}
