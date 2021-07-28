// 26부터 시작한다. 2+6 = 8이다. 새로운 수는 68이다. 6+8 = 14이다. 새로운 수는 84이다. 8+4 = 12이다. 새로운 수는 42이다. 4+2 = 6이다. 새로운 수는 26이다.

// 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.

// N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.
import java.util.Scanner;

class CycleAdd{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int orginalN = N;
        scan.close();
        int temp = 0;
        int count = 0;

        if(N < 10) {
            while(true) {
                count++;
                temp = (N/10) + (N%10); // 2 + 6 = 8  6 + 8 = 14
                N = (N%10)*10 + (temp%10); // 60 + 8  80 + 4 = 84
                if(orginalN == N) break;
            }
        } else {
            while(true) { // N = 26 N = 68
                count++;
                temp = (N/10) + (N%10); // 2 + 6 = 8  6 + 8 = 14
                N = (N%10)*10 + (temp%10); // 60 + 8  80 + 4 = 84
                if(orginalN == N) break;
            }
        }
        System.out.println(count);

    }
}