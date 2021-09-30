package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// baekJoon 1697 silver1 숨박꼭질
public class S1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);
        int count = 0;

        if (N > M) {
            System.out.println((N - M));
            return;
        } else {
            while (N < M) {
                N *= 2;
                count++;
            }
        }

        System.out.println(count);
    }
}
