// 13305 baekJoon silver4
// 질문글에 있던 C코드 JAVA로 바꾼 것. 내 코드가 아님... 근데 58점.

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;


class Gas{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Long> cityLen = new ArrayList<>();
        ArrayList<Long> price = new ArrayList<>();
        long[] buffer = new long[100001]; // cityLen buffer
        int temp = 0;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // length of cities
        for(int i = 0; i < N-1; i++) {
            cityLen.add(Long.parseLong(st.nextToken()));
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        // gas price
        for(int i = 0; i < N; i++) {
            price.add(Long.parseLong(st2.nextToken()));
        }

        long mx = 200000000;
        long cnt = 0;
        for(int i = 0; i < N-1; i++) {
            mx = mx > price.get(i) ? price.get(i) : mx;
            cnt += mx*cityLen.get(i);
        }

        
        bw.write(cnt + " ");

        bw.flush();
        bw.close();
    }
}