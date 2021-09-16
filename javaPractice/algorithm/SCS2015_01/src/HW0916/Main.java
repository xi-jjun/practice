package HW0916;
// 2016111952 김재준
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(num / 100 + (num % 100) / 10 + num % 10);
    }
}