// 14916 silver5

import java.util.Scanner;

class Change2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int o_N = N;

        int count = 0;
        if(N < 4 && N != 2) {
            System.out.println(-1);
            return;
        }
        count = N / 5;
        N %= 5;
        
        if(N % 2 == 0 || N == 0) {
            count += N / 2;
            System.out.println(count);
            return;
        } else {
            while(N % 2 != 0) {
                N += 5;
                count--; // 5 go down
            }
            count += N / 2;
            System.out.println(count);
        }
        
    }
}