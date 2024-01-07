package lesson6.classwork.crypto.encoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.Base64;

public class RSAEncryptor implements Encryptor<Key> {
    @Override
    public String encrypt(String input, Key publicKey) {
        try {
            Cipher encryptCipher = getCipher();
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] encrypted = encryptCipher.doFinal(input.getBytes());

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Encrypting failed!");
    }

    @Override
    public String decrypt(String input, Key privateKey) {
        try {
            Cipher decryptCipher = getCipher();
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] decrypted = decryptCipher.doFinal(Base64.getDecoder().decode(input));


            return new String(decrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Decrypting failed!");
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
