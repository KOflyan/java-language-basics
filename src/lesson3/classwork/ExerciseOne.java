package lesson3.classwork;

import java.util.Random;
import java.util.Scanner;

public class ExerciseOne {

    public static void printNumbers() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    public static void printCharacters(String word) {
        int wordLength = word.length();

        for (int i = 0; i < wordLength; i++) {
//            System.out.printf("Character: %s\n", word.charAt(i));
            System.out.println("Character: " + word.charAt(i));
        }

//        for (char c : word.toCharArray()) {
//            System.out.printf("Character: %s\n", c);
//        }
    }

    public static void printEven() {
        for (int i = 1; i < 36; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }

        for (int i = 2; i < 36; i += 2) {
            System.out.println(i);
        }
    }

    public static void guessNumber() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int randomNumber = random.nextInt(1, 10);

        System.out.println("Please pick a number:");

        int guesses = 3;

//        while (guesses > 0) {
//            int number = scanner.nextInt();
//
//            if (number == randomNumber) {
//                System.out.println("You have guessed correctly!");
//                break;
//            } else {
//                System.out.printf("You have not guessed correctly, the number was %s\n", randomNumber);
//                guesses -= 1;
//            }
//        }

        for (int i = 1; i <= guesses; i++) {
            int number = scanner.nextInt();

            if (number == randomNumber) {
                System.out.println("You have guessed correctly!");
                break;
            } else {
                System.out.printf("You have not guessed correctly, the number was %s\n", randomNumber);
            }

            if (i == guesses) {
                System.out.println("Game over, you lost!");
            }
        }
    }

    public static void main(String[] args) {
//        printNumbers();
        printCharacters("Hello");
//        guessNumber();
    }
}
