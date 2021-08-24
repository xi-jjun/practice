// 19939 silver5

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Bak {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int an = (K+1)*K / 2;

        if(N < an) {
            bw.write("-1");
            bw.flush();
            bw.close();
            return;
        } else {
            int kk = K % 2 == 0 ? K/2 : 0;
            if(N % K == kk) {
                bw.write((K-1) + "");
            } else {
                bw.write(K + "");
            }
            bw.flush();
            bw.close();
            return;
        }
        
    }
}