import java.util.Scanner;

class SangSoo{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = 1;
        int x, y, z = 0;

        x = a;
        y = b;

        while(z < 3) {
            if(x%10 == y%10) {
                x /= 10;
                y /= 10;
                z++;
            } else {
                c = (x%10 > y%10) ? a : b;
                break;
            }
        }

        x = c/100;
        y = (c%100)/10;
        z = c%10;

        c = 100*z + y*10 + x;

        System.out.println(c);
    }
}