// 1789 baekJoon Silver5

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//4294967295

class SumOfNums{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long S = Long.parseLong(br.readLine());
        long n = 0;
        long sum = 0;

        while(S >= sum) {
            n++;
            sum = (n * (n+1))/2;
            if(sum > S) n--;
        }

        bw.write(n + "");

        bw.flush();
        bw.close();
    }
}