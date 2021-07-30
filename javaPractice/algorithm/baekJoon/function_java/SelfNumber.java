import java.io.*;

class SelfNumber{
    public static void main(String[] args) {
        boolean[] numberFlag = new boolean[10500];
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            for(int i = 1; i <= 10000; i++) {
                if(i / 10 == 0) { // 1~9
                    numberFlag[i * 2] = true;
                } else if(i / 100 == 0) { // 10~99
                    numberFlag[i + (i/10) + (i%10)] = true;
                } else if(i / 1000 == 0) { // 100~999
                    numberFlag[i + (i/100) + ((i%100)/10) + (i%10)] = true;
                } else if(i / 10000 == 0) { // 1000~9999
                    numberFlag[i + (i/1000) + ((i%1000)/100) + ((i%100)/10) + (i%10)] = true;
                } 
            }
            
            for(int i = 1; i < 10001; i++) {
                if(numberFlag[i] == false)
                    bw.write(i + "\n");
            }

            bw.close();
            
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        
    }
}