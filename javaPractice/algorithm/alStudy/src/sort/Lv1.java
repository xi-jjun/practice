package sort;

import java.util.PriorityQueue;

// K번째 수
public class Lv1 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] cmds = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        for (int sol : solution(array, cmds)) {
            System.out.print(sol + " ");
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0;

        for (int[] command : commands) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int i = command[0];
            int j = command[1];
            int k = command[2];

            for (int a = i - 1; a < j; a++) pq.add(array[a]);
            while (k-- > 1) {
                pq.poll();
            }
            answer[index++] = pq.peek();
        }
        return answer;
    }

}
