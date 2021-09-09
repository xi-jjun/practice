import java.io.*;
import java.util.*;

public class DBfs {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] dfsVisted;
    static boolean[] bfsVisted;
    static int N, M, V;

    static void dfs(int x) throws IOException {
        dfsVisted[x] = true;
        bw.write(x + " ");

        for (int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!dfsVisted[y]) dfs(y);
        }
    }

    static void bfs(int start) throws IOException {
        Queue<Integer> q = new LinkedList<>();

        bfsVisted[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {
            int x = q.poll();
            bw.write(x + " ");

            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!bfsVisted[y]) {
                    q.offer(y);
                    bfsVisted[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        V = Integer.parseInt(st1.nextToken());

        dfsVisted = new boolean[N + 1];
        bfsVisted = new boolean[N + 1];

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<Integer>());

        for (int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        bw.write("\n");
        bfs(V);

        bw.flush();
        bw.close();
    }
}
