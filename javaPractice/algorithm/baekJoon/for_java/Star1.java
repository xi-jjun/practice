import java.io.*;
import java.util.StringTokenizer;

class Star1{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(br.readLine());
    
            for(int i = 1; i <= T; i++) {
                for(int j = 0; j < i; j++)
                    bw.write("*");
                bw.write("\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}