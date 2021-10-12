package sort;

import java.util.Collections;
import java.util.PriorityQueue;

public class Lv2HIndex {
    public static int solution(int[] citations) {
        int answer = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int citation : citations) {
            if(maxHeap.size() == minHeap.size()) maxHeap.offer(citation);
            else minHeap.offer(citation);

            if(!minHeap.isEmpty()) {
                if(minHeap.peek() < maxHeap.peek()) {
                    int min = minHeap.poll();
                    int max = maxHeap.poll();
                    minHeap.offer(max);
                    maxHeap.offer(min);
                }
            }
        }
//        while (!maxHeap.isEmpty()) System.out.println("maxHeap.poll() = " + maxHeap.poll());

        answer = maxHeap.peek();
        return answer;
    }

    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5};
        int[] citations = {1,0,0,0};
        System.out.println("solution(citations) = " + solution(citations));
    }
}
