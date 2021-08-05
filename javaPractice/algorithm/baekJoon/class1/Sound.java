import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Sound{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> mySounds = new ArrayList<>(); // sound
        ArrayList<Integer> sortedUp = new ArrayList<>(); // sound
        ArrayList<Integer> sortedDown = new ArrayList<>(); // sound

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 8; i++) {
            int sd = Integer.parseInt(st.nextToken());
            mySounds.add(sd);
        }

        for(int i = 1; i < 9; i++) {
            sortedUp.add(i);
            sortedDown.add(9 - i);
        }

        if(mySounds.equals(sortedUp) == true) bw.write("ascending\n");
        else if(mySounds.equals(sortedDown) == true) bw.write("descending\n");
        else bw.write("mixed\n");


        bw.flush();
        bw.close();
    }
}