package lesson6.classwork.bus;

public class IncorrectTimeException  extends Exception {
    public IncorrectTimeException(String message) {
        super(String.format("Incorrect time: \"%s\"!", message));
    }
}
