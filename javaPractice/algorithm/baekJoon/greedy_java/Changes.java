import java.util.Scanner;

class Changes{
    public static void main(String[] args) {
        int[] changes = {500, 100, 50, 10, 5, 1};

        Scanner sc = new Scanner(System.in);
        int pay = sc.nextInt();
        int i = 0, count = 0;
        int money = 1000 - pay;

        while(money > 0) {
            count += (money/changes[i]);
            money %= changes[i];
            i++;
        }
        System.out.println(count);
    }
}