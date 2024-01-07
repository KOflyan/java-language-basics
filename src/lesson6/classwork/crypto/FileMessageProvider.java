package lesson6.classwork.crypto;

import lesson6.classwork.crypto.encoder.CaesarEncryptor;
import lesson6.classwork.crypto.encoder.Encryptor;
import lesson6.classwork.crypto.encoder.RSAEncryptor;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileMessageProvider implements MessageProvider {
    @Override
    public <K> void writeEncryptedMessage(Message<K> plainMessage, Encryptor<K> encryptor) {
        String message = encryptor.encrypt(plainMessage.content(), plainMessage.key());
        this.write(message,ENCRYPTED_FILE_PATH);
    }

    @Override
    public <K> void writeDecryptedMessage(Message<K> encryptedMessage, Encryptor<K> encryptor) {
        String message = encryptor.decrypt(encryptedMessage.content(), encryptedMessage.key());
        this.write(message, DECRYPTED_FILE_PATH);
    }

    private void write(String message, Path filePath) {
        try (BufferedWriter fw = Files.newBufferedWriter(filePath)) {
            fw.write(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        MessageProvider p = new FileMessageProvider();

        CaesarEncryptor caesarEncryptor = new CaesarEncryptor();
        RSAEncryptor rsaEncryptor = new RSAEncryptor();

        p.writeEncryptedMessage(
                new Message<>(
                        "It s pretty cold outside.",
                        25
                ),
                caesarEncryptor
        );

        p.writeDecryptedMessage(
                new Message<>(
                        "Hs r oqdssx bnkc ntsrhcd.",
                        25
                ),
                caesarEncryptor
        );

    }
}
