public class Maze{
    private static final int PATHWAY_COLOUR = 0; // 방문X 갈 수 있는 길
    private static final int WALL_COLOUR = 1; // 벽
    private static final int BLOCKED_COLOUR = 2; // 방문했었는데 길이 아님
    private static final int PATH_COLOUR = 3; // 방문했던 곳. 가능성 있음.

    private static int N = 8;
    private static int maze[][] = {
        {0,0,0,0,0,0,0,1}, // START : [0][0]
        {0,1,1,0,1,1,0,1},
        {0,0,0,1,0,0,0,1},
        {0,1,0,0,1,1,0,0},
        {0,1,1,1,0,0,1,1},
        {0,1,0,0,0,1,0,1},
        {0,0,0,1,0,0,0,1},
        {0,1,1,1,0,1,0,0}  // END : [N-1][N-1]
    };

    public static void printMaze() {
        for(int[] i : maze) {
            for(int j : i) {
                System.out.print(j + "  ");
            }
            System.out.println("");
        }
    }

    public static boolean findPath(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return false;
        else if(maze[x][y] != PATHWAY_COLOUR) return false; // 이미 방문됨 or WALL
        else if(x == N-1 && y == N-1) { // END!
            maze[x][y] = PATH_COLOUR;
            System.out.println("END!!");
            return true;
        } else { // 아직 방문X 경우
            maze[x][y] = PATH_COLOUR; // 방문O

            if(findPath(x-1, y) || findPath(x, y-1) || findPath(x+1, y) || findPath(x, y+1)) {
                return true;
            }

            maze[x][y] = BLOCKED_COLOUR;
            return false;
        }
    }

    public static void main(String[] args) {
        printMaze();
        findPath(0, 0);
        printMaze();
    }
}