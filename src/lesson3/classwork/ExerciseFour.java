package lesson3.classwork;

public class ExerciseFour {
    public static String conCat(
            String str1,
            String str2
    ) {
        if (str1.length() == 0 || str2.length() == 0) {
            return str1 + str2;
        }

        char lastCharacterOfTheFirstString = str1.charAt(str1.length() - 1);
        char firstCharacterOfTheLastString = str2.charAt(0);

        if (lastCharacterOfTheFirstString != firstCharacterOfTheLastString) {
            return str1 + str2;
        }

        return str1.substring(0, str1.length() - 1) + str2;
    }

    public static String lastTwo(String str) {

        if (str == null || str.length() == 0) {
            return "ERROR";
        }

        char lastChar = str.charAt(str.length() - 1);
        char lastBeforeLastChar = str.charAt(str.length() - 2);
        String wordBeforeLastTwoChars = str.substring(0, str.length() - 2);

        return wordBeforeLastTwoChars + lastChar + lastBeforeLastChar;
    }

    public static int countHi(String str) {
        int count = 0;

        for (int i = 0; i < str.length() - 1; i++) {
            String stringToCheck = str.substring(i, i + 2);

            if (stringToCheck.equals("hi")) {
                count += 1;
                i++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countHi("abc hi ho"));
        System.out.println(countHi("ABChi hi"));
        System.out.println(countHi("hihi"));
    }
}
