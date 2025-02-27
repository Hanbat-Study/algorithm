import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    static int S, result;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        result = 0;

        bfs();

        System.out.println(result);
    }

    public static void bfs() {
        Deque<int[]> q = new LinkedList<>();
        visited = new boolean[2001][2001];

        q.add(new int[]{1, 0, 0});

        visited[1][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int now = cur[0];
            int copy = cur[1];
            int cnt = cur[2];

            if (now == S) {
                result = cnt;

                return;
            }

            if (!visited[now][now]) {
                q.add(new int[]{now, now, cnt + 1});

                visited[now][now] = true;
            }

            if (0 < copy && now + copy < 2000 && !visited[now + copy][copy]) {
                q.add(new int[]{now + copy, copy, cnt + 1});

                visited[now + copy][copy] = true;
            }

            if (0 < now && !visited[now - 1][copy]) {
                q.add(new int[]{now - 1, copy, cnt + 1});

                visited[now - 1][copy] = true;
            }
        }
    }
}
