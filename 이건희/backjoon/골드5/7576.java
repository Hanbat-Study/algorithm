import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int M, N, result;
    static int[][] arr;
    static int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        result = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    list.add(new int[]{i, j});
                }
            }
        }

        bfs();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
                result = Math.max(result, arr[i][j]);
            }
        }

        System.out.println(result - 1);
    }

    private static void bfs() {
        LinkedList<int[]> queue = new LinkedList<>();

        for (int[] pos : list) {
            queue.offer(pos);
        }

        while (!queue.isEmpty()) {
            int[] d = queue.poll();
            int nx = d[1];
            int ny = d[0];

            for (int i = 0; i < 4; i++) {
                int dx = nx + dis[i][1];
                int dy = ny + dis[i][0];

                if (0 <= dx && dx < M && 0 <= dy && dy < N && arr[dy][dx] == 0) {
                    arr[dy][dx] = arr[ny][nx] + 1;
                    queue.offer(new int[]{dy, dx});
                }
            }
        }
    }
}
