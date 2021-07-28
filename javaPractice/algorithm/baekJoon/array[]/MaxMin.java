import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

//N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.
// N
// 1 2 3 4..

class MaxMin{
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            ArrayList<Integer> list = new ArrayList<>();

            String line2 = br.readLine();
            StringTokenizer st = new StringTokenizer(line2);
            
            for(int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                list.add(num);
            }
            // for(int i = 0; i < N; i++) 
            //     bw.write(arr[i] + " ");
            // bw.close();
            list.sort(null);
            
            // for(int i : list) 
            //     bw.write(i + " ");
            int max = list.get(N - 1);
            int min = list.get(0);
            bw.write(min + " " + max);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}