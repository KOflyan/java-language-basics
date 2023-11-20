package lesson3.homework.EX03A;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class EX03ATest {

    @Test
    void testGetMinLenWordSameLength() {
        assertEquals("Hello", EX03A.getMinLenWord(new ArrayList<>(Arrays.asList("Hello", "there"))));
    }

    @Test
    void testGetMinLenWordEmptyList() {
        assertNull(EX03A.getMinLenWord(new ArrayList<>()));
    }

    @Test
    void testGetMinLenWordDifferentLengths() {
        assertEquals("tent", EX03A.getMinLenWord(new ArrayList<>(Arrays.asList("house", "tent", "home"))));
        assertEquals("pet", EX03A.getMinLenWord(
                new ArrayList<>(Arrays.asList("barnacle", "pet", "fish", "cloud")))
        );
        assertEquals("tree", EX03A.getMinLenWord(
                new ArrayList<>(Arrays.asList("grass", "dragon", "tree", "bark", "water")))
        );
    }


    @Test
    void testSortListOfWords() {
        assertEquals(
                new ArrayList<>(
                        Arrays.asList("tea", "rest", "justify", "augmented", "afterlife", "monosaccharide")
                ),
                EX03A.sortList(
                        new ArrayList<>(
                                Arrays.asList("monosaccharide", "augmented", "justify", "rest", "afterlife", "tea")
                        )
                )
        );

        assertEquals(
                new ArrayList<>(
                        Arrays.asList("ok", "figure", "octopus", "monument", "laughable")
                ),
                EX03A.sortList(
                        new ArrayList<>(
                                Arrays.asList("figure", "laughable", "monument", "ok", "octopus")
                        )
                )
        );
    }
}
