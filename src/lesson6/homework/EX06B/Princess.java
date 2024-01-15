package lesson6.homework.EX06B;

public record Princess(
        String name,
        String status,
        String location,
        String details
) {

    public int getStatusValue() {
        return switch (status.trim()) {
            case "FIGHTS FOR LIFE" -> 0;
            case "INJURED" -> 1;
            case "IN PANIC" -> 2;
            case "BORED" -> 3;
            default -> Integer.MAX_VALUE;
        };
    }

    public boolean isInvalid() {
        return name.equals("None") ||
                status.equals("None") ||
                location.equals("None");
    }

    public boolean isDealtWith() {
        return status.equals("SAVED") ||
                status.equals("EATEN") ||
                status.equals("SLAYED THE DRAGON HERSELF");
    }

    @Override
    public String toString() {
        return
                getPaddedColumn(name) +
                getPaddedColumn(status) +
                getPaddedColumn(location) +
                details;
    }

    private String getPaddedColumn(String value) {
        int columnWidth = 20;

        return value + " ".repeat(columnWidth - value.length());
    }
}
