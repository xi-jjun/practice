package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// baekJoon 1715 Gold4 카드 정렬하기
// priority Q 배우고 다시 풀기! - 아직 못 품
public class G1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) data[i] = Integer.parseInt(br.readLine());

        Arrays.sort(data);

        int sIndex = 0;
        for (int i = 1; i < N-2; i++) {
            S[sIndex++] = data[i - 1] + data[i];
            if (S[0] < data[i + 2]) continue;
            else i++;
        }

        long result = 0;
        for (int k : S) result += k;

        System.out.println(result);
    }
}
