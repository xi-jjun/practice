public class BinaryPrint{
    public static void binaryPrint(int n) {
        if(n < 2) System.out.print(n);
        else {
            binaryPrint(n / 2);
            System.out.print(n % 2);
        }
    }
}
// 5 = 1*2^2 + 0*2^1 + 1*2^0
// 1. 5/2 = 2...1
// 2. 2/2 = 1...0

// 10 = 1*2^3 + 0*2^2 + 1*2^1 + 0*2^0
// 1. 10/2 = 5...0
// 2. 5/2 = 2...1
// 3. 2/2 = 1...0