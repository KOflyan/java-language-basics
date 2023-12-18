package lesson3.classwork;

public class ExerciseFive {

    public static int sum2(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        if (array.length == 1) {
            return array[0];
        }

        return array[0] + array[1];
    }

    public static boolean lucky13(int[] array) {
        for (int element : array) {
            if (element == 1 || element == 3) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(sum2(new int[]{1, 2, 3}));
        System.out.println(sum2(new int[]{1, 1}));
        System.out.println(sum2(new int[]{1, 1, 1, 1}));

        System.out.println(sum2(null));
        System.out.println(sum2(new int[] {}));
    }
}
