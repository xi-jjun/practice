package processSynchronization.bankAccountProblem.semaphore;

import java.util.concurrent.Semaphore;

public class BankAccount {
	int balance;
	Semaphore sem;

	public BankAccount(int balance) {
		this.balance = balance;
		this.sem = new Semaphore(1);
	}

	public void deposit(int money) throws InterruptedException {
		sem.acquire();
		this.balance += money; // depositPerson 의 Critical-Section
		sem.release();
	}

	public void withdraw(int money) throws InterruptedException {
		sem.acquire();
		this.balance -= money; // withdrawPerson 의 Critical-Section
		sem.release();
	}

	public int getBalance() {
		return balance;
	}
}
