import java.io.*;
import java.util.ArrayList;

class Check{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Integer> inputs = new ArrayList<>();
        boolean indexCheck = true;
        int N = Integer.parseInt(br.readLine()); // 2 <= N <= 100

        int standard = Integer.parseInt(br.readLine());
        inputs.add(standard);
        int compared;

        for(int i = 1; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            inputs.add(num);
        }

        for(int i = 2; i <= standard; i++) {
            compared = inputs.get(0) % i;
            for(int input : inputs) {
                if(compared != input % i) {
                    indexCheck = false; // false : this num is not available
                    break;
                }
                compared = input % i;
            }
            if(indexCheck) bw.write(i + " ");

            indexCheck = true;
        }

        bw.flush();
        bw.close();
    }
}