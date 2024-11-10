import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] arr, area;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        area = new int[N][N];
        result = Integer.MAX_VALUE;
        int cnt = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (area[i][j] == 0 && arr[i][j] == 1) {
                    bfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (0 < area[i][j]) {
                    visited = new boolean[N][N];
                    go(i, j);
                }
            }
        }

        System.out.println(result);
    }

    public static void go(int y, int x) {
        int num = area[y][x];

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x, 0});
        visited[y][x] = true;


        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ny = cur[0];
            int nx = cur[1];
            int cnt = cur[2];

            if (0 < area[ny][nx] && area[ny][nx] != num) {
                result = Math.min(result, cnt - 1);

                return;
            }

            for (int i = 0; i < 4; i++) {
                int dy = ny + d[i][0];
                int dx = nx + d[i][1];

                if (!isCheck(dy, dx) || visited[dy][dx] || area[dy][dx] == num) continue;

                visited[dy][dx] = true;

                q.offer(new int[]{dy, dx, cnt + 1});
            }
        }
    }

    public static void bfs(int y, int x, int cnt) {
        Queue<Integer[]> q = new ArrayDeque<>();
        q.add(new Integer[]{y, x});
        area[y][x] = cnt;

        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            int ny = cur[0];
            int nx = cur[1];

            for (int i = 0; i < 4; i++) {
                int dy = ny + d[i][0];
                int dx = nx + d[i][1];

                if (!isCheck(dy, dx) || arr[dy][dx] == 0 || area[dy][dx] != 0) continue;

                area[dy][dx] = cnt;
                q.offer(new Integer[]{dy, dx});
            }
        }
    }

    public static boolean isCheck(int y, int x) {
        if (0 <= y && y < N && 0 <= x && x < N) return true;
        return false;
    }
}
