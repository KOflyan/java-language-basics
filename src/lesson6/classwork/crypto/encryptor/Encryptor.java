package lesson6.classwork.crypto.encryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public interface Encryptor<K> {
    String encrypt(String input, K key);
    String decrypt(String input, K key) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

    Algorithm getAlgorithm();
}
