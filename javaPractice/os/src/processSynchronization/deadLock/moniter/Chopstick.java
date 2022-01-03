package processSynchronization.deadLock.moniter;

public class Chopstick {
	private boolean isUsed = false;

	synchronized void pickUp() throws InterruptedException {
		while (isUsed) {
			wait();
		}

		isUsed = true;
	}

	synchronized void putDown() {
		isUsed = false;
		notify();
	}
}
