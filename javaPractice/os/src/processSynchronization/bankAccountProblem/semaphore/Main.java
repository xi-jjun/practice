package processSynchronization.bankAccountProblem.semaphore;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		BankAccount commonAccount = new BankAccount(3000);
		DepositPerson depositPerson = new DepositPerson(commonAccount);
		WithdrawPerson withdrawPerson = new WithdrawPerson(commonAccount);
		depositPerson.start();
		withdrawPerson.start();
		depositPerson.join();
		withdrawPerson.join();
		System.out.println("get balance = " + commonAccount.getBalance());
	}
}
