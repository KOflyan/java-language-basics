package lesson4.homework.EX04A.tests;

import lesson4.homework.EX04A.Dictionary;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EX04ATest {

    @Test
    public void testEmptyDictionary() {
        Dictionary d = new Dictionary("""
                
        """);

        assertEquals(0, d.getAllVerbs().size());
        assertEquals(0, d.getAllAdjectives().size());
        assertEquals(0, d.getAllNouns().size());
    }

    @Test
    public void testOneWordOfEachCategory() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)word - hello, i am a word",
                "(a)iamsomeadj - ho",
                "(v)testtttt - check if everything is okay"
        )));

        Dictionary d = new Dictionary(data);
        List<String> nouns = d.getAllNouns();
        List<String> adjvs = d.getAllAdjectives();
        List<String> verbs = d.getAllVerbs();

        assertEquals(1, nouns.size());
        assertEquals(1, adjvs.size());
        assertEquals(1, verbs.size());

        assertEquals("word", nouns.get(0));
        assertEquals("testtttt", verbs.get(0));
        assertEquals("iamsomeadj", adjvs.get(0));
    }

    @Test
    public void testOneWordSeveralDefinitions() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)hello - definition 1",
                "(n)hello - def2",
                "(v)hello - definition nr 3",
                "(a)hello - of course it is not an adjective",
                "(v)hello - okay"
        )));

        Dictionary d = new Dictionary(data);

        List<String> defs = d.getDefinitions("hello");

        assertEquals(5, defs.size());

        assertTrue(defs.contains("definition 1"));
        assertTrue(defs.contains("def2"));
        assertTrue(defs.contains("of course it is not an adjective"));
        assertTrue(defs.contains("okay"));


        assertTrue(d.isNoun("hello"));
        assertTrue(d.isVerb("hello"));
        assertTrue(d.isAdjective("hello"));
    }

    @Test
    public void testWithIncorrectInput() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "nopartatal - should be avoided",
                "(c)wtisc - idk",
                "(n)oneokay - it is okay",
                "(th)thisnot - gmmm"
        )));

        Dictionary d = new Dictionary(data);

        assertEquals(0, d.getDefinitions("nopartatal").size());
        assertEquals(0, d.getDefinitions("wtisc").size());
        assertEquals(1, d.getDefinitions("oneokay").size());
        assertEquals("it is okay", d.getDefinitions("oneokay").get(0));
        assertEquals(0, d.getDefinitions("thisnot").size());
    }

    @Test
    public void testSpacesInWord() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "nopartatal - should be avoided",
                "(v)oneokay - it is okay",
                "(n)sp ace - avoid!!!",
                "(v)s - okay",
                "(v) p - i hope it is avoided",
                "(a) some - somed"
        )));

        Dictionary d = new Dictionary(data);


        assertEquals(0, d.getDefinitions("nopartatal").size());
        assertEquals(0, d.getDefinitions("sp ace").size());
        assertEquals(0, d.getDefinitions("space").size());
        assertEquals(0, d.getDefinitions(" p").size());
        assertEquals(0, d.getDefinitions("p").size());
        assertEquals(0, d.getDefinitions(" some").size());


        assertEquals("it is okay", d.getDefinitions("oneokay").get(0));
        assertEquals("okay", d.getDefinitions("s").get(0));
    }

    @Test
    public void testDashesInWord() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)well-known - it is okay",
                "(n)we-ll-known - it is not",
                "(a)-well-known - no!",
                "(a)-wellknown - no!!",
                "(v)wellknown- - stop it!",
                "(n)w-s - good"
        )));

        Dictionary d = new Dictionary(data);


        assertEquals(0, d.getDefinitions("we-ll-known").size());
        assertEquals(0, d.getDefinitions("-well-known").size());
        assertEquals(0, d.getDefinitions("-wellknown").size());
        assertEquals(0, d.getDefinitions("wellknown-").size());
        assertEquals("it is okay", d.getDefinitions("well-known").get(0));
        assertEquals("good", d.getDefinitions("w-s").get(0));
    }

    @Test
    public void testOtherSymbolsInWord() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)number1 - bad",
                "(v)number2 - also bad",
                "(a)nu3mber - and this too",
                "(a)341 - only numbers",
                "(n)okay - nothing more to add",
                "(n)he.ll - no",
                "(n).hell - hmmm",
                "(v)st,op - no!"
        )));

        Dictionary d = new Dictionary(data);


        assertEquals(0, d.getDefinitions("number1").size());
        assertEquals(0, d.getDefinitions("number2").size());
        assertEquals(0, d.getDefinitions("nu3mber").size());
        assertEquals(0, d.getDefinitions("number").size());
        assertEquals(0, d.getDefinitions("341").size());
        assertEquals(0, d.getDefinitions("he.ll").size());
        assertEquals(0, d.getDefinitions("hell").size());
        assertEquals(0, d.getDefinitions(".hell").size());
        assertEquals(0, d.getDefinitions("st,op").size());
        assertEquals(0, d.getDefinitions("stop").size());
        assertEquals("nothing more to add", d.getDefinitions("okay").get(0));
    }

    @Test
    public void testEmptyDefinitions() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)nouns -",
                "(n)nouns - have",
                "(a)emp -"
        )));

        Dictionary d = new Dictionary(data);

        List<String> definitions = d.getDefinitions("nouns");

        assertEquals(1, definitions.size());
        assertEquals("have", definitions.get(0));
        assertEquals(0, d.getDefinitions("emp").size());
    }

    @Test
    public void testWeirdInputWithEmptyLines() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "       ",
                "         ",
                "",
                "",
                "",
                "(n)nouns - hello :)",
                "       ",
                " ",
                "",
                "",
                "(n)noune - i-am go - od!",
                "(v)only - - ok",
                "        ",
                "",
                "(a)only - the best",
                "  "
        )));

        Dictionary d = new Dictionary(data);


        var def1 = d.getDefinitions("nouns");

        assertEquals(1, def1.size());
        assertEquals("hello :)", def1.get(0));

        var def2 = d.getDefinitions("only");

        assertEquals(2, def2.size());
        assertTrue(def2.contains("- ok"));
        assertTrue(def2.contains("the best"));

        assertEquals("i-am go - od!", d.getDefinitions("noune").get(0));
    }

    @Test
    public void testLettersCase() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)word - hello, i am a word",
                "(n)wOrd - i am the second word here AND BIG",
                "(a)iamsomeadj - ho",
                "(n)wtWO - second defintIon",
                "(v)Testtttt - check if everything is okay",
                "(v)wtwo - i am also a verb",
                "(a)adj - hmm"
        )));

        Dictionary d = new Dictionary(data);


        var definitions = d.getDefinitions("WORD");

        assertTrue(
                definitions
                        .containsAll(new ArrayList<>(
                                Arrays.asList("hello, i am a word", "i am the second word here AND BIG"))
                        ) && definitions.size() == 2
        );

        definitions = d.getDefinitions("wtwo");

        assertTrue(
                definitions
                        .containsAll(new ArrayList<>(
                                Arrays.asList("second defintIon", "i am also a verb")
                        )) && definitions.size() == 2
        );

        definitions = d.getDefinitions("testtttt");

        assertTrue(
                definitions
                        .containsAll(new ArrayList<>(
                                List.of("check if everything is okay")
                        )) && definitions.size() == 1
        );

        assertTrue(d.isVerb("WTWO"));
        assertTrue(d.isVerb("wTwO"));
        assertTrue(d.isVerb("WTWO"));
        assertTrue(d.isVerb("wTwO"));


        var allVerbs = d.getAllVerbs();
        var allNouns = d.getAllNouns();

        assertTrue(allVerbs.contains("testtttt"));
        assertTrue(allNouns.contains("word"));
        assertTrue(allNouns.contains("wtwo"));
    }

    @Test
    public void testNonASCIILetters() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)õää - only special letters",
                "(n)käsk - eestikeelne sõna"
        )));

        Dictionary d = new Dictionary(data);


        assertEquals("only special letters", d.getDefinitions("õää").get(0));
        assertEquals("eestikeelne sõna", d.getDefinitions("käsk").get(0));
    }

    @Test
    public void testOtherSmallDictionary() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)word - hello, i am a word",
                "(n)wtwo - i am the second word here",
                "(a)iamsomeadj - ho",
                "(n)wtwo - second defintion",
                "(v)testtttt - check if everything is okay",
                "(v)wtwo - i am also a verb",
                "(a)adj - hmm"
        )));

        Dictionary d = new Dictionary(data);

        var nouns = d.getAllNouns();
        var adjvs = d.getAllAdjectives();
        var verbs = d.getAllVerbs();

        assertEquals(2, nouns.size());
        assertEquals(2, adjvs.size());
        assertEquals(2, verbs.size());

        assertEquals(1, d.getDefinitions("testtttt").size());
        assertEquals(3, d.getDefinitions("wtwo").size());
        assertEquals(0, d.getDefinitions("somewww").size());
        assertEquals("hello, i am a word", d.getDefinitions("word").get(0));

        assertTrue(nouns.containsAll(Arrays.asList("word", "wtwo")) && nouns.size() == 2);
        assertTrue(adjvs.containsAll(Arrays.asList("iamsomeadj", "adj")) && adjvs.size() == 2);
        assertTrue(verbs.containsAll(Arrays.asList("testtttt", "wtwo")) && verbs.size() == 2);
    }

    @Test
    public void testSearchNormalCase() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)ttu - university in estonia",
                "(n)college - place to study",
                "(a)small - smaller"
        )));

        Dictionary d = new Dictionary(data);

        var result = d.search("tt", 0, 999);

        assertTrue(result.size() == 1 && result.contains("ttu"));

        result = d.search("ll", 0, 999);

        assertTrue(result.size() == 2 && result.containsAll(Arrays.asList("college", "small")));
    }

    @Test
    public void testSearchNoMatches() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)ttu - university in estonia",
                "(n)college - place to study",
                "(a)small - smaller"
        )));

        Dictionary d = new Dictionary(data);

        assertEquals(0, d.search("z", 0, 999).size());
        assertEquals(0, d.search("samll", 0, 999).size());
    }

    @Test
    public void testSearch() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)ttu - university in estonia",
                "(n)college - place to study",
                "(v)che - food",
                "(v)he - foodd",
                "(a)cheese - why is cheese an adjective?",
                "(a)ttu - smaller"
        )));

        Dictionary d = new Dictionary(data);

        var result = d.search("he", 4, 999);
        assertTrue(result.size() == 1 && result.contains("cheese"));

        result = d.search("ttu", 6, 999);
        assertEquals(0, result.size());

        result = d.search("tt", 0, 999);
        assertTrue(result.size() == 1 && result.contains("ttu"));

        result = d.search("he", 0, 3);
        assertTrue(result.size() == 2 && result.containsAll(Arrays.asList("he", "che")));

        result = d.search("oll", 0, 4);
        assertEquals(0, result.size());

        result = d.search("ttu", 0, 6);
        assertTrue(result.size() == 1 && result.contains("ttu"));
    }

    @Test
    public void testSearchMinLengthMoreThanMaxLength() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)abc - -- - -a",
                "(n)stop - these dashes may crash solutions",
                "(v)stop - finish moving",
                "(a)serious - kfsdgslj",
                "(a)ttu - bigger"
        )));

        Dictionary d = new Dictionary(data);


        assertEquals(0, d.search("to", 3, 2).size());
    }

    @Test
    public void testSearchCase() {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(n)abc - a",
                "(v)stop - finish moving"
        )));

        Dictionary d = new Dictionary(data);

        var result = d.search("abc", 0, 999);
        assertTrue(result.size() == 1 && result.contains("abc"));

        result = d.search("aBc", 0, 999);
        assertTrue(result.size() == 1 && result.contains("abc"));

        result = d.search("ABC", 0, 999);
        assertTrue(result.size() == 1 && result.contains("abc"));
    }
}
