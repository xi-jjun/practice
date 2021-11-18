package Math;

import java.io.*;
import java.util.StringTokenizer;

// 아직 못 품
public class S6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

//            int maxCount = getMaxCount(M, N);
//            System.out.println("maxCount = " + maxCount);
            int answer = getAnswer(x, y, M, N);

            bw.write(answer + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static int getAnswer(int x, int y, int M, int N) {
//        if (Math.abs(x - y) % 2 != Math.abs(M - N) % 2) return -1;

        int startX = 1;
        int startY = 1;
        int answer = 1;
        int a=1000;

        while (a-->0) {
            if (startX == x && startY == y) {
                return answer;
            }
            startX = startX + 1 > M ? 1 : startX + 1;
            startY = startY + 1 > N ? 1 : startY + 1;
            answer++;
        }

        return -1;
    }

    private static int getMaxCount(int m, int n) {
        if (m == n) return m;

        int x = 1;
        int M = Math.min(m, n);
        int N = Math.max(m, n);
        int diff = N - M;

        int maxCount = 0;
        while (true) {
            x = x + diff > M ? (x + diff) % M : x + diff;
            if (x == 1) break;
            else maxCount += N;
        }

        return maxCount;
    }
}
