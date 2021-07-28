import java.util.Scanner;

class GuguDan{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();

        for(int i = 1; i <= 9; i++)
            System.out.println(N + " * " + i + " = " + (N*i));
    }
}