import java.util.Stack;

public class StackPrac {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(13);
        System.out.println(s.peek());
        s.push(4);
        s.push(41);
        s.push(53);
        s.push(9);

        while (!s.empty()) {
            System.out.println(s.pop());
        }

    }
}
