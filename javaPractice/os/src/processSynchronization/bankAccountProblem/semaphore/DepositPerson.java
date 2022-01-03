package processSynchronization.bankAccountProblem.semaphore;

class DepositPerson extends Thread {
	BankAccount account;

	public DepositPerson(BankAccount account) {
		this.account = account;
	}

	public void run() {
		int i = 100000;
		while (i-->0) {
			try {
				account.deposit(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
//            System.out.println("account.getBalance() = " + account.getBalance());
		}
	}
}
