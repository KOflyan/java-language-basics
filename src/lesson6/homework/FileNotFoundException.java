package lesson6.homework;

public class FileNotFoundException extends Exception {
    public FileNotFoundException(String filePath) {
        super(String.format("File '%s' not found!", filePath));
    }
}
