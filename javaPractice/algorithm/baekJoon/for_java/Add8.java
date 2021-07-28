import java.io.*;
import java.util.StringTokenizer;

class Add8{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int T = Integer.parseInt(br.readLine());
    
            for(int i = 1; i <= T; i++) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s);
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                bw.write("Case #" + i + ": " + a + " + " + b + " = " + (a+b) + "\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}