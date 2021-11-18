package HW1111;

import java.util.Scanner;

public class Main {
    static void menu() {
        System.out.println("0 : exit\n"
                + "1 : input (King Info.)\n"
                + "2 : show (King List)\n"
                + "3 : menu\n");
    }

    public static void main(String[] args) {
        King[] kings = new King[30];
        int kingIndex = 0;
        Scanner sc = new Scanner(System.in);
        menu();
        boolean stop = false;
        int mode = -1;

        while (!stop) {
            mode = sc.nextInt();
            switch (mode) {
                case 0:
                    stop = true;
                    break;
                case 1:
                    kingIndex = getKingInfo(kings, kingIndex, sc);
                    break;
                case 2:
                    showKings(kings, kingIndex);
                    break;
                case 3:
                    menu();
                    break;
                default:
                    break;
            }
        }

        System.out.println("종료되었습니다");
    }

    private static void showKings(King[] kings, int kingIndex) {
        if (kingIndex == 0) {
            System.out.println("정보가 배열에 없습니다.\n");
            return;
        }

        for (int i = 0; i < kingIndex; i++) {
            kings[i].showInfo();
        }
        System.out.println("");
    }

    private static int getKingInfo(King[] kings, int kingIndex, Scanner sc) {
        System.out.print("왕의 이름 : ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("왕의 순서 : ");
        int seq = Integer.parseInt(sc.nextLine());
        kings[kingIndex++] = new King(name, seq);
        System.out.println("");
        return kingIndex;
    }
}
