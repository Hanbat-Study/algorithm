import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int V, maxNode, result;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        maxNode = 0;
        result = 0;
        visited = new boolean[V + 1];
        list = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int now = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                String token = st.nextToken();

                if (token.equals("-1")) break;

                int a = Integer.parseInt(token);
                int len = Integer.parseInt(st.nextToken());

                list.get(now).add(new int[]{a, len});
            }
        }

        dfs(1, 0);

        visited = new boolean[V + 1];
        result = 0;

        dfs(maxNode, 0);

        System.out.println(result);
    }

    public static void dfs(int now, int sum) {
        visited[now] = true;

        if (result < sum) {
            result = sum;
            maxNode = now;
        }

        for (int i = 0; i < list.get(now).size(); i++) {
            int num = list.get(now).get(i)[0];
            int len = list.get(now).get(i)[1];

            if (!visited[num]) dfs(num, sum + len);
        }
    }
}
