package lesson5.homework.EX05A;

public class InnerParty extends Party {

    @Override
    public String getPrivileges() {
        return "Everything";
    }

    @Override
    public String toString() {
        return "Inner party";
    }
}
