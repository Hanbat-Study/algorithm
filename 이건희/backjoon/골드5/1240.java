import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static boolean[] visited;
    static ArrayList<ArrayList<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[]{b, len});
            list.get(b).add(new int[]{a, len});
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            visited = new boolean[N + 1];
            result = 0;

            dfs(start, end, 0);

            System.out.println(result);
        }
    }

    public static void dfs(int start, int end, int cnt) {
        visited[start] = true;

        if (start == end) {
            result = cnt;
            return;
        }

        for (int i = 0; i < list.get(start).size(); i++) {
            int[] cur = list.get(start).get(i);
            int now = cur[0];
            int len = cur[1];

            if (!visited[now]) {
                dfs(now, end, cnt + len);
            }
        }
    }
}
