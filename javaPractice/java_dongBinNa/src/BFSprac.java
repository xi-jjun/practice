import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSprac {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visted = new boolean[9];
//    static

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<Integer>();

        q.offer(start);
        visted[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            System.out.println(x + " is deQed");
            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visted[y]) {
                    visted[y] = true;
                    q.offer(y);
                }
            }
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 9; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 노드 1에 연결된 노드 정보 저장
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        // 노드 2에 연결된 노드 정보 저장
        graph.get(2).add(1);
        graph.get(2).add(7);

        // 노드 3에 연결된 노드 정보 저장
        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        // 노드 4에 연결된 노드 정보 저장
        graph.get(4).add(3);
        graph.get(4).add(5);

        // 노드 5에 연결된 노드 정보 저장
        graph.get(5).add(3);
        graph.get(5).add(4);

        // 노드 6에 연결된 노드 정보 저장
        graph.get(6).add(7);

        // 노드 7에 연결된 노드 정보 저장
        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        // 노드 8에 연결된 노드 정보 저장
        graph.get(8).add(1);
        graph.get(8).add(7);

        long startTime = System.nanoTime();
        bfs(1);
        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);
    }
}
