package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// baekJoon 1676 Silver4 팩토리얼 0 개수
// XXX
public class S1676 {
    static long factorial(int n) {
        if (n <= 1) return 1;
        else return n * factorial(n - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(N/5);
    }
}
