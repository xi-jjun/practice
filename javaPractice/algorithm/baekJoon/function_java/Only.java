import java.io.*;

class Only{
    public static int oneNum(int N) {
        int count = 0;
        int a, b, c;
        if(N / 100 == 0) return N;

        for(int i = 1; i <= N; i++) {
            if(i / 100 == 0) {
                i = 99; // jump
                count = 99;
            } else {
                a = i/100;
                b = (i%100)/10;
                c = i%10;
                if(a - b == b - c) count++;
            }

        }
        return count;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            int result = oneNum(N);
            
            System.out.println(result);

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

}