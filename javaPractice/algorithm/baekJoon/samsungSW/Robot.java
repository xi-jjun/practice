// 14503 baekJoon Gold5
// 아직 못 품..

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.lang.Math;

class Robot{
    static final int NOT_CLEANED_ROOM = 0;
    static final int WALL = 1;
    static final int CLEANED_ROOM = 2;
    static int[][] cleanMap; // 1:wall , 0:space
    static int count = 0;

    public static int[] wayFind(int r, int c, int d, int countWay) {
        int[] rc = new int[2];

        if(countWay == 5) {
            if(d == 1) d = 3;
            else d = Math.abs(d - 2);
        }

        if(d == 0) {
            r--;
        } else if(d == 1) {
            c++;
        } else if(d == 2) {
            r++;
        } else if(d == 3) {
            c--;
        }

        rc[0] = r;
        rc[1] = c;

        return rc;
    }

    // d= 0:N , 1:E , 2:S , 3:W
    public static void cleanRoom(int r, int c, int d, int countWay) {
        int room = cleanMap[r][c];
        int[] temp = new int[2];
        countWay++;
        int leftRoom;
        int or = r;
        int oc = c;

        if(room == NOT_CLEANED_ROOM) {
            cleanMap[r][c] = CLEANED_ROOM; // 현재 위치 청소
            count++; // clean count
        }

        // 방향 전환 
        if(d == 0) d = 3;
        else d--;

        temp = wayFind(r, c, d, countWay);
        r = temp[0];
        c = temp[1];

        leftRoom = cleanMap[r][c];

        if(leftRoom == NOT_CLEANED_ROOM) {
            cleanRoom(r, c, d, 0);
            return;
        } else if(leftRoom != NOT_CLEANED_ROOM && countWay < 4) {
            cleanRoom(or, oc, d, countWay);
            return;
        } else if(leftRoom != NOT_CLEANED_ROOM) { // 4way clean or wall
            if(leftRoom == WALL) return;


            cleanRoom(r, c, d, 0);
            return;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String size = br.readLine(); // N, M
        StringTokenizer st1 = new StringTokenizer(size);
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        
        cleanMap = new int[N][M];

        // get location info
        String location = br.readLine();
        StringTokenizer st2 = new StringTokenizer(location);
        int r = Integer.parseInt(st2.nextToken()); // x
        int c = Integer.parseInt(st2.nextToken()); // y
        int d = Integer.parseInt(st2.nextToken()); // 방향

        // get mapInfo
        for(int i = 0; i < N; i++) {
            String mapInfo = br.readLine();
            StringTokenizer st3 = new StringTokenizer(mapInfo);

            for(int j = 0; j < M; j++) {
                cleanMap[i][j] = Integer.parseInt(st3.nextToken());
            }
        }



        cleanRoom(r, c, d, 0);

        bw.write(count + "");




        bw.write("\n\n");

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bw.write(cleanMap[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}