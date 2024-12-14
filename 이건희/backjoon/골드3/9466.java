import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T, n, result;
    static int[] arr;
    static boolean[] visited, finished;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            result = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= n; i++) {
                if (!finished[i]) DFS(i);
            }

            System.out.println(n - result);
        }
    }

    public static void DFS(int now) {
        if (visited[now]) {
            finished[now] = true;
            result++;
        } else {
            visited[now] = true;
        }

        if (!finished[arr[now]]) {
            DFS(arr[now]);
        }

        visited[now] = false;
        finished[now] = true;
    }
}
