import java.io.*;
import java.util.Scanner;

class Hanoi{
    static Scanner scan = new Scanner(System.in);
    static int N = scan.nextInt(); // 1 <= N <= 20
    static int[][] plates = new int[N + 1][4]; // plates[m][n] : n번째 장대의 m번째 원판

    public static void printStar(int x, int y, int size) {
        
        if(size == 1) {
            star[y][x] = "*";
            return;
        }
        else {
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(i != 1 || j != 1)
                        printStar(x + (size/3)*i, y + (size/3)*j, size / 3);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            // initialization
            // 1:가장 작음. 2:큼 3:더큼 4:더더큼 5:더더더큼 ...
            for(int j = 1; j <= N; j++) 
                star[j][1] = N - j + 1;
            

            printStar(0, 0, N);

            // show
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    bw.write(star[j][i] + "");
                }
                bw.write("\n");
            }
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}