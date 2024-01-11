package lesson6.classwork.crypto.encryptor;

import lesson6.classwork.crypto.encryptor.Algorithm;
import lesson6.classwork.crypto.encryptor.Encryptor;

import java.util.Arrays;
import java.util.List;

public class CaesarEncryptor implements Encryptor<Integer> {
    @Override
    public String encrypt(String input, Integer key) {
        return cypher(input, key, true);
    }

    @Override
    public String decrypt(String input, Integer key) {
        return cypher(input, key, false);
    }

    private String cypher(String input, int shift, boolean isEncrypt) {
        char[] letters = input.toCharArray();

        for (int i = 0; i < letters.length; i++) {
            char letter = letters[i];
            if (!(letter > 64 && letter < 91) && !(letter > 96 && letter < 123)) continue;

            if (isEncrypt && (letter < 91 && letter+shift > 90 || letter+shift > 122)) {
                letter -= 26;
            } else if (!isEncrypt && (letter > 96 && letter-shift < 97 || letter-shift < 65)) {
                letter += 26;
            }
            letters[i] = (char) (letter +(isEncrypt ? 1:-1) *shift);
        }

        return new String(letters);
    }

    @Override
    public Algorithm getAlgorithm() {
        return Algorithm.CAESAR;
    }
}
