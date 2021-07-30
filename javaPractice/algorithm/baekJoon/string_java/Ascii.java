import java.io.*;
import java.nio.charset.StandardCharsets;

class Ascii{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String s = br.readLine();
            byte[] bytes = s.getBytes(StandardCharsets.US_ASCII);
            System.out.println(bytes[0]);

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}