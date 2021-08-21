// 10773번 silver4

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Zero{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int K = Integer.parseInt(br.readLine()); // 1 ≤ K ≤ 100,000
        String[] buff = new String[K];
        int index = 0;

        for(int i = 0; i < K; i++) {
            String N = br.readLine(); // 0 ≤ M ≤ 1,000,000   
            if(N.equals("0")) {
                index--;
            } else {
                buff[index] = N;
                index++;
            }

        }

        int sum = 0;

        for(int i = 0; i < index; i++) {
            sum += Integer.parseInt(buff[i]);
        }

        
        bw.write(sum + "");

        bw.flush();
        bw.close();
    }
}