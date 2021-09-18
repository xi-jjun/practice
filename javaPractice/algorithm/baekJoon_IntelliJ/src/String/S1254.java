package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// baekJoon 1254 silver1 팰린드롬 만들기
public class S1254 {
    static String[] str;
    static int count = 0;

    static void checker(int size) {
        int len = size;
        int totalLength = 0;

        if (size % 2 == 0) {
            int a = len / 2 - 1;
            int b = len / 2;

            while (size-- > 0) {
                if (b >= len) {
                    totalLength = a + 1 + len;
                    break;
                }
                if (!str[a].equals(str[b])) {
                    checker(len + 1);
                    return;
                }
                --a;
                ++b;

            }
        } else {
            int a = len / 2 - 1;
            int b = len / 2 + 1;

            while (size-- > 0) {
                if (b >= len) {
                    totalLength = a + 1 + len;
                    break;
                }

                if (!str[a].equals(str[b])) {
                    checker(len + 1);
                    return;
                }
                --a;
                ++b;

            }
        }
        count = totalLength;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine().split("");
        int len = str.length;
        int cycle = str.length;

        if (len == 1) {
            System.out.println("1");
            return;
        }

//        checker(str.length);
        int a = len / 2 - 1;
        int b = len % 2 == 0 ? len / 2 : len / 2 + 1;

        while (cycle-- > 0) {
            if(b>= str.length)
            if(!str[a].equals(str[b])) {
                len++;
                cycle = len;
                a = len / 2 - 1;
                b = len % 2 == 0 ? len / 2 : len / 2 + 1;
                continue;
            }
        }

        System.out.println(count);
    }
}
