// 이 문제 정확히 안봐서 틀림. 제대로 봐라 제발 눈 달렸으면
import java.util.Scanner;

class Alarm{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int H = scan.nextInt();
        int M = scan.nextInt();
        scan.close();

        if(M - 45 >= 0) System.out.println(H + " " + (M-45));
        else {
            if(H - 1 < 0) System.out.println((H+24) + " " + ((M+60)-45));
            else System.out.println((H-1) + " " + ((M+60)-45));
        }
    }
}