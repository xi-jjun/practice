// baekJoon 2667 silver1

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GiveNum {
    static ArrayList<Integer> numOfDanJi = new ArrayList<>();
    static final int NO_HOUSE = 0;
    static final int NOT_COUNTED = 1;
    static final int COUNTED = 2;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0}; // Up Right Down Left
    static int[] dy = {0, 1, 0, -1};
    static int N, DanJiIndex = -1, count = 0;

    static boolean dfs(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N) return false;

        if (map[x][y] == NOT_COUNTED) {
            count++;
            map[x][y] = COUNTED;
            for (int i = 0; i < 4; i++) dfs(x + dx[i], y + dy[i]);

            return true;
        }
        return false;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            int y = 0;
            String line = br.readLine();

            for (String l : line.split("")) {
                map[i][y++] = Integer.parseInt(l);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dfs(i, j)) {
                    numOfDanJi.add(count);
                    count = 0;
                }
            }
        }

        Collections.sort(numOfDanJi);
        int total = numOfDanJi.size();

        bw.write(total + "\n");
//        for (int i = 0; i < total; i++) {
//            bw.write(numOfDanJi.get(i) + "\n");
//        }
        for (Integer num : numOfDanJi) bw.write(num + "\n");

        bw.flush();
        bw.close();

    }
}
