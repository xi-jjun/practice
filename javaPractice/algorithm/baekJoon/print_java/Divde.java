import java.util.Scanner;

class Divde{

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        scan.close();

        double a = num1;
        double b = num2;

        double result = a/b;
        
        System.out.println(result);
    }
}