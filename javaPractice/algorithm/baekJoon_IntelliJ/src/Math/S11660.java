package Math;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// baekJoon 11660 silver1 구간 합 구하기 5
public class S11660 {
	static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		getNM();
		setMap();

		for (int i = 0; i < M; i++) {
			String[] coords = br.readLine().split(" ");
			int x1 = Integer.parseInt(coords[0]);
			int y1 = Integer.parseInt(coords[1]);
			int x2 = Integer.parseInt(coords[2]);
			int y2 = Integer.parseInt(coords[3]);
			int start = map[x1][y1];
			int n = y2 - y1 + 1;
			int S = (2 * start + n - 1) * n / 2;
			int many = x2 - x1 + 1;
			int answer = S * many + (n * (many * (many - 1)) / 2);
			bw.write(answer + "\n");
		}

		bw.flush();
		bw.close();
	}

	private static void setMap() throws IOException {
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String[] numbers = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(numbers[j - 1]);
			}
		}
	}

	private static void getNM() throws IOException {
		String[] nm = br.readLine().split(" ");
		N = Integer.parseInt(nm[0]);
		M = Integer.parseInt(nm[1]);
	}
}
