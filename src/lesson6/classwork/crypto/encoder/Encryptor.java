package lesson6.classwork.crypto.encoder;

public interface Encryptor<K> {
    String encrypt(String input, K key);
    String decrypt(String input, K key);

    Algorithm getAlgorithm();
}
