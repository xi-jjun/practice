import java.util.Scanner;

class Multiply{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        scan.close();

        // 472 x 385
        System.out.println(num1 * (num2%10));
        System.out.println(num1 * ((num2%100)/10));
        System.out.println(num1 * (num2/100));
        System.out.println(num1 * num2);
    }
}