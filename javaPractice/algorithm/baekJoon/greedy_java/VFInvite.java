// 9237 silver5

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class VFInvite {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());
        long inviteDay = 0;
        ArrayList<Integer> days = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            days.add(Integer.parseInt(st.nextToken())); // save days
        }

        Collections.sort(days, Collections.reverseOrder());
        int max = 0;

        for(int i = 0; i < N; i++) {
            int day = days.get(i) + i + 1;
            days.set(i, day);
        }
        Collections.sort(days, Collections.reverseOrder());

        bw.write((days.get(0)+1) + "");


        bw.flush();
        bw.close();
        
    }
}