package lesson3.homework.EX03B;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class EX03B {

    /**
     * Sort a word alphabetically, keeping only the apostrophe, first and last letter as they were.
     * <p>
     * If the last letter of a word is a symbol (.,;?!") the second to last letter must remain the same.
     * If the word can't be changed from the original, the initial word must be returned.
     * When sorting, treat every letter as lowercase.
     *
     * @param word input word
     * @return alphabetically scrambled word
     */
    public static String scrambleWord(String word) {
        if (word.length() < 3) return word;

        List<Character> original = word.chars().mapToObj(c -> (char) c).collect(Collectors.toList());;
        List<Character> scrambled = new ArrayList<>(List.of(original.removeFirst(), original.removeLast()));
        int upperComaIndex;

        // makes sure the scrambling happens between the first and last letter
        if (scrambled.getLast().toString().matches("[.,:?!']")) {
            scrambled.add(1, original.removeLast());
        }

        // scrambles the word without the upper coma
        if ((upperComaIndex = original.indexOf('\'')) > -1) original.remove(upperComaIndex);
        original.sort(Comparator.comparingInt(Character::toLowerCase));
        if (upperComaIndex > -1) original.add(upperComaIndex, '\'');

        scrambled.addAll(1, original);
        return scrambled.stream().map(String::valueOf).collect(Collectors.joining());
    }

    /**
     * Method to change all words in sentence using scramble_word() method.
     *
     * @param sentence: sentence to scramble
     * @return scrambled sentence
     */
    public static String scrambleSentence(String sentence) {
        StringJoiner scrambled = new StringJoiner(" ");
        for (String word : sentence.split(" ")) {
            scrambled.add(scrambleWord(word));
        }
        return scrambled.toString();
    }
}
