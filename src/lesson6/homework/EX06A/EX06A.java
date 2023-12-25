package lesson6.homework.EX06A;

import java.util.*;

public class EX06A {

    public final static String OUTPUT_FILE_PATH = "src/lesson6/homework/EX06A/princessesToSave.txt";

    public static List<List<String>> read(String inputFilePath) throws FileProcessingFailedException {
        return new ArrayList<>();
    }

    public static String decodeLine(String line) {
        return "";
    }

    public static List<String> extractInformation(String line) {
        return Arrays.asList(line.trim().split("\\s\\s+"));
    }

    public static List<List<String>> filterByStatus(List<List<String>> lines) {
        return new ArrayList<>();
    }

    public static List<List<String>> sortByStatus(List<List<String>> lines) {
        return new ArrayList<>();
    }

    public static void processInputFileAndTransform(String inputFilePath) throws FileProcessingFailedException {}

    public static void main(String[] args) throws FileProcessingFailedException {
        var encodedString = "c3VjY2VzcyE=";
        System.out.println(decodeLine(encodedString)); // -> success!

        System.out.println(extractInformation(
                "Marni                         FIGHTS FOR LIFE               Old Shack                     Will rule the kingdom"
        )); // -> ["Marni", "FIGHTS FOR LIFE", "Old Shack", "Will rule the kingdom"]

        List<List<String>> princesses = read("src/lesson6/homework/EX06A/data/input.txt");

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

        processInputFileAndTransform("src/lesson6/homework/EX06A/data/input.txt"); // compare to tests/correctOutput.txt
    }
}
