package lesson2.classwork;

public class ExerciseTwo {
    public static String greet(String name) {
        return String.format("Hello %s", name);
    }

    public static String extraEnd(String str) {
        String lastTwoCharacters = str.substring(
                str.length() - 2
        );

        return lastTwoCharacters.repeat(3);
    }

    public static void main(String[] args) {
        System.out.println(extraEnd("Hello"));
    }
}
