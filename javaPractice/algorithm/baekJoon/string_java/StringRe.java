import java.io.*;
import java.util.StringTokenizer;

class StringRe{

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine()); // Test Case
            int N;
            String data;

            for(int i = 0; i < T; i++) {
                String line = br.readLine();
                StringTokenizer st = new StringTokenizer(line);

                N = Integer.parseInt(st.nextToken()); // 반복
                data = st.nextToken(); // ABC

                for(String s : data.split(""))
                    for(int j = 0; j < N; j++) bw.write(s + "");
                
                bw.write("\n");
            }

            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}