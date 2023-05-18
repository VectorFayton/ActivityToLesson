package ProblemC;

public class BankAccountThread extends Thread {
    private final BankAccount account;
    private final boolean isDeposit;
    private final int amount;

    public BankAccountThread(BankAccount account, boolean isDeposit, int amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
