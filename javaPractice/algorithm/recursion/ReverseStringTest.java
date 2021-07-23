import java.util.Scanner;

public class ReverseStringTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        String answer;

        // 단순 출력 - 재귀호출
        ReverseString.reversePrintStr(str);
        System.out.println("");

        // Stringbuffer 사용
        answer = ReverseString.reverseString(str);
        System.out.println(answer);
    }
}
