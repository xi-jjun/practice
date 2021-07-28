import java.io.*;

class Star2{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(br.readLine());
    
            for(int i = 1; i <= T; i++) {
                for(int j = 0; j < T - i; j++)
                    bw.write(" ");
                for(int k = 0; k < i; k++)
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