import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        dfs(0);

        System.out.println(result);
    }

    private static void dfs(int now) {
        if (now == N) {
            int cnt = 0;
            for (boolean b : visited) {
                if (b) cnt++;
            }
            result = Math.max(result, cnt);
            return;
        }

        if (visited[now]) {
            dfs(now + 1);
            return;
        }

        boolean isValid = false;

        for (int i = 0; i < N; i++) {
            if (i != now && !visited[i]) {
                isValid = true;
                arr[now][0] -= arr[i][1];
                arr[i][0] -= arr[now][1];

                if (arr[now][0] <= 0) {
                    visited[now] = true;
                }

                if (arr[i][0] <= 0) {
                    visited[i] = true;
                }

                dfs(now + 1);

                if (arr[now][0] <= 0) {
                    visited[now] = false;
                }

                if (arr[i][0] <= 0) {
                    visited[i] = false;
                }

                arr[now][0] += arr[i][1];
                arr[i][0] += arr[now][1];
            }
        }

        if (!isValid) {
            dfs(now + 1);
        }
    }
}
