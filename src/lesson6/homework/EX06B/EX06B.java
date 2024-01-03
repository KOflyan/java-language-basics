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
        return new ArrayList<>();
    }

    public static String decodeLine(String line) {
        return "";
    }

    public static Princess extractInformation(String line) throws InvalidPrincessException {
        return null;
    }

    public static List<Princess> sortByPlace(List<Princess> princesses) throws InvalidPrincessException {
        return new ArrayList<>();
    }

    public static List<Princess> filterByStatus(List<Princess> princesses) {
        return new ArrayList<>();
    }

    public static List<Princess> sortByStatus(List<Princess> lines) {
        return new ArrayList<>();
    }

    public static void processInputFileAndTransform(String inputFilePath) throws FileProcessingFailedException, InvalidPrincessException {
    }

    public static void main(String[] args) throws FileProcessingFailedException, InvalidPrincessException {
        processInputFileAndTransform("src/lesson6/homework/EX06B/data/input.txt"); // compare to tests/correctOutput.txt
    }
}
