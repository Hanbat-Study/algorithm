import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] arr;
    static LinkedList<int[]> queue = new LinkedList<>();
    static int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        arr = new int[N][N];
        int maxN = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                maxN = Math.max(maxN, arr[i][j]);
            }
        }

        for (int l = 0; l <= maxN; l++) {
            int cnt = 0;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (l < arr[i][j] && !visited[i][j]) {
                        bfs(i, j, l);
                        cnt++;
                    }
                }
            }
            result = Math.max(cnt, result);
        }
        System.out.println(result);
    }

    private static void bfs(int i, int j, int l) {
        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int k = 0; k < 4; k++) {
                int dx = current[1] + dis[k][1];
                int dy = current[0] + dis[k][0];

                if (0 <= dx && dx < N && 0<= dy && dy < N && l < arr[dy][dx] && !visited[dy][dx]) {
                    queue.offer(new int[]{dy, dx});
                    visited[dy][dx] = true;
                }
            }
        }
    }
}
