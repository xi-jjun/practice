import java.io.*;

class SumLooong{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int sum = 0;
            int N = Integer.parseInt(br.readLine());
            String number = br.readLine();
            
            for(int i = 0; i < number.length(); i++)
                sum += number.charAt(i) - '0';

            System.out.println(sum);

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}