package lesson4.homework.EX04A;

public enum WordType {
    NOUN("(n)"),
    VERB("(v)"),
    ADJECTIVE("(a)");

    private final String type;

    WordType(String type) {
        this.type = type;
    }

    public WordType getEnumValue(String value) {
        for (WordType type : values()) {
            if (type.name().equals(value)) {
                return type;
            }
        }

        return null;
    }

    @Override
    public String toString() {
        return this.type;
    }
}
