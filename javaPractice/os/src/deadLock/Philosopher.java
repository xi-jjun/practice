package deadLock;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
	private final Semaphore leftChopstick;
	private final Semaphore rightChopstick;
	private final int id;

	public Philosopher(int id, Semaphore leftChopstick, Semaphore rightChopstick) {
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
			leftChopstick.acquire();
			rightChopstick.acquire();
			eating();

			leftChopstick.release();
			rightChopstick.release();
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
