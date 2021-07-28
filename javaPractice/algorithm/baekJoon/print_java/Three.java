import java.util.Scanner;

class Three{
    public static void main(String[] args) {
        //첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        System.out.println((a+b)%c);
        System.out.println(((a%c) + (b%c))%c);
        System.out.println((a*b)%c);
        System.out.println(((a%c) * (b%c))%c);
    }
}