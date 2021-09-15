package programmers;

public class Test9_2 {
    static final int[] dx = {-1, 1, 0, 0}; // U D L R
    static final int[] dy = {0, 0, -1, 1};
    static int[][] gridMap;

//    static void searchRoute(int x, int y, int dir, int oDir) {
//        if(x=0&&y=0&&dir)
//    }

    static int[] solution(String[] grid) {
        int[] answer = {};

        int row = grid.length;
        int col = grid[0].length();

        gridMap = new int[row][col];




        return answer;
    }

    public static void main(String[] args) {
        String[] grid = {"SL", "LR"};

        int[] a = solution(grid);
    }
}
