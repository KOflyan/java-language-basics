package homework.EX03B;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EX03BTest {

    @Test
    void testScrambleWordEmpty() {
        assertEquals("", EX03B.scrambleWord(""));
    }

    @Test
    void testScrambleWord() {
        assertEquals("Mo'SuE!", EX03B.scrambleWord("Mo'uSE!"));
        assertEquals("CoOol", EX03B.scrambleWord("CoOol"));
        assertEquals("Sapm!", EX03B.scrambleWord("Spam!"));
        assertEquals("bgiorwd!", EX03B.scrambleWord("bigword!"));
    }

    @Test
    void testScrambleWordWithoutSymbols() {
        assertEquals("leefinog", EX03B.scrambleWord("lenofeig"));
        assertEquals("lefnose", EX03B.scrambleWord("lenofse"));
        assertEquals("sbegioprruwd", EX03B.scrambleWord("superbigword"));
    }

    @Test
    void testScrambleWordUpperCase() {
        assertEquals("UfhiPst", EX03B.scrambleWord("UPshift"));
        assertEquals("uhiPsUf", EX03B.scrambleWord("uUPshif"));
        assertEquals("aAaAa", EX03B.scrambleWord("aAaAa"));
    }

    @Test
    void testScrambleWordApostrophe() {
        assertEquals("bc'da", EX03B.scrambleWord("bd'ca"));
        assertEquals("b'cda", EX03B.scrambleWord("b'dca"));
        assertEquals("bcd'a", EX03B.scrambleWord("bdc'a"));
    }

    @Test
    void testScrambleWordSymbolInTheEnd() {
        final String symbols = ".,;?!\"";

        for (int i = 0; i < symbols.length(); i++) {
            char symbol = symbols.charAt(i);

            String wordWithSymbol = String.format("abc%s", symbol);
            String wordWithSymbol1 = String.format("ttaat%s", symbol);

            assertEquals(wordWithSymbol, EX03B.scrambleWord(wordWithSymbol));
            assertEquals(String.format("taatt%s", symbol), EX03B.scrambleWord(wordWithSymbol1));
            assertEquals(String.valueOf(symbol), EX03B.scrambleWord(String.valueOf(symbol)));
        }
    }

    @Test
    void testScrambleSentenceEmpty() {
        assertEquals("", EX03B.scrambleSentence(""));
    }

    @Test
    void testScrambleSentenceExamples() {
        assertEquals("Hey, how's it ginog?", EX03B.scrambleSentence("Hey, how's it going?"));
        assertEquals("The paeehmnnol peowr of the hamun mind.", EX03B.scrambleSentence("The phenomenal peowr of the hamun mind."));
    }

    @Test
    void testScrambleSentenceLong() {
        assertEquals(
                "Sort a word aaabcehilllpty, keeinpg olny the first and last leettr as tehy were.",
                EX03B.scrambleSentence("Sort a word alphabetically, keeping only the first and last letter as they were.")
        );
    }
}
