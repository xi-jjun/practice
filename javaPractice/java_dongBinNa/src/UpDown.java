import java.util.Scanner;

public class UpDown {
    static final int[] dx = {0, 0, -1, 1}; // L R U D
    static final int[] dy = {-1, 1, 0, 0};

    static int direct(String s) {
        if (s.equals("R")) {
            return 1;
        } else if (s.equals("L")) {
            return 0;
        } else if (s.equals("U")) {
            return 2;
        } else if (s.equals("D")) {
            return 3;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String sp = sc.nextLine(); // ENTER erase
        String directions = sc.nextLine(); // R R U D L
        sc.close();

        int x = 1, y = 1; // init location

        for (String d : directions.split(" ")) {
            int go = direct(d);
            if (x + dx[go] > 0 && x + dx[go] < N + 1) x += dx[go];
            if (y + dy[go] > 0 && y + dy[go] < N + 1) y += dy[go];
        }
        System.out.println(x + " " + y);
    }
}
