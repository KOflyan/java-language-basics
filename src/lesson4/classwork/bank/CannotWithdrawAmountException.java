package lesson4.classwork.bank;

public class CannotWithdrawAmountException extends Exception {
    public CannotWithdrawAmountException() {
        super("Cannot withdraw, not enough balance ");
    }
}
