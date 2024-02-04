import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int M, N,result;
    static int[][] arr;
    static int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static LinkedList<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            result = 0;
            arr = new int[N][M];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 1 && bfs(i, j) > 0) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    private static int bfs(int y, int x) {
        int cnt = 0;
        queue.offer(new int[]{y, x});
        arr[y][x] = 0;

        while (!queue.isEmpty()) {
            cnt++;
            int[] current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dy = current[0] + dis[i][0];
                int dx = current[1] + dis[i][1];

                if (0 <= dx && dx < M && 0 <= dy && dy < N && arr[dy][dx] == 1) {
                    queue.offer(new int[]{dy, dx});
                    arr[dy][dx] = 0;
                }
            }
        }
        return cnt;
    }
}
