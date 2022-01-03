package processSynchronization.bankAccountProblem.semaphore;

class WithdrawPerson extends Thread {
	BankAccount account;

	public WithdrawPerson(BankAccount account) {
		this.account = account;
	}

	public void run() {
		int i = 100000;
		while (i-->0) {
			try {
				account.withdraw(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//            System.out.println("account.getBalance() = " + account.getBalance());
		}
	}
}
