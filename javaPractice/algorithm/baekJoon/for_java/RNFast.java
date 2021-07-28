// improve Njjick.java speed more fast
import java.io.*;

class RNFast{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int N = Integer.parseInt(br.readLine());
    
            for(int i = N; i >= 1; i--) {
                bw.write(i + "\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}