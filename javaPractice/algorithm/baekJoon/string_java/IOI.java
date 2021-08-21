// 5525번 silver2
// 50점/100

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1 ≤ N ≤ 1,000,000
// 2N+1 ≤ M ≤ 1,000,000
// S는 I와 O로만 이루어져 있다.

// 첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.

class IOI {

    static String genP(int N) { // generate P_N
        String re = "IOI"; // P_1 = IOI, P_2 = IOIOI
        for(int i = 1; i < N; i++) {
            re += "O";
            re += "I";
        }
        return re;
    }

    static int countIOI(String S, String P, int lenS, int lenP) {
        int pointer = 0;
        int count = 0;
        boolean check = true;
        
        for(int i = 0; i <= lenS - lenP; i++) {
            if(S.charAt(i) == 'O') continue;
            else if(P.charAt(0) == S.charAt(i)) {
                pointer = i;
                for(int j = 0; j < lenP; j++) {
                    if(P.charAt(j) != S.charAt(pointer)) {
                        check = false;
                        break;
                    }
                    pointer++;
                }
                if(check) {
                    // i++;
                    count++;
                }
            }
            check = true;
        }
        return count;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 1 ≤ N ≤ 1,000,000
        int M = Integer.parseInt(br.readLine()); // 2N+1 ≤ M ≤ 1,000,000   
        String S = br.readLine(); // S

        String P = genP(N); // P_N string

        int result = countIOI(S, P, M, 2*N + 1);

        bw.write(result + "");

        bw.flush();
        bw.close();
    }
}