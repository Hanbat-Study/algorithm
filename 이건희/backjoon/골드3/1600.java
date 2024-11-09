import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int K, W, H, result;
    static int[][] arr;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] md = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, 1}};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H][W];
        visited = new boolean[H][W][K + 1];
        result = 0;

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(result);
    }

    public static void bfs() {
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            Integer[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            int cnt = poll[2];
            int chance = poll[3];

            if (y == H - 1 && x == W - 1) {
                result = cnt;
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = y + d[i][0];
                int nx = x + d[i][1];

                if (isCheck(ny, nx) && !visited[ny][nx][chance]) {
                    visited[ny][nx][chance] = true;
                    q.offer(new Integer[]{ny, nx, cnt + 1, chance});
                }
            }

            if (chance < K) {
                for (int i = 0; i < 8; i++) {
                    int ny = y + md[i][0];
                    int nx = x + md[i][1];

                    if (isCheck(ny, nx) && !visited[ny][nx][chance + 1]) {
                        visited[ny][nx][chance + 1] = true;
                        q.offer(new Integer[]{ny, nx, cnt + 1, chance + 1});
                    }
                }
            }
        }

        result = -1;
    }

    public static boolean isCheck(int y, int x) {
        if (0 <= y && y < H && 0 <= x && x < W && arr[y][x] == 0) return true;
        return false;
    }
}
