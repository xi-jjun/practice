package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        System.out.println(dq.peekFirst() + " " + dq.peekLast());
        dq.add(2);
        System.out.println(dq.peekFirst() + " " + dq.peekLast());
        dq.add(3);
        System.out.println(dq.peekFirst() + " " + dq.peekLast() + " rm:" + dq.removeFirst());
        dq.add(4);
        System.out.println(dq.peekFirst() + " " + dq.peekLast());
        dq.add(5);
        System.out.println(dq.peekFirst() + " " + dq.peekLast());
    }
}
