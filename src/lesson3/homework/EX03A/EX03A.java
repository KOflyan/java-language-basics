package lesson3.homework.EX03A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EX03A {

    /**
     * Method to find and return the minimum length word in `listOfWords`.
     * If two words are of the same length, the word appearing first must also be returned first.
     *
     * @param listOfWords list of words to look through
     * @return smallest length word from `listOfWords`.
     */
    public static String getMinLenWord(List<String> listOfWords) {
        return null;
    }

    /**
     * Method to sort `listOfWords` by the length of its elements.
     * This method must utilize getMinLenWord().
     *
     * @param listOfWords list of words to be sorted
     * @return sorted list of words
     */
    public static List<String> sortList(List<String> listOfWords) {
        return new ArrayList<>();
    }


    public static void main(String[] args) {
        System.out.println(getMinLenWord(Collections.emptyList())); // -> null
        System.out.println(getMinLenWord(Arrays.asList("Hello", "there"))); // -> "Hello"
        System.out.println(getMinLenWord(Arrays.asList("house", "tent", "home"))); // -> "tent"
        System.out.println(sortList(Arrays.asList("monosaccharide", "augmented", "justify", "rest", "afterlife", "tea"))); // -> ["tea", "rest", "justify", "augmented", "afterlife", "monosaccharide"]
        System.out.println(sortList(Arrays.asList("a", "bcd", "bc"))); // -> ["a", "bc", "bcd"]
    }
}
