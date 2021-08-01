import java.io.*;

class BeBoss{
    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int T = Integer.parseInt(br.readLine()); // Test case
            int k, n;
 
            for(int i = 0; i < T; i++) {
                k = Integer.parseInt(br.readLine());
                n = Integer.parseInt(br.readLine());

                int[][] Sk = new int[n+1][k+1]; // k floor , n room

                for(int a = 0; a <= k; a++) {
                    for(int b = 1; b <= n; b++) {
                        if(a == 0) Sk[b][a] = b; // a floor , b room : 0th floor
                        else {
                            if(b == 1) Sk[b][a] = 1;
                            else {
                                Sk[b][a] = Sk[b][a-1] + Sk[b-1][a];
                            }
                        }
                    }
                }

                // 결과 배열 보려면 쓰세요.
                // for(int c = 0; c <= k; c++) {
                //     System.out.print(c + "th Floor : ");
                //     for(int d = 1; d <= n; d++) System.out.print(Sk[d][c] + " ");
                //     System.out.println("");
                // }

                bw.write(Sk[n][k] + "\n");
            }
            bw.close();

        } catch(IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        
    }
}