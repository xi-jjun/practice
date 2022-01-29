package dynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// baekJoon 9184 silver2 신나는 함수 여행
public class S9184 {
	static int[][][] dp = new int[21][21][21];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1 && c == -1) {
				bw.flush();
				bw.close();
				return;
			}

			int result = w(a, b, c);

			bw.write("w(" + a + ", " + b + ", " + c + ") = " + result + "\n");
		}
	}

	private static int w(int a, int b, int c) {
		if (validRange(a, b, c) && dp[a][b][c] != 0) {
			return dp[a][b][c];
		}

		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}

		if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}

		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}

		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);
	}

	private static boolean validRange(int a, int b, int c) {
		return a >= 0 && a < 21 && b >= 0 && b < 21 && c >= 0 && c < 21;
	}
}
