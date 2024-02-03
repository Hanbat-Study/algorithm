import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, K, result;
    static LinkedList<int[]> queue = new LinkedList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        result = 0;
        visited = new boolean[100001];

        bfs(N);
        System.out.println(result);
    }

    private static void bfs(int now) {
        visited[now] = true;
        queue.offer(new int[]{now, 0});

        while (!queue.isEmpty()) {
            int[] idx = queue.poll();
            int index = idx[0];
            int cnt = idx[1];
            if (index == K) {
                result = cnt;
                break;
            }
            if (0 <= index - 1 && index - 1 <= 100000 && !visited[index - 1]) {
                queue.offer(new int[]{index - 1, cnt + 1});
                visited[index - 1] = true;
            }
            if (0 <= index + 1 && index + 1 <= 100000 && !visited[index + 1]) {
                queue.offer(new int[]{index + 1, cnt + 1});
                visited[index + 1] = true;
            }
            if (0 <= index * 2 && index * 2 <= 100000 && !visited[index * 2]) {
                queue.offer(new int[]{index * 2, cnt + 1});
                visited[index * 2] = true;
            }
        }
    }
}
