import java.io.*;

class HoneyHome{
    public static int a(int n) {
        return 3*n*(n-1) + 1;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine()); 
            int n = 1;
            if(N == n) {
                System.out.println(1);
                return;
            }
            
            // a(n) = 3*n*(n-1) + 1
            while((a(n) < N && N <= a(n+1)) != true) n++;
            System.out.println(n+1);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}