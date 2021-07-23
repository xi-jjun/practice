import java.util.Scanner;

public class GcdTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number1 = scan.nextInt();
        int number2 = scan.nextInt();

        System.out.println(Gcd.gcd(number1, number2));
    }
}