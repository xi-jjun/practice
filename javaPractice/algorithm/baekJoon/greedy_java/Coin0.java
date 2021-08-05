import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Coin0{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line1 = br.readLine();
        StringTokenizer st = new StringTokenizer(line1);

        ArrayList<Integer> myCoins = new ArrayList<>(); // coin 종류

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for(int i=0; i < N; i++) {
            int coins = Integer.parseInt(br.readLine());
            myCoins.add(coins);
        }

        int seq = N - 1;
        int count = 0;
        while(true) {
            int coin = myCoins.get(seq);
            if(K - coin >= 0) {
                count += K / coin;
                K -= (K / coin) * coin;
            }
            if(K == 0) break;
            seq--;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
    }
}