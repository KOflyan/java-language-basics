package lesson4.homework.EX04A;

import java.util.*;

public class Dictionary {

    private static final Set<String> WORD_TYPES = new HashSet<>(Arrays.asList(
            "(a)",
            "(v)",
            "(n)"
    ));
    private static final String FORBIDDEN_CHARS = "0123456789!\\\"#$%&'()*+,./:;<=>?@[\\\\]^_`{|}~ ";
    private final Map<String, List<String>> WORDS_WITH_DEFINITIONS = new HashMap<>();
    private final Map<String, Set<String>> WORDS_BY_TYPE = new HashMap<>();


    public Dictionary(String initialData) {

        outer:
        for (String line : initialData.split("\n")) {
            if (line.length() < 4 || !WORD_TYPES.contains(line.substring(0, 3))) {
                continue;
            }

            String[] pieces = line.split(" - ", 2);
            String type = line.substring(0, 3);
            String word = pieces[0].substring(3).toLowerCase();

            if (pieces.length < 2 || pieces[1].length() == 0) {
                continue;
            }

            short dashCount = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                if (c == '-') {
                    ++dashCount;
                }

                if ((i == 0 || i == word.length() - 1) && c == '-') {
                    continue outer;
                }

                if (FORBIDDEN_CHARS.contains(Character.toString(c)) || dashCount == 2) {
                    continue outer;
                }
            }

            List<String> definitions = WORDS_WITH_DEFINITIONS.getOrDefault(word, new ArrayList<>());
            Set<String> wordsForType = WORDS_BY_TYPE.getOrDefault(type, new HashSet<>());

            definitions.add(pieces[1]);
            wordsForType.add(word.toLowerCase());

            WORDS_WITH_DEFINITIONS.put(word, definitions);
            WORDS_BY_TYPE.put(type, wordsForType);
        }
    }

    public List<String> getDefinitions(String word) {
        return this.WORDS_WITH_DEFINITIONS.getOrDefault(word.toLowerCase(), new ArrayList<>());
    }

    public boolean isNoun(String word) {
        return this.WORDS_BY_TYPE.getOrDefault("(n)", new HashSet<>()).contains(word.toLowerCase());
    }

    public boolean isVerb(String word) {
        return this.WORDS_BY_TYPE.getOrDefault("(v)", new HashSet<>()).contains(word.toLowerCase());
    }

    public boolean isAdjective(String word) {
        return this.WORDS_BY_TYPE.getOrDefault("(a)", new HashSet<>()).contains(word.toLowerCase());
    }

    public List<String> getAllNouns() {
        return new ArrayList<>(this.WORDS_BY_TYPE.getOrDefault("(n)", new HashSet<>()));
    }

    public List<String> getAllAdjectives() {
        return new ArrayList<>(this.WORDS_BY_TYPE.getOrDefault("(a)", new HashSet<>()));
    }

    public List<String> getAllVerbs() {
        return new ArrayList<>(this.WORDS_BY_TYPE.getOrDefault("(v)", new HashSet<>()));
    }

    public List<String> search(String subWord, int minLength, int maxLength) {
        List<String> words = new ArrayList<>();

        for (String w : this.WORDS_WITH_DEFINITIONS.keySet()) {
            if (w.contains(subWord.toLowerCase()) && w.length() >= minLength && w.length() <= maxLength) {
                words.add(w);
            }
        }

        return words;
    }

    public static void main(String[] args) {
        String data = String.join("\n", new ArrayList<>(Arrays.asList(
                "(a)beautiful - very pleasing or satisfying",
                "(a)wise - possessed of or characterized by scholarly knowledge or learning",
                "(a)kind -",
                "(a)Warm - conserving or maintaining warmth or heat",
                "(v)Claim - to assert or maintain as a fact",
                "(n)ph one - a portable electronic telephone device",
                "(a)wise - having the power to judge what is true or right",
                "[n]place - a particular portion of space, whether of definite or indefinite exten",
                "(a)well-known - clearly or fully known",
                "(v)-create - to cause to come into being",
                "(n)law - the principles and regulations established in a community by some authority",
                "(n)injury - harm or damage that is done or sustained",
                "",
                "choice - an act or instance of selection",
                "(n)fire - a burning mass of material, as on a hearth or in a furnace",
                "(b)consume - to destroy or expend by use",
                "(v)consume - to eat or drink up; devour",
                "(v)fire - to expose to the action of fire; subject to heat",
                "(v)fire - to inspire"
        )));

        Dictionary d = new Dictionary(data);

        System.out.println(d.getDefinitions("kind").size());  // --> 0
        System.out.println(d.getDefinitions("phone").size()); // --> 0
        System.out.println(d.getDefinitions("ph one").size()); // --> 0
        System.out.println(d.getDefinitions("choice").size()); // --> 0
        System.out.println(d.getDefinitions("create").size()); // --> 0
        System.out.println(d.getDefinitions("beautiful").size()); // --> 1
        System.out.println(d.getDefinitions("fire").size()); // --> 3
        System.out.println(d.getDefinitions("Consume").size()); // --> 1
        System.out.println(d.getDefinitions("wise").size()); // --> 2

        System.out.println(d.isNoun("fire")); // --> true
        System.out.println(d.isVerb("fire")); // --> true
        System.out.println(d.isAdjective("warm")); // --> true
        System.out.println(d.isNoun("warm")); // --> false

        System.out.println(d.getAllNouns()); // --> [law, fire, injury]
        System.out.println(d.getAllVerbs()); // --> [claim, fire, consume]
        System.out.println(d.getAllAdjectives()); // --> [well-known, beautiful, warm, wise]

        System.out.println(d.search("N", 5, 8)); // --> [consume, injury]
        System.out.println(d.search("fire", 1, 8)); // --> [fire]
    }
}
