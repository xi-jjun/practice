// BufferedReader/Writer 익숙하지가 않았다. 처음봤음.
import java.io.*;
import java.util.StringTokenizer;

class Buffer{
    public static void main(String[] args){
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            // readLine() : return String...
            int T = Integer.parseInt(br.readLine()); // Convert T form String to Int

            for(int i = 0; i < T; i++) {
                String s = br.readLine();
                StringTokenizer st = new StringTokenizer(s); // space
                int a = Integer.parseInt(st.nextToken()); 
                int b = Integer.parseInt(st.nextToken());

                bw.write((a+b)+"\n");   //버퍼에 있는 값 전부 출력
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}