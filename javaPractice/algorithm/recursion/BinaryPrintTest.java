import java.util.Scanner;

public class BinaryPrintTest{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int decimal = scan.nextInt();

        BinaryPrint.binaryPrint(decimal);
    }
}