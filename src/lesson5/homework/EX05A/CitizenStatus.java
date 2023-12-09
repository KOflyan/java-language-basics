package lesson5.homework.EX05A;

public enum CitizenStatus {
    CITIZEN("citizen"),
    PROLE("prole"),
    NONPERSON("nonperson"),
    UNDER_SURVEILLANCE("under surveillance")
    ;

    private final String status;

    CitizenStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return this.status;
    }
}
