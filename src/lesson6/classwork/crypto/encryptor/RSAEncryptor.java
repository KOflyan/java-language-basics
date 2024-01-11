package lesson6.classwork.crypto.encryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;
import java.util.Base64;

public class RSAEncryptor implements Encryptor<Key> {
    @Override
    public String encrypt(String input, Key publicKey) {
        try {
            Cipher cipher = getCipher();
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] msg = cipher.doFinal(input.getBytes());
            return Base64.getEncoder().encodeToString(msg);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String decrypt(String input, Key privateKey) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        try {
            Cipher cipher = getCipher();
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] msg = cipher.doFinal(input.getBytes());
            return new String(msg, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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

    public static void main(String[] args) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
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
