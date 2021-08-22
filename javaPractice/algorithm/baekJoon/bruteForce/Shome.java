// 1436번 silver5

import java.util.Scanner;

class Shome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int num = 665;
        int count = 0;

        sc.close();

        while(count != N) {
            num++;
            String n = num + "";
            if(n.contains("666")) count++;       
        }
        System.out.println(num);

    }
}