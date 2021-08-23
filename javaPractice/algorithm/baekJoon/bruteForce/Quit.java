// 14501번 silver4
// 21.08/23 못품

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class Quit {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static ArrayList<Integer> results = new ArrayList<>();
    // (1 ≤ Ti ≤ 5, 1 ≤ Pi ≤ 1,000)

    static int N;

    static int[] T; // 상담완료에 걸리는 시간
    static int[] P; // 상담완료에 얻는 이익

    // 10
    // 5 50
    // 4 40
    // 3 30
    // 2 20
    // 1 10
    // 1 10
    // 2 20
    // 3 30
    // 4 40
    // 5 50

    static void solution(int start, int add) throws IOException {
        for(int i = start; i < N; i++) {
            int startGetTime = T[i] + i;

            if(startGetTime <= N) {
                add += P[i];
                // for(int j = 0; j < N; j++) {
                    // bw.write(i + "'s loop START\n");
                solution(startGetTime, add);
                results.add(add);
                // bw.write(results.get(j) + "\n");
                add = 0;
                // }
                
            } else continue;

        }
    }

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        
        T = new int[N]; // 상담완료에 걸리는 시간
        P = new int[N]; // 상담완료에 얻는 이익

        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0);
        // for(int i = 0; i < N; i++) {

        //     int sum = 0;
        //     int startGetTime = T[i] + i;

        //     for(int j = 0; j < N; j++) {


        //     }
        // }

        Collections.sort(results, Collections.reverseOrder());

        bw.write(results.get(0) + "");


        bw.flush();
        bw.close();
        
    }
}