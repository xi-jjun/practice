import java.io.*;
import java.util.StringTokenizer;

class Add5{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            while (true) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s); // space
                int a = Integer.parseInt(st.nextToken()); 
                int b = Integer.parseInt(st.nextToken()); 

                if(s == '\n') break;

                bw.write(a + b + "\n");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}