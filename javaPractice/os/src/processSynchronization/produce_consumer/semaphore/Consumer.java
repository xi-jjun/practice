package processSynchronization.produce_consumer.semaphore;

public class Consumer extends Thread {
    private Buffer buffer;
    private int N;

    public Consumer(Buffer buffer, int N) {
        this.buffer = buffer;
        this.N = N;
    }

    public void run() {
        int item = 0;
        for (int i = 0; i < N; i++) {
            try {
                item = buffer.remove();
                System.out.println("remove : " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            int item = buffer.remove(); // No mutex
        }
    }
}
