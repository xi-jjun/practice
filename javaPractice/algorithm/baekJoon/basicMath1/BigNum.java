import java.util.Scanner;
import java.math.*;

class BigNum{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BigInteger A = scan.nextBigInteger();
        BigInteger B = scan.nextBigInteger();
        BigInteger result = A.add(B);

        System.out.println(result.toString());
    }
}