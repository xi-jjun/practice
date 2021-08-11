import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

class Rope{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 1 <= N <= 100,000
        int len = N;
        int[] ropes = new int[N];
        int[] result = new int[N];

        for(int i = 0; i < N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes); // sort array 

        int j = 0;
        for(int i : ropes) {
            result[j] = i * N;
            N--;
            j++;
        }
        Arrays.sort(result);

        bw.write(result[len - 1] + "");

        bw.flush();
        bw.close();
    }
}