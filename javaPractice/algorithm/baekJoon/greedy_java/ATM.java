import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class ATM{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // meeting numbers
        int[] times = new int[N];
        int[] sum = new int[N];

        String people = br.readLine();
        StringTokenizer st = new StringTokenizer(people);

        for(int i = 0; i < N; i++) {
            int time = Integer.parseInt(st.nextToken());
            times[i] = time;
        }

        Arrays.sort(times); // small ~ big sorting
        int j = 0;
        int result = 0;

        for(int i = 0; i < N; i++) {
            while(j <= i) {
                sum[i] += times[j];
                j++;
            }
            j = 0;
            result += sum[i];
        }

        bw.write(result + "\n");

        bw.flush();
        bw.close();
    }
}