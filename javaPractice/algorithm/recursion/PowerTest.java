import java.util.Scanner;

public class PowerTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int exponent = scan.nextInt();

        System.out.println(Power.func(number, exponent));
    }
}