package sort;
// baekJoon 2751 silver5
import java.io.*;
import java.util.Arrays;

public class NumSort2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Integer[] data = new Integer[N];

        for(int i=0;i<N;i++){
            data[i]=Integer.parseInt(br.readLine());
        }

        Arrays.sort(data);

        for(Integer i : data) {
            bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}
