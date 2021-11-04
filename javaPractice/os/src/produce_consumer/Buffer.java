package produce_consumer;

import java.util.concurrent.Semaphore;

public class Buffer {
    private int[] buffer;
    private int size;
    private int count;
    private int in;
    private int out;

    private Semaphore mutex, full, empty;

    public Buffer(int size) {
        buffer = new int[size];
        this.size = size;
        count = in = out = 0;
        mutex = new Semaphore(1);
        full = new Semaphore(0);
        empty = new Semaphore(size);
    }

    void insert(int item) throws InterruptedException {
//        while (count == size) ; // if buffer is full, then stop insert.

        empty.acquire();
        mutex.acquire();
        // Critical Section ...
        count++;
        buffer[in] = item;
        in = (in + 1) % size;
        // ... Critical Section
        mutex.release();
        full.release();
    }

    int remove() throws InterruptedException {
//        while (count == 0) ; // BUSY WAIT ← 비효율적

        full.acquire(); // 내부효율을 위해서 semaphore 사용.
        mutex.acquire();
        // Critical Section ...
        count--;
        int item = buffer[out];
        out = (out + 1) % size;
        // ... Critical Section
        mutex.release();
        empty.release();

        return item;
    }
}
