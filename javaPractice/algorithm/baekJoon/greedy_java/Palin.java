// 17609 Silver1

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

class Palin {

    static int count = 0;

    static int solution(String line, boolean checker) {

        int strLen = line.length();
        char start = line.charAt(0);
        char end = line.charAt(strLen-1);

        for(int k = 0; k < strLen/2; k++) {
            // System.out.println("start, end : " + start + ", " + end);
            if(start == end) {
                start = line.charAt(k+1); // next
                end = line.charAt(strLen-k-2); // before
            } else {
                count++;
                
                if(checker) {
                    String temp1 = line.substring(0, k) + line.substring(k+1);
                    // System.out.println("temp1 : " + temp1);

                    String temp2 = line.substring(0, strLen-k-1) + line.substring(strLen-k);
                    // System.out.println("temp2 : " + temp2);

                    int a = solution(temp1, false);
                    count = 1;
                    int b = solution(temp2, false);
                    int c = a > b ? b : a;
                    return c;
                } else return 2;

            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine()); // 1 ≤ T ≤ 30

        for(int i = 0; i < T; i++) {
            String line = br.readLine(); // aabaa
 
            int result = solution(line, true);
            bw.write(result + "\n");
            count = 0;
        }

        bw.flush();
        bw.close();
    }
}