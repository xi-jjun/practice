package processSynchronization.deadLock.moniter;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
	private final Chopstick leftChopstick;
	private final Chopstick rightChopstick;
	private final int id;

	public Philosopher(int id, Chopstick leftChopstick, Chopstick rightChopstick) {
		this.id = id;
		this.leftChopstick = leftChopstick;
		this.rightChopstick = rightChopstick;
	}

	@Override
	public void run() {
		while (true) {
			eatAndThinking();
		}
	}

	private void eatAndThinking() {
		try {
			leftChopstick.pickUp();
			rightChopstick.pickUp();
			eating();

			leftChopstick.putDown();
			rightChopstick.putDown();
			thinking();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}

	private void thinking() {
		System.out.println(id + " philosopher thinking...");
	}

	private void eating() {
		System.out.println(id + " philosopher eating...");
	}
}
