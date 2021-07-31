import java.io.*;

class WordCount{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
            String line = br.readLine();
            int count = 0;
    
            for(String s : line.split(" ")) 
                if(s.equals("") != true) count++;

            System.out.println(count);
    
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}