import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
 
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;
 
        Edge() {
 
        }
 
        void set(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
 
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
 
    }
 
    static int[] parents = new int[100_001];
    static int[] rank = new int[100_001];
    static Edge[] edges = new Edge[200_001];
 
    public static void main(String args[]) throws Exception {
 
        // System.setIn(new FileInputStream("res/input.txt"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < 200_001; i++) {
            edges[i] = new Edge();
        }
 
        for (int test_case = 1; test_case <= T; test_case++) {
             
            sb.append("#" + test_case + " ");
             
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
 
            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
 
                edges[i].set(from, to, weight);
            }
 
            Arrays.sort(edges);
 
            for (int i = 0; i < V + 1; i++) {
                parents[i] = i;
                rank[i] = 1;
            }
 
            long ans = 0;
            for (Edge edge : edges) {
                if (!union(edge.from, edge.to)) { // 이미 같은 그룹이면 연결 안해도 된다.
                    continue;
                }
                ans = ans + (long) edge.weight;
            }
            // weight를 저장후, 연결된거니까 union으로 연결을 해준다.
 
            sb.append(ans+"\n");
        }
        System.out.println(sb.toString().trim());
    }
 
    static int find(int a) {
 
        if (a == parents[a]) {
            return a;
        }
 
        return parents[a] = find(parents[a]);
    }
 
    static boolean union(int a, int b) {
 
        int aRoot = find(a);
        int bRoot = find(b);
 
        if (aRoot == bRoot) {
            return false;
        }
 
        if (rank[aRoot] > rank[bRoot]) {
            parents[bRoot] = aRoot;
            rank[aRoot] += rank[bRoot];
        } else {
            parents[aRoot] = bRoot;
            rank[bRoot] += rank[aRoot];
        }
        return true;
    }
}
