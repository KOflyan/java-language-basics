package lesson3.classwork;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExerciseTwo {

    public static void printArray() {
        String[] fruits = { "Kiwi", "Apple", "Pear" };

        List<String> fruitsList = new ArrayList<>(
                Arrays.asList(fruits)
        );

//        System.out.println(Arrays.toString(fruits));

        for (String fruit : fruitsList) {
            System.out.println(fruit);
        }
    }

    public static void deleteFromArray(List<String> array, String value) {

        // TODO
        String[] result = array.toArray(new String[0]);

        System.out.println(result.length);
//        String[] newArray = new String[array.length - 1];
//
//        for (int i = 0; i < array.length; i++) {
//            String element = array[i];
//
//            if (element.equals(value)) {
//                continue;
//            }
//
//            newArray[i] = element;
//        }
    }



    public static void main(String[] args) {
        String[] fruits = { "Kiwi", "Apple", "Pear" };

        List<String> fruitsList = new ArrayList<>(
                Arrays.asList("Kiwi", "Apple", "Pear")
        );

        String[] result = fruitsList.toArray(
                new String[0]
        );

        System.out.println(result.length);
//        printArray();

    }
}
