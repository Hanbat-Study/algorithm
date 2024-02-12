import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main_11725 {
    static int N, result;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        parent = new int[N +1] ;
        for (int i = 0; i<= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < N -1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph.get(x).add(y);
            graph.get(y).add(x);

        }
        dfs(1);
        for (int i = 2; i <=N; i++) {
            System.out.println(parent[i]);
        }

    }

    private static void dfs(int x) {
        visited[x] = true;
        for (int child : graph.get(x)) {
            if (visited[child]) continue;
            parent[child] = x;
            dfs(child);
        }
    }
}