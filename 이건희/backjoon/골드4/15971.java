import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, start, end, result;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[]{b, cost});
            list.get(b).add(new int[]{a, cost});
        }

        dfs(start, 0, 0);

        System.out.println(result);
    }

    public static void dfs(int now, int maxNum, int cnt) {
        visited[now] = true;

        if (now == end) {
            result = Math.min(result, cnt) - maxNum;

            return;
        }

        for (int i = 0; i < list.get(now).size(); i++) {
            int[] cur = list.get(now).get(i);
            int next = cur[0];
            int cost = cur[1];

            if (!visited[next]) dfs(next, Math.max(maxNum, cost), cnt + cost);
        }
    }
}
