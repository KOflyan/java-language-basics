package lesson3.homework.EX03A;

import java.util.ArrayList;
import java.util.List;

public class EX03A {

    public static String getMinLenWord(List<String> listOfWords) {
        int max = Integer.MAX_VALUE;
        String result = null;


        for (String word : listOfWords) {
            if (word.length() < max) {
                max = word.length();
                result = word;
            }
        }

        return result;
    }

    public static List<String> sortList(List<String> listOfWords) {
        List<String> result = new ArrayList<>(listOfWords.size());
        List<String> initialListCopy = new ArrayList<>(listOfWords);

        for (int i = 0; i < listOfWords.size(); i++) {
            String minLenWord = getMinLenWord(initialListCopy);

            result.add(minLenWord);
            initialListCopy.remove(minLenWord);
        }

        return result;
    }
}

