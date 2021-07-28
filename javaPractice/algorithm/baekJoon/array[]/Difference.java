import java.io.*;

class Difference{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int countDifference = 0;
            int[] count = new int[42];
    
            for(int i = 0; i < 10; i++)
                count[(Integer.parseInt(br.readLine()))%42]++; 

            for(int i : count)
                if(i >= 1) countDifference++;
            
            bw.write(countDifference + "");
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}