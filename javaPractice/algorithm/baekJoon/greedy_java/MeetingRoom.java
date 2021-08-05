import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class MeetingRoom{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line1 = br.readLine();
        StringTokenizer st = new StringTokenizer(line1);

        ArrayList<Integer> myCoins = new ArrayList<>(); // coin 종류

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        bw.flush();
        bw.close();
    }
}