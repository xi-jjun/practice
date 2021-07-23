import java.util.Scanner;

public class FactorialTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Factorial fact = new Factorial(); // no static declare
        int number = scan.nextInt();
        int num = fact.func(number);
        System.out.println(num);
    }
}