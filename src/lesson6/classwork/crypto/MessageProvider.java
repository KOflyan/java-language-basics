package lesson6.classwork.crypto;

import lesson6.classwork.crypto.encryptor.Encryptor;

import java.nio.file.Path;

public interface MessageProvider {
    String OUTPUT_FOLDER = "src/lesson6/classwork/crypto";
    Path ENCRYPTED_FILE_PATH = Path.of(String.format("%s/encrypted.txt", OUTPUT_FOLDER));
    Path DECRYPTED_FILE_PATH = Path.of(String.format("%s/decrypted.txt", OUTPUT_FOLDER));

    <K> void writeEncryptedMessage(Message<K> plainMessage, Encryptor<K> encryptor);
    <K> void writeDecryptedMessage(Message<K> encryptedMessage, Encryptor<K> encryptor);
}
