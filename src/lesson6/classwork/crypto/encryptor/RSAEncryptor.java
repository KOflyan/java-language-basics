package lesson6.classwork.crypto.encryptor;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;

public class RSAEncryptor implements Encryptor<Key> {
    @Override
    public String encrypt(String input, Key publicKey) {
        return "";
    }

    @Override
    public String decrypt(String input, Key privateKey) {
        return "";
    }

    @Override
    public Algorithm getAlgorithm() {
        return Algorithm.RSA;
    }

    private Cipher getCipher() throws NoSuchAlgorithmException, NoSuchPaddingException {
        return Cipher.getInstance("RSA");
    }

    public KeyPair generateKeyPair() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);

            return generator.generateKeyPair();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        RSAEncryptor encryptor = new RSAEncryptor();

        KeyPair keyPair = encryptor.generateKeyPair();

        String message = encryptor.encrypt(
                "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...",
                keyPair.getPublic()
        );

        System.out.println(message);
        System.out.println(encryptor.decrypt(message, keyPair.getPrivate()));
    }
}
