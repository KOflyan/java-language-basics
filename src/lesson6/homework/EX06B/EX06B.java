package lesson6.homework.EX06B;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class EX06B {

    public static final String OUTPUT_FILE_PATH = "src/lesson6/homework/EX06B/princessesToSave.txt";
    private static final String HEADER =
"""
NAME                STATUS              PLACE               DETAILS
====================================================================

""";

    public static List<Princess> read(String inputFilePath) throws FileProcessingFailedException {
        List<Princess> result = new ArrayList<>();

        try (InputStream input = Files.newInputStream(Path.of(inputFilePath))) {
            InputStreamReader ir = new InputStreamReader(input);
            BufferedReader r = new BufferedReader(ir);

            List<String> decodedLines = r.lines()
                    .skip(3)
                    .map(EX06B::decodeLine)
                    .toList();

            for (String line : decodedLines) {
                result.add(extractInformation(line));
            }

        } catch (Exception e) {
            throw new FileProcessingFailedException(inputFilePath);
        }

        return result;
    }

    public static String decodeLine(String line) {
        return new String(Base64.getDecoder().decode(line));
    }

    public static Princess extractInformation(String line) throws InvalidPrincessException {
        List<String> lineAsList = Arrays.asList(line.trim().split("\\s\\s+"));

        Princess princess = new Princess(
                lineAsList.get(0),
                lineAsList.get(1),
                lineAsList.get(2),
                lineAsList.get(3)
        );

        if (princess.name().equals("None") || princess.location().equals("None") || princess.status().equals("None")) {
            throw new InvalidPrincessException("Invalid princess!");
        }

        return princess;
    }

    public static List<Princess> sortByPlace(List<Princess> princesses) throws InvalidPrincessException {
        Map<String, List<Princess>> princessesByLocation = new LinkedHashMap<>();

        for (Princess princess : princesses) {
            var key = String.format("%s-%s", princess.status(), princess.location());
            var princessesInLocation = princessesByLocation.getOrDefault(
                    key,
                    new ArrayList<>()
            );

            Set<String> invalidStatuses = new HashSet<>(
                    Arrays.asList("SAVED", "EATEN", "SLAYED THE DRAGON HERSELF")
            );

            if (princess.status().equals("None")) {
                throw new InvalidPrincessException("Invalid princess!");
            }

            if (invalidStatuses.contains(princess.status())) {
                throw new InvalidPrincessException(String.format("The princess is already %s!", princess.status()));
            }

            princessesInLocation.add(princess);

            princessesByLocation.put(key, princessesInLocation);
        }

        return princessesByLocation.values().stream().reduce((acc, curr) -> {
            acc.addAll(curr);
            return acc;
        }).orElse(new ArrayList<>());
    }

    private static boolean isWorthSaving(String status) {
        final Set<String> statusesToFilterOut = new HashSet<>(
                Arrays.asList("EATEN", "SAVED", "SLAYED THE DRAGON HERSELF")
        );

        return !statusesToFilterOut.contains(status);
    }

    public static List<Princess> filterByStatus(List<Princess> princesses) {
        return princesses.stream().filter((princess) -> isWorthSaving(princess.status())).toList();
    }

    public static List<Princess> sortByStatus(List<Princess> lines) {
        final Map<String, Integer> statuses = new HashMap<>(){{
            put("FIGHTS FOR LIFE", 1);
            put("INJURED", 2);
            put("IN PANIC", 3);
            put("BORED", 4);
        }};

        return lines.stream().sorted(Comparator.comparingInt(a -> statuses.get(a.status()))).toList();
    }

    public static void processInputFileAndTransform(String inputFilePath) throws FileProcessingFailedException, InvalidPrincessException {
        var lines = read(inputFilePath);

        var filteredPrincesses = filterByStatus(lines);
        var sortedPrincesses = sortByStatus(filteredPrincesses);
        var groupedPrincesses = sortByPlace(sortedPrincesses);

        try (FileWriter fw = new FileWriter("src/lesson6/homework/EX06B/princessesToSave.txt")) {
            BufferedWriter w = new BufferedWriter(fw);

            fw.write(HEADER);

            for (int i = 0; i < groupedPrincesses.size(); i++) {
                var princess = groupedPrincesses.get(i);

                w.write(princess.toString());

                if (i < groupedPrincesses.size() - 1) {
                    w.newLine();
                }
            }
            w.flush();
            w.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileProcessingFailedException, InvalidPrincessException {
        processInputFileAndTransform("src/lesson6/homework/EX06B/data/input.txt"); // compare to tests/correctOutput.txt
    }
}
