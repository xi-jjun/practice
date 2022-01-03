package processSynchronization.produce_consumer.moniter;

import java.util.concurrent.Semaphore;

public class Buffer {
    private int[] buffer;
    private int bufferSize;
    private int currentSize;
    private int in;
    private int out;

    public Buffer(int bufferSize) {
        buffer = new int[bufferSize];
        this.bufferSize = bufferSize;
        currentSize = in = out = 0;
    }

    synchronized void insert(int item) throws InterruptedException {
        while (currentSize >= bufferSize) {
            wait();
        }

        buffer[in] = item;
        System.out.println("insert item = " + item);
        in = (in + 1) % bufferSize;
        currentSize++;
        notify();
    }

    synchronized int remove() throws InterruptedException {
        while (currentSize <= 0) {
            wait();
        }

        int item = buffer[out];
        System.out.println("remove item = " + item);
        out = (out + 1) % bufferSize;
        currentSize--;
        notify();

        return item;
    }
}
