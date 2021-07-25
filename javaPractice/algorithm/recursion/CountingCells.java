public class CountingCells{
    private static int N = 8;
    private static int blob[][] = {
        {0,0,0,0,0,0,0,1}, // START : [0][0]
        {0,1,1,0,1,1,0,1},
        {0,0,0,1,0,0,0,1},
        {0,1,0,0,0,1,0,0},
        {0,1,1,1,0,0,1,1},
        {0,1,0,0,0,1,0,1},
        {0,0,0,1,0,0,0,1},
        {0,1,1,1,0,1,0,0}  // END : [N-1][N-1]
    };
    private static final int NO_COLOUR = 0; // white colour
    private static final int COLOUR = 1; // black colour
    private static final int COUNTED_COLOUR = 2; // counted

    public static int blobFind(int x, int y) {
        if(x < 0 || y < 0 || x >= N || y >= N) return 0;
        else if(blob[x][y] != COLOUR) return 0; // 포함 X
        else {
            blob[x][y] = COUNTED_COLOUR;
            return 1 + blobFind(x-1, y) + blobFind(x, y-1) + blobFind(x-1, y-1) + blobFind(x+1, y) + blobFind(x, y+1) + blobFind(x+1, y+1) + blobFind(x+1, y-1) + blobFind(x-1, y+1);
        }
    }

    public static void main(String[] args) {
        System.out.println(blobFind(1, 7));
    }
}