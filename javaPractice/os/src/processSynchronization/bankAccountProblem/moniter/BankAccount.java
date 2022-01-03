package processSynchronization.bankAccountProblem.moniter;

public class BankAccount {
	private int balance;

	public BankAccount(int balance) {
		this.balance = balance;
	}

	synchronized public void deposit(int money) {
		this.balance += money; // depositPerson 의 Critical-Section
	}

	synchronized public void withdraw(int money) {
		this.balance -= money; // withdrawPerson 의 Critical-Section
	}

	public int getBalance() {
		return balance;
	}
}
