import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean result;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            result = true;
            arr = new int[V + 1];
            visited = new boolean[V + 1];
            list = new ArrayList<>();

            for (int i = 0; i <= V; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list.get(u).add(v);
                list.get(v).add(u);
            }

            for (int i = 1; i <= V; i++) {
                if (!visited[i]) dfs(i, 1);
            }

            if (result) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    public static void dfs(int now, int color) {
        visited[now] = true;

        for (int i = 0; i <list.get(now).size(); i++) {
            int num = list.get(now).get(i);

            if (arr[num] != 0 && arr[num] != color * -1) {
                result = false;

                return;
            }

            if (!visited[num]) {
                arr[num] = color * -1;

                dfs(num, color * -1);
            }
        }
    }
}
