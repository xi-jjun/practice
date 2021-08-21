// 1758 silver4

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

class KangHo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] money = new Integer[N];

        for(int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(money, Collections.reverseOrder());

        long sum = 0;
        for(int i = 0; i < N; i++) {
            money[i] -= i;
            if(money[i] < 0) break;
            sum += money[i];
        }
        
        bw.write(sum + "");

        bw.flush();
        bw.close();
    }
}