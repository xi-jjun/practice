import java.io.*;
import java.util.ArrayList;
import java.nio.charset.StandardCharsets;

class FindAlp{
    static int[] checkIndex = new int[123];
    public static void index(String s, int seq) {
        byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
        int location = bytes[0];
        if(checkIndex[location] == -1) checkIndex[location] = seq;
        else return;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String S = br.readLine();
            int loc = 0;
            for(int i = 97; i <= 122; i++) checkIndex[i] = -1; // initialize
            
            for(String c : S.split("")) {
                index(c, loc);
                loc++;
            }
            
            for(int i = 97; i <= 122; i++) bw.write(checkIndex[i] + " ");
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}