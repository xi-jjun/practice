import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.StringTokenizer;

public class Game {
    static int[][] map;
    static final int VISTED = 2;
    static final int SEA = 1;
    static final int NOT_VISTED = 0; // ground
    static final int[] dx = {-1, 0, 1, 0}; // N E S W
    static final int[] dy = {0, 1, 0, -1}; // N E S W
    static int N, M, count = 0;

    static int turnLeft(int d) {
        return d == 0 ? 3 : --d;
    }

    static void findRoad(int x, int y, int d, int times) {

        if (map[x][y] == NOT_VISTED) {
            count++;
            map[x][y] = VISTED;
        }

        d = turnLeft(d); // See left

        // left coord
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (map[nx][ny] == NOT_VISTED) {
            findRoad(nx, ny, d, 0);
        } else if (times < 3) {
            findRoad(x, y, d, ++times);
        } else if (times == 3) {
            nx = x - dx[d];
            ny = y - dy[d];
            if (map[nx][ny] == SEA) return;
            findRoad(nx, ny, d, 0);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st2.nextToken());
        int y = Integer.parseInt(st2.nextToken());
        int direction = Integer.parseInt(st2.nextToken());

        for (int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line.nextToken());
            }
        }

        findRoad(x, y, direction, 0);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
    }
}
