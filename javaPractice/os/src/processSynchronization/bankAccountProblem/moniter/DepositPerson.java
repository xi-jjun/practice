package processSynchronization.bankAccountProblem.moniter;

class DepositPerson extends Thread {
	private BankAccount account;

	public DepositPerson(BankAccount account) {
		this.account = account;
	}

	public void run() {
		int i = 100000;
		while (i-- > 0) {
			account.deposit(1000);
			System.out.println("account.getBalance() = " + account.getBalance());
		}
	}
}
