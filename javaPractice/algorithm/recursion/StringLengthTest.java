import java.util.Scanner;

public class StringLengthTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.next();

        System.out.println(StringLength.stringLen(str1));
        scan.close();
    }
}