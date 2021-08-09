// 아직 못풀었음. 
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class MeetingRoom{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] times = new boolean[100000];
        // ArrayList<Boolean> times = new ArrayList<>();
        boolean check = true;
        int N = Integer.parseInt(br.readLine()); // meeting numbers
        int[][] meetingTimes = new int[N][3];
        
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetingTimes[i][0] = start;
            meetingTimes[i][1] = end;
            meetingTimes[i][2] = end - start;
        }

        // 1. start가 빠른 순으로 정렬
        // 2. end-start 가 작은 순으로 정렬
        Arrays.sort(meetingTimes, (a, b) -> a[0] - b[0]); // start 빠른 순 정렬
        Arrays.sort(meetingTimes, (a, b) -> a[2] - b[2]); // end-start sorting

        boolean firstCheck = false, secondCheck = false;
        int count = 0;

        for(int[] meetingTime : meetingTimes) {
            for(int i = meetingTime[0]; i <= meetingTime[1]; i++) {
                if(times[i] == false || i == meetingTime[0] || i == meetingTime[1]) {
                    if(i == meetingTime[0]) firstCheck = true;
                    if(i == meetingTime[1]) secondCheck = true;
                    times[i] = true;
                }
                else {
                    check = false;
                    for(int j = meetingTime[0]; j <= i; j++) {
                        if(firstCheck == false && secondCheck == false)
                            times[j] = false;
                    }   
                    break;
                }
            }
            if(check == true) count++;
            check = true;
            firstCheck = false;
            secondCheck = false;
        }

        bw.write(count + "");





        // bw.write("\n");

        // for(int i = 0; i < N; i++) {
        //     for(int j = 0; j < 3; j++) {
        //         bw.write(meetingTimes[i][j] + "  ");
        //     }
        //     bw.write("\n");
        // }



        bw.flush();
        bw.close();
    }
}