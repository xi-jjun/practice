import java.util.Scanner;

class Compare{
    public static void main(String[] args) {
        // 첫째 줄에 다음 세 가지 중 하나를 출력한다.

        // A가 B보다 큰 경우에는 '>'를 출력한다.
        // A가 B보다 작은 경우에는 '<'를 출력한다.
        // A와 B가 같은 경우에는 '=='를 출력한다.
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        scan.close();

        if(a == b) System.out.println("==");
        else if(a > b) System.out.println(">");
        else System.out.println("<");
    }
}