import java.io.*;
import java.lang.Math;
import java.util.StringTokenizer;

class PrimeNum{
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
            int N = Integer.parseInt(br.readLine());
            boolean check = false;
            String line;
            int count = 0;
            int num;

            line = br.readLine(); 
            StringTokenizer st = new StringTokenizer(line);

            for(int i = 0; i < N; i++) {
                num = Integer.parseInt(st.nextToken());

                check = findPrime(num);
                if(check) count++;
            }
            bw.write(count + "\n");
            bw.close();
            
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}