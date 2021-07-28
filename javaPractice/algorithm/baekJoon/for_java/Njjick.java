import java.util.Scanner;

class Njjick{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        scan.close();

        for(int i = 1; i <= N; i++) {
            System.out.println(i);
        }
    }
}