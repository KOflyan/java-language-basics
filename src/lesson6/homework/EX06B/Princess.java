package lesson6.homework.EX06B;

public record Princess(
        String name,
        String status,
        String location,
        String details
) {

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
