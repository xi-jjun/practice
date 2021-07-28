import java.io.*;
import java.util.StringTokenizer;

class LessX{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s); // space

            int N = Integer.parseInt(st.nextToken()); // number nums
            int X = Integer.parseInt(st.nextToken()); // standard num
    
            String s2 = br.readLine();
            StringTokenizer st2 = new StringTokenizer(s2);

            for(int i = 1; i <= N; i++) {
                int numbers = Integer.parseInt(st2.nextToken()); 

                if(numbers < X) bw.write(numbers + " ");
            }
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}