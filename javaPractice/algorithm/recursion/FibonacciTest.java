import java.util.Scanner;

public class FibonacciTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();

        System.out.println(Fibonacci.func(num));
    }
}