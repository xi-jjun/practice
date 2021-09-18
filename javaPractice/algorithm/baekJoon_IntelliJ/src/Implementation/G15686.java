package Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// baekJoon 15686 Gold5 치킨 배달
// 0918 아직 해결 못 함.
public class G15686 {
    static final int WHITE_SPACE = 0;
    static final int HOME = 1;
    static final int CHICKEN = 2;
    static final int NOT_SELECTED_CHICKEN = 3;

    static ArrayList<ArrayList<Integer>> chick = new ArrayList<ArrayList<Integer>>();

    static int[][] map;
    static int N;
    static int M;

    static void findMin(int startX, int startY, ArrayList<Integer> home) {
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (checkHome(i, k)) {
                    int d = Math.abs(startX - i) + Math.abs(startY - k);
                    home.add(d);
                }
            }
        }
    }

    static boolean checkHome(int x, int y) {
        return map[x][y] == HOME;
    }

    static boolean checkCHICKEN(int x, int y) {
        return map[x][y] == CHICKEN;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        map = new int[N][N];
        int count1 = 0, count2 = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int k = 0; k < N; k++) {
                map[i][k] = Integer.parseInt(st2.nextToken());
                if (map[i][k] == CHICKEN) count2++;
                if (map[i][k] == HOME) count1++;
            }
        }

        for (int i = 0; i < count2; i++) chick.add(new ArrayList<>());

        ArrayList<Integer> mins = new ArrayList<>();
        int id = 0;
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < N; k++) {
                if (checkCHICKEN(i, k)) {
                    findMin(i, k, chick.get(id++));
//                    System.out.println("HOME (" + i + "," + k + ")'s d=" + min);
//                    mins.add(min);
                }
            }
        }

        int[] result = new int[chick.get(0).size()];
        for (int k = 0; k < chick.get(0).size(); k++) {
            for (int i = 0; i < chick.size(); i++) {
                result[k] += chick.get(i).get(k);
            }
        }

        Arrays.sort(result);

        for (int i : result) System.out.print(i + " ");
        System.out.println("");

        int answer = 0;
        for (int i = 0; i < M; i++) answer += result[i];

        for (int a = 0; a < chick.size(); a++) {
            ArrayList<Integer> aa = chick.get(a);

            for (int b = 0; b <count1;b++) {

            }
        }

        System.out.println(answer);
    }
}
