import java.io.*;
import java.lang.Math;

class Gold{
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
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine()); // Test case
            boolean check1, check2;
            int n, x = 0, y = 0;

            for(int i = 0; i < T; i++) {
                n = Integer.parseInt(br.readLine());
                for(int j = n/2; j > 0; j--) {
                    check1 = findPrime(j);
                    check2 = findPrime(n - j);
                    if(check1 && check2) {
                        x = j;
                        y = n - x;
                        if(y < n/2) {
                            x = x + y;
                            y = x - y;
                            x = x - y;
                        }
                        j = 0;
                    }
                }
                bw.write(x + " " + y + "\n");
            }
            bw.close();
            
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}