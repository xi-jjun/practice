import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Camping{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null; 
        int i = 1;
        while(true) {

            line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if(L + P + V == 0) break;

            int result = (V%P)/L >= 1 ? (V/P)*L + L : (V/P)*L + (V%P);
            bw.write("Case "+ i + ": " + result + "\n");
            i++;
        }

        bw.flush();
        bw.close();
    }
}