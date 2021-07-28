import java.util.Scanner;

class MyInput{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[] result = new int[T];

        for(int i = 0; i < T; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            result[i] = a + b;
        }
        
        for(int j : result)
            System.out.println(j);
        
        scan.close();
    }
}