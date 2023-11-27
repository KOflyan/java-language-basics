package lesson4.homework.EX04B;

public class InvalidWandException extends Exception {

    public InvalidWandException() {
        super("The wand like that does not exist!");
    }
}
