package lesson2.homework.EX02B;


public class EX02B {
    /**
     * Return a string following the naming convention.
     * [first three letters in uppercase]-[length of string][last two letters of string in lowercase]
     * If length of string is less than 3, return "ERROR".
     *
     * @param name original brand name
     * @return converted name
     */
    public static String convertName(String name) {
        if (name.length() < 3) {
            return "ERROR";
        }

        return String.format(
                "%s-%s%s",
                name.substring(0, 3).toUpperCase(),
                name.length(),
                name.substring(name.length() - 2)
        );
    }

    /**
     * Return an expression that sums the numbers a and b.
     * Example: a = 3, b = 7 -> "3 + 7 = 10"
     *
     * @param a number
     * @param b number
     * @return string representation of addition
     */
    public static String getAdditionExpression(int a, int b) {
        return String.format("%s + %s = %s", a, b, a + b);
    }

    /**
     * Return an expression that subtracts b from a.
     * Example: a = 3, b = 1 -> "3 - 1 = 2"
     *
     * @param a number
     * @param b number
     * @return string representation of subtraction
     */
    public static String getSubtractionExpression(int a, int b) {
        return String.format("%s - %s = %s", a, b, a - b);
    }

    /**
     * Repeat the input string n times.
     * Example: repeat("-", 5) -> "-----"
     *
     * @param separator separator string, e.g. "-"
     * @param times how many times the input string is repeated
     * @return repeated string
     */
    public static String repeat(String separator, int times) {
        return separator.repeat(times);
    }

    /**
     * Create a line separator using "-". Width includes the decorators if it has any.
     * If `isDecorated` is true and width is less than 2, return an empty string ("").
     *
     * @param width width of the line, which includes the decorator, if it has one
     * @param isDecorated if True, line starts with ">" and ends with "<", if False, consists of only "-"
     * @return separator string
     */
    public static String getLineSeparator(int width, boolean isDecorated) {
        if (width == 1 && isDecorated) {
            return "";
        }

        if (isDecorated && width < 2) {
            return "";
        }

        if (isDecorated) {
            return String.format(">%s<", repeat("-", width - 2));
        }

        return repeat("-", width);
    }


    public static String display(int a, int b, String name, String operation, int width) {
        String expression;

        if (operation.equals("addition")) {
            expression = getAdditionExpression(a, b);
        } else if (operation.equals("subtraction")) {
            expression = getSubtractionExpression(a, b);
        } else {
            throw new IllegalArgumentException(String.format("Operation \"%s\" is not supported", operation));
        }

        // width of display is set to the assigned width or expression width, whichever is bigger
        int displayWidth = Math.max(width, expression.length() + 2); // + 2 for the bars ('|') at the sides

        String convertedName = convertName(name);
        String paddedName = " ".repeat(displayWidth - convertedName.length()) + convertedName;
        String decoratedSeparator = getLineSeparator(displayWidth, true);
        String separator = getLineSeparator(displayWidth, false);

        String spacesForCentering = " ".repeat((displayWidth - expression.length() - 2) / 2);

        boolean doesEqualFullLength = spacesForCentering.length() * 2 + expression.length() == displayWidth;

        String centeredExpression = String.format(
                "|%s%s%s|",
                spacesForCentering,
                expression,
                spacesForCentering + (doesEqualFullLength ? "" : " ")
        );

        return String.format("%s\n%s\n%s\n%s", paddedName, decoratedSeparator, centeredExpression, separator);
    }
}
