package lesson6.homework.EX06A;

public class FileProcessingFailedException extends Exception {
    public FileProcessingFailedException(String filePath) {
        super(String.format("File '%s' not found!", filePath));
    }
}
