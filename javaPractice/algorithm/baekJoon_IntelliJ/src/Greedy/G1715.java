package Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// baekJoon 1715 Gold4 카드 정렬하기
// priority Q 배우고 다시 풀기! - 아직 못 품
public class G1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        for (int i = 0; i < N; i++) pq.add(Integer.parseInt(br.readLine()));
        boolean mode = false;

        while(!pq.isEmpty()) {
            if(pq.size() <= 2) {
                mode = true;
                break;
            }
            int a = pq.poll();
            int b = pq.poll();
            pq2.add(a);
            pq2.add(b);
            pq.add(a + b);
        }
        int sum = 0;
        while (!pq2.isEmpty()) sum+= pq2.poll();

        int result = pq.size() == 1 ? pq.poll() : pq.poll() + pq.poll();

        System.out.println(sum);
    }
}
