// baekJoon 2606번 silver 3 DFS

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Virus {
    static int N, K, count = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visted;

    static void dfs(int x) {
        visted[x] = true; // 탐색 시작 node를 방문처리

        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i); // 인접 node를 스택에 넣고 방문처리 하기위한 인접 node 번호.
            if (!visted[y]) {
                dfs(y); // stack에 넣고 방문처리.
                count++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        visted = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < K; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        bw.write(count + "\n");

        bw.flush();
        bw.close();
    }
}
