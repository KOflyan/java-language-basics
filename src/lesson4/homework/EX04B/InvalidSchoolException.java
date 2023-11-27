package lesson4.homework.EX04B;

public class InvalidSchoolException extends Exception {
    public InvalidSchoolException() {
        super("There is no such school!");
    }
}
