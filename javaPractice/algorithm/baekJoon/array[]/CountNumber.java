import java.io.*;

class CountNumber{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int number = 1;
            int[] count = new int[10];
    
            for(int i = 0; i < 3; i++) // input A,B,C
                number *= Integer.parseInt(br.readLine()); // == AxBxC
            
            while(number > 0){
                count[number%10]++;
                number /= 10;
            }

            for(int i : count)
                bw.write(i + "\n");
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}