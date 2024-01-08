package lesson6.classwork.crypto;

public record Message<K>(
    String content,
    K key
) {}
