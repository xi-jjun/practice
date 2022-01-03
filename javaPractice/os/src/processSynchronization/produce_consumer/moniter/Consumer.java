package processSynchronization.produce_consumer.moniter;

public class Consumer extends Thread {
    private Buffer buffer;
    private int N;

    public Consumer(Buffer buffer, int N) {
        this.buffer = buffer;
        this.N = N;
    }

    @Override
    public void run() {
        int item = 0;
        for (int i = 0; i < N; i++) {
            try {
                item = buffer.remove();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
