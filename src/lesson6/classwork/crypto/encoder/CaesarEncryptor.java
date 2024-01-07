package lesson6.classwork.crypto.encoder;

public class CaesarEncryptor implements Encryptor<Integer> {
    private final String ALPHA = "abcdefghijklmnopqrstuvwxyz";

    @Override
    public String encrypt(String input, Integer key) {
        return this.encodeOrDecode(input, key, false);
    }

    @Override
    public String decrypt(String input, Integer key) {
        return this.encodeOrDecode(input, key, true);
    }

    @Override
    public Algorithm getAlgorithm() {
        return Algorithm.CAESAR;
    }

    private String encodeOrDecode(String input, int shift, boolean isDecode) {
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char letterOrSymbol = input.charAt(i);

            if (!Character.isLetter(letterOrSymbol)) {
                s.append(letterOrSymbol);
                continue;
            }

            var index = this.findIndex(letterOrSymbol, shift, isDecode);

            if (Character.isUpperCase(letterOrSymbol)) {
                letterOrSymbol = Character.toUpperCase(ALPHA.charAt(index));
            } else {
                letterOrSymbol = ALPHA.charAt(index);
            }

            s.append(letterOrSymbol);
        }

        return s.toString();
    }

    private int findIndex(char letterOrSymbol, int shift, boolean isDecode) {
        char lowerCaseLetter = Character.toLowerCase(letterOrSymbol);

        var index = ALPHA.indexOf(lowerCaseLetter) + (isDecode ? -shift : shift);


        if (isDecode && index < 0) {
            index += 26;
        } else if (!isDecode && index > ALPHA.length() - 1) {
            index -= 26;
        }

        return index;
    }

    public static void main(String[] args) {
        CaesarEncryptor encoder = new CaesarEncryptor();
        System.out.println(encoder.encrypt(
                "Why is the sky blue? Because the violet light waves are the longest. Why isn't it violet then? Hm...", 7
        ));

        System.out.println(encoder.decrypt(
                "Dof pz aol zrf isbl? Iljhbzl aol cpvsla spnoa dhclz hyl aol svunlza. Dof pzu'a pa cpvsla aolu? Ot...", 7
        ));
    }
}
