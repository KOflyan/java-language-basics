package lesson2.classwork;

public class ExerciseOne {

    public static void displayWeatherDescription(double currentTemperature) {
        if (currentTemperature > 15) {
            System.out.println("It is warm outside!");
        } else if (currentTemperature < 15 && currentTemperature > 0) {
            System.out.println("It is chill outside!");
        } else {
            System.out.println("It is freezing outside!");
        }
    }

    public static void whatToDo(String task) {
        String message = switch (task) {
            case "STUDY" -> "It is time to study!";
            case "WORK" -> "I will grab my coffee first..";
            case "REST" -> "You don't have to tell me twice";
            default -> "Don't know what to do";
        };

        System.out.println(message);
    }

    public static void isDivisible(int number, int by) {
        if (by == 0) {
            System.out.println("Cannot divide by zero!");
            return;
        }

        if (number % by == 0) {
            System.out.println("Number X is divisible by Y!");
        } else {
            System.out.println("Number X is not divisible by Y!");
        }
    }

    public static boolean isGoodWeather(
            boolean isRainy,
            boolean isWarm,
            boolean isWindy,
            boolean isSunny
    ) {
        if (isSunny && isWarm) {
            return true;
        }

        if (!isWindy && !isRainy) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
//        displayWeatherDescription(-10);
//        whatToDo("STUDY");

    }
}
