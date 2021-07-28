import java.io.*;

class Max{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int[] data = new int[9];
            int index = 0;
            int max = 0;
    
            for(int i = 0; i < 9; i++) {
                data[i] = Integer.parseInt(br.readLine());
                if(data[i] > max) {
                    index = i;
                    max = data[i];
                }
            }
            bw.write(max + "\n" + (index+1));
            bw.close();
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}