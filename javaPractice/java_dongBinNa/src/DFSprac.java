import java.util.ArrayList;
import java.util.Stack;

public class DFSprac {
    static final int[][] graph = {
            {},
            {2, 3, 8},
            {1, 7},
            {1, 4, 5},
            {3, 5},
            {3, 4},
            {7},
            {2, 6, 8},
            {1, 7}
    };

//    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    static boolean[] visted = new boolean[9];

    static void dfs(int x) {
        visted[x] = true;
        System.out.println(x + " is visted now!");

        for(int i = 0; i < graph[x].length; i++) {
            int y = graph[x][i];
            if(!visted[y]) dfs(y);
        }
    }

//    static void dfs(int x) {
//        visted[x] = true;
//        System.out.println(x + " is visted now!");
//
//        for(int i = 0; i < graph.get(x).size(); i++) {
//            int y = graph.get(x).get(i);
//            if(!visted[y]) dfs(y);
//        }
//
//    }

    public static void main(String[] args) {
        // 그래프 초기화
//        for (int i = 0; i < 9; i++) {
//            graph.add(new ArrayList<Integer>());
//        }
//
//        // 노드 1에 연결된 노드 정보 저장
//        graph.get(1).add(2);
//        graph.get(1).add(3);
//        graph.get(1).add(8);
//
//        // 노드 2에 연결된 노드 정보 저장
//        graph.get(2).add(1);
//        graph.get(2).add(7);
//
//        // 노드 3에 연결된 노드 정보 저장
//        graph.get(3).add(1);
//        graph.get(3).add(4);
//        graph.get(3).add(5);
//
//        // 노드 4에 연결된 노드 정보 저장
//        graph.get(4).add(3);
//        graph.get(4).add(5);
//
//        // 노드 5에 연결된 노드 정보 저장
//        graph.get(5).add(3);
//        graph.get(5).add(4);
//
//        // 노드 6에 연결된 노드 정보 저장
//        graph.get(6).add(7);
//
//        // 노드 7에 연결된 노드 정보 저장
//        graph.get(7).add(2);
//        graph.get(7).add(6);
//        graph.get(7).add(8);
//
//        // 노드 8에 연결된 노드 정보 저장
//        graph.get(8).add(1);
//        graph.get(8).add(7);

        long startTime = System.nanoTime();
        dfs(1);
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }
}
