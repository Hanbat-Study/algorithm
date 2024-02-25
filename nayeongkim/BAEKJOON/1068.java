import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_1068 {
    static int n, cnt, m;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        parent = new int[n];
        int root = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i <n; i++) {
            int parentNode = Integer.parseInt(st.nextToken());
            parent[i] = parentNode;
            if (parentNode < 0) root = i;
            else {
                graph.get(i).add(parentNode);
                graph.get(parentNode).add(i);
            }
        }

        m = Integer.parseInt(br.readLine());
        dfs(root);
        System.out.println(m == root ? 0 : cnt);
    }

    private static void dfs(int root) {
        visited[root] = true;
        int nodes = 0;
        for (int node : graph.get(root)) {
            if (node != m &&!visited[node]) {
                nodes++;
                dfs(node);
            }
        }
        if (nodes == 0) cnt++;
    }

}