package processSynchronization.deadLock.semaphore;

import java.util.concurrent.Semaphore;

public class Main {
	static final int PHILOSOPHER_NUM = 5;

	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[PHILOSOPHER_NUM];
		Semaphore[] chopsticks = new Semaphore[PHILOSOPHER_NUM];

		init(philosophers, chopsticks);

		start(philosophers);
	}

	private static void start(Philosopher[] philosophers) {
		for (Philosopher philosopher : philosophers) {
			philosopher.start();
		}
	}

	private static void init(Philosopher[] philosophers, Semaphore[] chopsticks) {
		setChopsticks(chopsticks);
		setPhilosophers(philosophers, chopsticks);
	}

	private static void setPhilosophers(Philosopher[] philosophers, Semaphore[] chopsticks) {
		for (int i = 0; i < PHILOSOPHER_NUM; i++) {
			philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % PHILOSOPHER_NUM]);
		}
	}

	private static void setChopsticks(Semaphore[] chopsticks) {
		for (int i = 0; i < PHILOSOPHER_NUM; i++) {
			chopsticks[i] = new Semaphore(1);
		}
	}
}
