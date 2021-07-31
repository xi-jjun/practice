import java.util.Scanner;

class Point{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int N = 0;

        if(C <= B) {
            System.out.println(-1);
            return;
        } 

        N = A / (C-B) + 1;
        
        System.out.println(N);
    }
}