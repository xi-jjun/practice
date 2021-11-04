package produce_consumer;

public class Producer extends Thread{
    private Buffer buffer;
    private int N;

    public Producer(Buffer buffer, int N) {
        this.buffer = buffer;
        this.N = N;
    }

    public void run() {
        for (int i = 0; i < N; i++) {
            try {
                buffer.insert(i);
                System.out.println("Insert : " + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            buffer.insert(i);
        }
    }
}
