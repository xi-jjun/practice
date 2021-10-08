package HW1007;

import java.util.Scanner;

public class Main {
    static final int ERROR = -99999999;

    static void menu() {
        System.out.println("[ menu ]");
        System.out.println("0 : exit");
        System.out.println("1 : input (array)");
        System.out.println("2 : show (array)");
        System.out.println("3 : menu\n");
    }

    static int[] makeArray(String[] inputs) {
        int N = Integer.parseInt(inputs[0]);
        if (N != inputs.length - 1) {
            System.out.println("입력이 잘 못 되었습니다");
            return new int[]{ERROR};
        }

        int[] result = new int[N];

        for (int i = 0; i < N; i++) result[i] = Integer.parseInt(inputs[i + 1]);
        System.out.println("입력 완료");

        return result;
    }

    static void printArray(int[] array) {
        if (array[0] == ERROR) System.out.println("잘못된 배열입니다");
        else {
            for (int i : array) System.out.print(i + " ");
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[ Practice 3-6 ]\n");

        menu();

        int mode = -1;
        int[] arr = new int[]{ERROR};

        while (true) {
            mode = sc.nextInt();

            switch (mode) {
                case 0:
                    System.out.println("종료되었습니다.");
                    return;
                case 1:
                    System.out.print("정수 (개수, 값) > ");
                    sc.nextLine();
                    String[] line = sc.nextLine().split(" ");
                    arr = makeArray(line);
                    break;
                case 2:
                    printArray(arr);
                    break;
                case 3:
                    menu();
                    break;
                default:
                    System.out.println("0~3의 값을 입력해주세요");
                    break;
            }
        }
    }
}
