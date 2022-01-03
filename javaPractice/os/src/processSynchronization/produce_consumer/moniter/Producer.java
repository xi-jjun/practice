package processSynchronization.produce_consumer.moniter;

public class Producer extends Thread{
    private Buffer buffer;
    private int N;

    public Producer(Buffer buffer, int N) {
        this.buffer = buffer;
        this.N = N;
    }

    @Override
    public void run() {
        for (int i = 0; i < N; i++) {
            try {
                buffer.insert(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
