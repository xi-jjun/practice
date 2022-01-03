package processSynchronization.deadLock.moniter;

/**
 * 현재 코드는 deadlock 을 전혀 고려하지 않았기 때문에 중간에 block 이 걸린다.
 * deadlock 해결 방법
 * 1. Circular Wait 를 끊어낸다. 현재 철학자들이 (0,1), (1,2), (2,3), (3,4), (4,0) 순서로 젓가락을 집으려 한다.
 * 	  따라서 원형으로 순환하여 자원을 요구하고 있기에 이를 끊어내면 된다.
 */
public class Main {
	static final int PHILOSOPHER_NUM = 5;

	public static void main(String[] args) {
		Philosopher[] philosophers = new Philosopher[PHILOSOPHER_NUM];
		Chopstick[] chopsticks = new Chopstick[PHILOSOPHER_NUM];

		init(philosophers, chopsticks);

		start(philosophers);
	}

	private static void start(Philosopher[] philosophers) {
		for (Philosopher philosopher : philosophers) {
			philosopher.start();
		}
	}

	private static void init(Philosopher[] philosophers, Chopstick[] chopsticks) {
		setChopsticks(chopsticks);
		setPhilosophers(philosophers, chopsticks);
	}

	private static void setPhilosophers(Philosopher[] philosophers, Chopstick[] chopsticks) {
		for (int i = 0; i < PHILOSOPHER_NUM; i++) {
			philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % PHILOSOPHER_NUM]);
		}
	}

	private static void setChopsticks(Chopstick[] chopsticks) {
		for (int i = 0; i < PHILOSOPHER_NUM; i++) {
			chopsticks[i] = new Chopstick();
		}
	}
}
