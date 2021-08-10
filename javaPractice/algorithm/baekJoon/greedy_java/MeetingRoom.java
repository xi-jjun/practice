// https://st-lab.tistory.com/145 의 해결 방법을 참고했음. 코드는 참고x
// 결국 코드까지 참고... Arrays.sort에 대해 자세히 알아봐야할 것 같다. 
// 익숙하지 않았고 완전 처음보는 것이었음.
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class MeetingRoom{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // meeting numbers
        int[][] meetingTimes = new int[N][2];

        
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetingTimes[i][0] = start;
            meetingTimes[i][1] = end;
        }

        if(N == 1) {
            System.out.println(1);
            return;
        }

        // Arrays.sort(meetingTimes, (a, b) -> a[1] - b[1]); // end 빠른 순 정렬
        // Arrays.sort(meetingTimes, (a, b) -> a[0] - b[0]);
        Arrays.sort(meetingTimes, new Comparator<int[]>() { 
            @Override 
            public int compare(int[] o1, int[] o2) { 
                if(o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            } });


        int endTime = 0;
        int count = 0;
        
        for(int[] i : meetingTimes) {
            if(i[0] >= endTime) {
                count++;
                endTime = i[1];
            }
        }

        bw.write(count + "");

        bw.flush();
        bw.close();
    }
}