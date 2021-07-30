import java.io.*;

class Fibonacci{

    public static int[] fibonacci(int n) {
        
        int[] f = new int[n+1];
        int[] answer = new int[3];

        if(n < 3) {
            if(n == 0) {
                answer[0] = 1;
                answer[1] = 0;
                return answer;
            } else if(n == 1) {
                answer[0] = 0;
                answer[1] = 1;
                return answer;
            } else {
                answer[0] = 1;
                answer[1] = 1;
                return answer;
            }
        }

        f[1] = 1;
        f[2] = 1;
        for(int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        answer[0] = f[n-1]; // 0 count
        answer[1] = f[n]; // 1 count
        return answer;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine()); // Test Case
            int[] counts = new int[2];

            for(int i = 0; i < T; i++) {
                int N = Integer.parseInt(br.readLine());
                counts = fibonacci(N);
                bw.write(counts[0] + " " + counts[1] + "\n");
            }
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}