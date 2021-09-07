import java.util.Scanner;

public class Night {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String location = sc.nextLine();
        sc.close();

        int[][] steps = {{-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}};

        int x = location.charAt(1) - 49;
        int y = location.charAt(0) - 97;
        int count = 0;

//        System.out.println(x + " " + y);
        for(int[] s : steps) {
            if(!(x - s[0] < 0 || x + s[0] > 7 || y - s[1] < 0 || y + s[1] > 7)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
