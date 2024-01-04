package lesson3.homework.EX03B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EX03B {

    private static final String SYMBOLS = ".,;?!\"";

    private static List<Character> getSortedListOfCharacters(String word) {
        return word
            .replaceAll("'", "")
            .chars()
            .mapToObj(c -> (char) c)
            .sorted(Comparator.comparingInt(Character::toLowerCase))
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public static String scrambleWord(String word) {
        if (word.trim().length() < 2) {
            return word;
        }

        int endIndex = word.length() - 1;

        if (EX03B.SYMBOLS.contains(Character.toString(word.charAt(endIndex)))) {
            endIndex -= 1;
        }

        String wordToSort = word.substring(1, endIndex);
        int apostropheIndex = wordToSort.indexOf("'");

        List<Character> listOfCharacters = getSortedListOfCharacters(wordToSort);

        if (apostropheIndex != -1) {
            listOfCharacters.add(apostropheIndex, '\'');
        }

        StringBuilder result = new StringBuilder();

        result.append(word.charAt(0));

        for (Character c : listOfCharacters) {
            result.append(c.toString());
        }

        return result.append(word.substring(endIndex)).toString();
    }

    public static String scrambleSentence(String sentence) {
        String[] words = sentence.split(" ");

        StringBuilder scrambledSentence = new StringBuilder();

        for (String word : words) {
            String scrambledWord = scrambleWord(word);
            scrambledSentence.append(scrambledWord).append(" ");
        }

        return scrambledSentence.toString().trim();
    }
}
