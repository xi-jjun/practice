// 2447 - 별 찍기
// 문제 못 풀어서 다른 사람 답 보고 품. https://www.acmicpc.net/source/share/44047b8696a24f14a7a4b6b4fd14c5b1
// 나중에 꼭 다시 풀어볼 것. 재귀 함수에 대한 충분한 이해를 바탕으로 해보자.

import java.io.*;
import java.util.Scanner;

class Star{
    static Scanner scan = new Scanner(System.in);
    static int N = scan.nextInt();
    static String[][] star = new String[N + 1][N + 1];

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
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    star[j][i] = " ";
                }
            }

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
/*
N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

N = 9  N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태
공백으로 채워진 가운데의 3x3 정사각형을 크기 3의 패턴으로 툴러싼 형태.
*********
* ** ** *
*********
***   ***
* *   * *
***   ***
*********
* ** ** *
*********

N = 27
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********
* ** ** *
*********
***   ***
* *   * *
***   ***
*********
* ** ** *
*********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*/