package lesson2.classwork;

class ExerciseOne {
    public static void main(String[] args) {
        part1(30);
        part1(9);
        part1(-3);

        System.out.println("////////");

        part2Switch("REST");
        part2Switch("STUDY");
        part2Switch("WORK");

        System.out.println("--------");

        part2IfElse("REST");
        part2IfElse("STUDY");
        part2IfElse("WORK");

        System.out.println("////////");

        isDivisible(1, 1);
        isDivisible(10, -1);
        isDivisible(10, -2);
        isDivisible(10, 2);
        isDivisible(1, 2);
        isDivisible(12, 13);
        isDivisible(99999999, 999999999);

        System.out.println("////////");

        System.out.println(isGoodWeather(false, true, false, true));
        System.out.println(isGoodWeather(true, true, true, true));
        System.out.println(isGoodWeather(false, false, false, true));
        System.out.println(isGoodWeather(false, false, true, true));
    }

    private static void part1(double temperatureInCelsius) {
        if (temperatureInCelsius > 15) {
            System.out.println("It is warm outside!");
        } else if (temperatureInCelsius > 0) {
            System.out.println("It is chill outside!");
        } else {
            System.out.println("It is freezing outside!");
        }
    }

    private static void part2Switch(String task) {
        switch (task) {
            case "STUDY" -> System.out.println("It is time to study!");
            case "WORK" -> System.out.println("I will grab my coffee first...");
            case "REST" -> System.out.println("You don't have to tell me twice");
        }
    }
    private static void part2IfElse(String task) {
        if (task.equals("STUDY")) {
            System.out.println("It is time to study!");
        } else if (task.equals("WORK")) {
            System.out.println("I will grab my coffee first...");
        } else if (task.equals("REST")) {
            System.out.println("You don't have to tell me twice");
        }
    }

    private static void isDivisible(int number, int divider) {
        if (divider != 0 && number % divider == 0) {
            System.out.printf("Number %d is divisible by %d!%n", number, divider);
        } else {
            System.out.printf("Number %d is not divisible by %d!%n", number, divider);

        }
    }

    private static boolean isGoodWeather(boolean isRainy, boolean isWarm, boolean isWindy, boolean isSunny) {
        return (isSunny && isWarm) || (!isWindy && !isRainy);
    }


}
