import java.io.*;
import java.util.StringTokenizer;

public class IceJuice {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int NOT_VISTED = 0;
    static final int WALL = 1;
    static final int VISTED = 2;

    static int N, M;
    static int[][] map;

    static boolean dfs(int x, int y) {
        if (x < 0 || x > N - 1 || y < 0 || y > M - 1) return false;

        if (map[x][y] == NOT_VISTED) {
            map[x][y] = VISTED;

            dfs(x - 1, y);
            dfs(x, y + 1);
            dfs(x + 1, y);
            dfs(x, y - 1);

            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            int yIndex = 0;
            for (String l : line.split("")) {
                map[i][yIndex++] = Integer.parseInt(l);
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) count++;

            }
        }
        bw.write(count + "\n");
        bw.flush();
        bw.close();

    }
}
