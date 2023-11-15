package homework.EX02B;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EX02BTest {

    private static final Random r = new Random();

    @Test
    public void testConvertName() {
        assertEquals("BUR-9hs", EX02B.convertName("burroughs"));
        assertEquals("ABC-3bc", EX02B.convertName("abc"));
        assertEquals("ERROR", EX02B.convertName(""));

        for (int i = 0; i < 1_000; i++) {
            int numberOfChars = r.nextInt(0, 10);

            StringBuilder s = new StringBuilder();

            for (int j = 0; j < numberOfChars; j++) {
                s.append((char)(r.nextInt(26) + 'a'));
            }

            String result = s.toString();
            String actual = EX02B.convertName(result);

            if (numberOfChars < 3) {
                assertEquals("ERROR", actual);
            } else {
                assertEquals(
                        String.format(
                                "%s-%s%s",
                                result.substring(0, 3).toUpperCase(),
                                result.length(),
                                result.substring(result.length() - 2)
                        ),
                        actual
                );
            }
        }
    }

    @Test
    public void testGetAdditionExpression() {
        assertEquals("1 + 2 = 3", EX02B.getAdditionExpression(1, 2));
        assertEquals("-1 + -2 = -3", EX02B.getAdditionExpression(-1, -2));
        assertEquals("-95 + 76 = -19", EX02B.getAdditionExpression(-95, 76));
        assertEquals("44 + -2 = 42", EX02B.getAdditionExpression(44, -2));
        assertEquals("92 + -84 = 8", EX02B.getAdditionExpression(92, -84));
        assertEquals("35 + -51 = -16", EX02B.getAdditionExpression(35, -51));
        assertEquals("-94 + -56 = -150", EX02B.getAdditionExpression(-94, -56));
    }

    @Test
    public void testGetSubtractionExpression() {
        assertEquals("3 - 2 = 1", EX02B.getSubtractionExpression(3, 2));
        assertEquals("-3 - -5 = 2", EX02B.getSubtractionExpression(-3, -5));
        assertEquals("-44 - 38 = -82", EX02B.getSubtractionExpression(-44, 38));
        assertEquals("-67 - 35 = -102", EX02B.getSubtractionExpression(-67, 35));
        assertEquals("97 - 70 = 27", EX02B.getSubtractionExpression(97, 70));
    }

    @Test
    public void testRepeat() {
        assertEquals("aaaaa", EX02B.repeat("a", 5));
        assertEquals("abcabcabc", EX02B.repeat("abc", 3));
        assertEquals("", EX02B.repeat("", 100));
        assertEquals("", EX02B.repeat("a", 0));
        assertEquals("a", EX02B.repeat("a", 1));
    }

    @Test
    public void testGetLineSeparator() {
        assertEquals("-----", EX02B.getLineSeparator(5, false));
        assertEquals(">---<", EX02B.getLineSeparator(5, true));
        assertEquals("", EX02B.getLineSeparator(1, true));
        assertEquals("-", EX02B.getLineSeparator(1, false));
        assertEquals("><", EX02B.getLineSeparator(2, true));
    }
}
