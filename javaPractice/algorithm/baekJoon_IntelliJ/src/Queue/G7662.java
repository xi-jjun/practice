package Queue;

import java.io.*;
import java.util.*;

// baekJoon 7662 Gold5 이중 우선순위 큐
// 1008 xxx
public class G7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            int k = Integer.parseInt(br.readLine());
            int ERASE_COUNT = 0;

            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String op = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (op.equals("I")) {
                    ERASE_COUNT++;
                    minHeap.add(n);
                    maxHeap.add(n);
                } else {
                    if (0 >= ERASE_COUNT) {
                        minHeap = new PriorityQueue<>();
                        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
                        continue;
                    }
                    ERASE_COUNT--;
                    if (n == 1) {
                        maxHeap.poll();
                        if (ERASE_COUNT == 0) minHeap.poll();
                    } else {
                        minHeap.poll();
                        if (ERASE_COUNT == 0) maxHeap.poll();
                    }
                }
            }
            if (ERASE_COUNT == 0) bw.write("EMPTY\n");
            else bw.write(maxHeap.peek() + " " + minHeap.peek() + "\n");
        }

        bw.flush();
        bw.close();
    }
}
