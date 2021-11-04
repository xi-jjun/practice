package produce_consumer;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int HOW_MANY = 10000;
        Buffer buffer = new Buffer(50);
        Producer p = new Producer(buffer, HOW_MANY);
        Consumer c = new Consumer(buffer, HOW_MANY);

        p.start(); // 해당 thread 를 실행. 해당 class 의 run method 를 실행시킨다.
        c.start();
        p.join();
        c.join();
        System.out.println("=== END Process! ===");
    }
}
