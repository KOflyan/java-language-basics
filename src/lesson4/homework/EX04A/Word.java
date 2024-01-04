package lesson4.homework.EX04A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word {
    private final List<String> definition = new ArrayList<>();
    private final List<Character> partOfSpeech = new ArrayList<>();
    String name;

    public Word(String info) {
        boolean partsResp = setPartOfSpeech(info);
        boolean nameResp = setName(info);
        if (!nameResp) {
            name = "";
        }
        if (partsResp && nameResp) {
            setDefinition(info);
        }
    }

    private boolean setPartOfSpeech(String info) {
        char[] arr = info.toCharArray();

        if (arr.length < 3) return false;
        if (arr[0] != '(' || arr[2] != ')') return false;

        switch (arr[1]) {
            case 'v', 'a', 'n' -> {
                partOfSpeech.add(arr[1]);
            }
            default -> {
                return false;
            }
        }
        return true;
    }

    private boolean setName(String info) {
        // extracting name
        String[] arr = info.split(" ");
        if (arr.length < 1 || arr[0].length() < 4) return false;
        String rawName = arr[0].substring(3);

        // illegal characters
        if (rawName.matches(".*[0-9].*") ||
                rawName.matches(".*[.,].*")) {
            return false;
        }

        // illegal dashes
        if (rawName.toCharArray()[0] == '-' ||
                rawName.toCharArray()[rawName.length()-1] == '-' ||
                Arrays.stream(rawName.split(""))
                        .toList().stream()
                        .filter(a -> a.equals("-"))
                        .toList().size() > 1) {
            return false;
        }

        name = Arrays.stream(rawName.split("\\)")).toList().getLast().toLowerCase();
        return true;
    }

    private void setDefinition(String info) {
        String[] s = info.split(" ", 3);
        if (s.length < 3) return;
        if (!s[1].equals("-")) return;
        definition.add(s[2]);
    }

    // Getters

    public List<String> getDefinition() {
        return definition;
    }

    public List<Character> getPartOfSpeech() {
        return partOfSpeech;
    }

    // Setters

    public void addDefinition(String definition) {
        if (!this.definition.contains(definition)) {
            this.definition.add(definition);
        }
    }

    public void addPartOfSpeech(Character partOfSpeech) {
        if (!this.partOfSpeech.contains(partOfSpeech)) {
            this.partOfSpeech.add(partOfSpeech);
        }
    }

    // Functionality

    public boolean isNoun() {
        return partOfSpeech.contains('n');
    }

    public boolean isAdjective() {
        return partOfSpeech.contains('a');
    }

    public boolean isVerb() {
        return partOfSpeech.contains('v');
    }

    public void addDuplicateWord(Word word) {
        addDefinition(word.getDefinition().getFirst());
        addPartOfSpeech(word.getPartOfSpeech().getFirst());
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", partOfSpeech, name, definition);
    }
}
