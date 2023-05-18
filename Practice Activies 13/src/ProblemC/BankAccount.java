package ProblemC;

public class BankAccount {
    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        synchronized(this) {
            return balance;
        }
    }

    public void deposit(int amount) {
        synchronized(this) {
            balance += amount;
        }
    }

    public void withdraw(int amount) {
        synchronized(this) {
            balance -= amount;
        }
    }
}
