package bddtask.BDDProject;

public class BankAccount {
	
	private int balance;

    public BankAccount(int initialBalance) {
        this.balance = initialBalance;
    }

    public int withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            return amount;
        } else {
            // Assuming for simplicity, no overdraft is allowed and $0 will be dispensed if insufficient balance
            return 0;
        }
    }

    public int getBalance() {
        return balance;
    }



}
