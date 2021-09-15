public class testLV2_1 {
    static boolean[][] visted = new boolean[11][11];
    static final int[] dx = {-1, 1, 0, 0}; // U D L R
    static final int[] dy = {0, 0, -1, 1};
    static int count = 0;
    static int gx, gy;

    static int direction(String dir) {
        switch (dir) {
            case "U":
                return 0;
            case "D":
                return 1;
            case "L":
                return 2;
            default:
                return 3;
        }
    }

    static void going(int x, int y, int dir) {

        gx = x + dx[dir];
        gy = y + dy[dir];

        if (gx < 0 || gx >= 11 || gy < 0 || gy >= 11) {
            gx = x;
            gy = y;
            return;
        }

        if (!visted[gx][gy]) {
            visted[gx][gy] = true; // visted!
            count++;
        }

    }

    static int solution(String dirs) {
        gx = 5;
        gy = 5;
        visted[5][5] = true;
        for (String d : dirs.split("")) {
            int dir = direction(d); // direction
            going(gx, gy, dir);
        }

        return count;
    }

    public static void main(String[] args) {
        int answer = 0;
        String dirs = "LULLLLLLU";

        answer = solution(dirs);
        System.out.println(answer);
    }
}
