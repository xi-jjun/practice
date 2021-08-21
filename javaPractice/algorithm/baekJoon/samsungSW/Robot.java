// 14503 baekJoon Gold5
// 2021 8/17 아직 못 품..
// 2021 8/21 해결.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Robot {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static final int NOT_CLEANED_ROOM = 0;
    static final int WALL = 1;
    static final int CLEANED_ROOM = 2;
    static final int OUT_OF_MAP = 3;
    static int[][] cleanMap; // 1:wall , 0:space
    static int ROW = 0;
    static int COL = 0;
    static int count = 0;

    public static int find_d(int currentWay) {
        if(currentWay == 0)
            return 3;
        else return currentWay - 1;
    }

    public static int checkLeft(int x, int y, int current) {
        int left = find_d(current);
        int re = 0;

        if(left == 0) {
            if(x - 1 < 0) return OUT_OF_MAP;
            else return cleanMap[x-1][y];
        } else if(left == 1) {
            if(y + 1 > COL - 1) return OUT_OF_MAP;
            else return cleanMap[x][y+1];
        } else if(left == 2) {
            if(x + 1 > ROW - 1) return OUT_OF_MAP;
            else return cleanMap[x+1][y];
        } else if(left == 3) {
            if(y - 1 < 0) return OUT_OF_MAP;
            else return cleanMap[x][y-1];
        }

        return OUT_OF_MAP;
    }

    public static boolean checkBehind(int r, int c, int d) {
        if(d == 0) {
            if(r+1 < ROW) {
                if(cleanMap[r+1][c] == WALL) return false;
                return true;
            }
            else return false;
        } else if(d == 1) { 
            if(c-1 >= 0) {
                if(cleanMap[r][c-1] == WALL) return false;
                return true;
            }
            else return false;
        } else if(d == 2) {
            if(r-1 >= 0) {
                if(cleanMap[r-1][c] == WALL) return false;
                return true;
            }
            else return false;
        } else if(d == 3) {
            if(c+1 < COL) {
                if(cleanMap[r][c+1] == WALL) return false;
                return true;
            }
            else return false;
        }
        return true;
    }

    public static void cleanRoom(int r, int c, int d, int fourWayCheck) throws IOException {
        int currentRoom = cleanMap[r][c];
        int leftWay = find_d(d);

        if(currentRoom == NOT_CLEANED_ROOM) {
            count++; // 1. 현위치 청소
            cleanMap[r][c] = CLEANED_ROOM;
        }

        int leftRoom = checkLeft(r, c, d); // 왼쪽방이 청소됐는지 확인
        
        if(leftRoom == NOT_CLEANED_ROOM) { // 2-1 왼쪽방이 청소가 안됐다면 그 쪽으로 Go!!, then goto 1
            if(leftWay == 0) {
                cleanRoom(r-1, c, leftWay, 1);
            } else if(leftWay == 1) {
                cleanRoom(r, c+1, leftWay, 1);
            } else if(leftWay == 2) {
                cleanRoom(r+1, c, leftWay, 1);
            } else if(leftWay == 3) {
                cleanRoom(r, c-1, leftWay, 1);
            }

        } else if(leftRoom != NOT_CLEANED_ROOM && fourWayCheck != 5) { // 2-2 청소할 공간 X. 회전만하기
            cleanRoom(r, c, leftWay, ++fourWayCheck);
        } else if(leftRoom != NOT_CLEANED_ROOM && fourWayCheck % 5 == 0) { // 2-3 4방향 모두 청소OK or WALL, then 바라보는 방향d 유지한채로 1보 후퇴.
            // 2-4 뒤로 못가면 STOP
            if(checkBehind(r, c, d) == false) return; // END
            else { // 2-3 4방향 모두 청소OK or WALL, then 바라보는 방향d 유지한채로 1보 후퇴.
                if(d == 0) {
                    cleanRoom(r+1, c, d, 1);
                } else if(d == 1) {
                    cleanRoom(r, c-1, d, 1);
                } else if(d == 2) {
                    cleanRoom(r-1, c, d, 1);
                } else if(d == 3) {
                    cleanRoom(r, c+1, d, 1);
                }
            }
        }
        return;
    }

    public static void main(String[] args) throws IOException {

        String size = br.readLine(); // N, M
        StringTokenizer st1 = new StringTokenizer(size);
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());
        ROW = N;
        COL = M;
        
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

        cleanRoom(r, c, d, 1);
        bw.write(count + "\n");

        bw.flush();
        bw.close();

    }
}