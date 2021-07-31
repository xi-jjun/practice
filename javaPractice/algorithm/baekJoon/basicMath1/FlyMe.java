import java.io.*;
import java.lang.Math;
import java.util.StringTokenizer;

class FlyMe{

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine()); // Test case
            String line;
            long x, y;
            long distance;
            long result;
            long k = 1;

            for(int i = 0; i < T; i++) {
                line = br.readLine(); // x y
                StringTokenizer st = new StringTokenizer(line);
                x = Long.parseLong(st.nextToken());
                y = Long.parseLong(st.nextToken());

                distance = y - x;

                while((k*(k-1) < distance && distance <= k*(k+1)) != true) k++;
                if(k*k >= distance) result = k * 2 - 1;
                else result = k * 2;

                bw.write(result + "\n");
            }
            bw.close();
            
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}