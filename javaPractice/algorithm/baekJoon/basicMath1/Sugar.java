import java.io.*;

class Sugar{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            int N = Integer.parseInt(br.readLine()); // 3 < N < 5001
            int original = N;
            int three = 0;
            int five = 0;

            while(N > 0) {
                if(N % 5 == 0) {
                    five += (N / 5);
                    N = original - 5*five - 3*three;
                } else if(N % 5 == 3) {
                    five = five + (N / 5);
                    three++;
                    N = original - 5*five - 3*three;
                } else {
                    three++;
                    N -= 3;
                }
            }
            if(N < 0) System.out.println(-1);
            else System.out.println(five + three);


        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }
}