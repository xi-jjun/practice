// 9009번 Silver1

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Fibo{
    static final int FIXED_LENGTH = 45;
    static long[] fibos = new long[FIXED_LENGTH];

    static void makeFibo() {
        fibos[FIXED_LENGTH-1] = 0;
        fibos[FIXED_LENGTH-2] = 1;
        
        for(int i = 2; i < FIXED_LENGTH; i++) {           
            fibos[FIXED_LENGTH - 1 - i] = fibos[FIXED_LENGTH - i] + fibos[FIXED_LENGTH + 1 - i]; // f[43] = f[44] + f[45]

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); 

        makeFibo(); // make fibonacci element ≤ 1,000,000,000.

        for(int i = 0; i < T; i++) {
            long[] temp = new long[45];
            long n = Long.parseLong(br.readLine()); // 1 ≤ n ≤ 1,000,000,000.
            int end = FIXED_LENGTH;
            int start = 0;
            int cnt = 0;

            for(long f : fibos) {
                if(f <= n) {
                    n -= f;
                    temp[cnt] = f;
                    if(n == 0) break;
                    cnt++;
                }
            }

            for(int k = cnt; k >= 0; k--) {
                bw.write(temp[k] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}