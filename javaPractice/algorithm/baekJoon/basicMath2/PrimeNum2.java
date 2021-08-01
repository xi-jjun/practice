import java.io.*;
import java.lang.Math;

class PrimeNum2{
    public static boolean findPrime(int n) {
        int i = 2;
        if(n == 1) return false;
        else if(n == 2) return true;
        while(i < n) {
            if(n % i == 0) return false;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int M = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            boolean check, count = true;
            String line;
            int min = 0;
            int sum = 0;

            for(int i = M; i <= N; i++) {
                check = findPrime(i);
                if(check) sum += i;
                if(sum > 0 && count) {
                    count = false;
                    min = i;
                }
            }
            if(sum == 0) {
                System.out.println(-1);
                return;
            }
            System.out.println(sum + "\n" + min);
            
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}