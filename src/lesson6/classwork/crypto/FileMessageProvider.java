package lesson6.classwork.crypto;

import lesson6.classwork.crypto.encryptor.CaesarEncryptor;
import lesson6.classwork.crypto.encryptor.Encryptor;
import lesson6.classwork.crypto.encryptor.RSAEncryptor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;

public class FileMessageProvider {
    public FileMessageProvider() {
    }

    private static FileWriter getFile(String fileName) throws IOException {
        File file = new File(String.format("src/lesson6/classwork/crypto/%s", fileName));
        if (!file.exists()) {
            file.createNewFile();
        }
        return new FileWriter(file);
    }

    public void writeEncryptedMessage(Message<?> message, Encryptor<?> encryptor) {
        try {
            FileWriter writer = getFile("encrypted.txt");
            if (encryptor instanceof CaesarEncryptor caesarEncryptor && message.key() instanceof Integer shift) {
                writer.write(caesarEncryptor.encrypt(message.content(), shift));
            } else if (encryptor instanceof RSAEncryptor rsaEncryptor && message.key() instanceof PublicKey key) {
                writer.write(rsaEncryptor.encrypt(message.content(), key));
            }
            writer.close();

        } catch (Exception e) {
            System.out.println("couldn't write to file");
        }

    }

    public void writeDecryptedMessage(Message<?> message, Encryptor<?> encryptor) {
        try {
            FileWriter writer = getFile("decrypted.txt");
            if (encryptor instanceof CaesarEncryptor caesarEncryptor && message.key() instanceof Integer shift) {
                writer.write(caesarEncryptor.decrypt(message.content(), shift));
            } else if (encryptor instanceof RSAEncryptor rsaEncryptor && message.key() instanceof PrivateKey key) {
                writer.write(rsaEncryptor.decrypt(message.content(), key));
            }
            writer.close();
        } catch (Exception e) {
            System.out.println("couldn't write to file");
        }
    }
}
