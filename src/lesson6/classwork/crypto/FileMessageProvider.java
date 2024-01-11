package lesson6.classwork.crypto;

import lesson6.classwork.crypto.encryptor.Encryptor;
import lesson6.classwork.crypto.encryptor.RSAEncryptor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class FileMessageProvider {
    public static void writeEncryptedMessage(Message<?> message, Encryptor<?> encryptor) throws IOException {
        if (encryptor instanceof CaesarEncryptor caesarEncryptor && message.key() instanceof Integer shift) {
            FileWriter file = getFile("encrypted.txt");
            file.write(caesarEncryptor.encrypt(message.content(), shift));
        } else if (encryptor instanceof RSAEncryptor rsaEncryptor && message.key() instanceof PublicKey key) {
            FileWriter file = getFile("encrypted.txt");
            file.write(rsaEncryptor.encrypt(message.content(), key));
        }
    }
    public static void writeDecryptedMessage(Message<?> message, Encryptor<?> encryptor) throws IOException {
        if (encryptor instanceof CaesarEncryptor caesarEncryptor && message.key() instanceof Integer shift) {
            FileWriter file = getFile("decrypted.txt");
            file.write(caesarEncryptor.encrypt(message.content(), shift));
        } else if (encryptor instanceof RSAEncryptor rsaEncryptor && message.key() instanceof PrivateKey key) {
            FileWriter file = getFile("decrypted.txt");
            file.write(rsaEncryptor.encrypt(message.content(), key));
        }
    }

    private static FileWriter getFile(String fileName) throws IOException {
        File file = new File(String.format("src/lesson6/classwork/crypto/%s", fileName));
        if (!file.exists()) {
            file.createNewFile();
        }
        return new FileWriter(file);
    }
}
