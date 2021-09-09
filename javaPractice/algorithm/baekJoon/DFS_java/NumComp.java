// baekJoon 11724 silver2

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NumComp {
    static int N, M, count = 0;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
    static boolean[] visted;

    static boolean dfs(int x) {
        if (!visted[x]) {
            visted[x] = true;

            for (int i = 0; i < graph.get(x).size(); i++) {
                int y = graph.get(x).get(i);
                if (!visted[y]) dfs(y);
            }
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visted = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(line.nextToken());
            int b = Integer.parseInt(line.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        
        for (int i = 1; i <= N; i++) {
            if (dfs(i)) count++;
            if (!visted[i]) count++;
        }

        bw.write(count + "\n");
        bw.flush();
        bw.close();
    }
}
