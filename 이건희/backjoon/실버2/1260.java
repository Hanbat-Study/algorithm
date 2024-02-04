import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.get(x).add(y);
            list.get(y).add(x);
        }

        for (int i = 1; i < N + 1; i++) {
            list.get(i).sort(null);
        }

        visited = new boolean[N + 1];
        result = new StringBuilder();
        dfs(V);
        System.out.println(result);
        visited = new boolean[N + 1];
        result = new StringBuilder();
        bfs(V);
        System.out.println(result);
    }

    private static void dfs(int v) {
        result.append(v + " ");
        visited[v] = true;
        for (int n : list.get(v)) {
            if (!visited[n]) {
                visited[n] = true;
                dfs(n);
            }
        }
    }

    private static void bfs(int v) {
        result.append(v + " ");
        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int n : list.get(now)) {
                if (!visited[n]) {
                    result.append(n + " ");
                    queue.offer(n);
                    visited[n] = true;
                }
            }
        }
    }
}
