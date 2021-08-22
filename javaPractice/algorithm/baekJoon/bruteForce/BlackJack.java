// 2798번 Bronze2

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

class BlackJack {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String line1 = br.readLine(); // N M  첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다
        StringTokenizer st1 = new StringTokenizer(line1);
        int N = Integer.parseInt(st1.nextToken());
        int M = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> sums = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            nums.add(Integer.parseInt(st2.nextToken()));
        }

        for(int i = 0; i < N; i++) {
            int first = nums.get(i);

            for(int j = i+1; j < N; j++) {
                int second = nums.get(j);

                for(int k = j+1; k < N; k++) {
                    int third = nums.get(k);
                    int sum = first + second + third;
                    if(sum <= M)
                        sums.add(first + second + third);
                }
            }
        }
        int max = Collections.max(sums);
        bw.write(max + "");

        bw.flush();
        bw.close();
    }

}