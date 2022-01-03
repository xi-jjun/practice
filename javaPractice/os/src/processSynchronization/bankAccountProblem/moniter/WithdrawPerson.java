package processSynchronization.bankAccountProblem.moniter;

class WithdrawPerson extends Thread {
	private BankAccount account;

	public WithdrawPerson(BankAccount account) {
		this.account = account;
	}

	public void run() {
		int i = 100000;
		while (i-- > 0) {
			account.withdraw(1000);
			System.out.println("account.getBalance() = " + account.getBalance());
		}
	}
}
