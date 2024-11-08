import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, result;
    static int[] start, end;
    static int[][] arr;
    static boolean[][][] visited;
    static int[][] d = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        arr = new int[M][N];
        visited = new boolean[M][N][4];
        result = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        int z = Integer.parseInt(st.nextToken()) - 1;
        start = new int[]{x, y, z};
        visited[x][y][z] = true;

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken()) - 1;
        y = Integer.parseInt(st.nextToken()) - 1;
        z = Integer.parseInt(st.nextToken()) - 1;
        end = new int[]{x, y, z};

        go();

        System.out.println(result);
    }

    public static void go() {
        Queue<Integer[]> q = new LinkedList<>();
        q.offer(new Integer[]{start[0], start[1], start[2], 0});

        while (!q.isEmpty()) {
            Integer[] cur = q.poll();
            int y = cur[0];
            int x = cur[1];
            int z = cur[2];
            int cnt = cur[3];

            if (y == end[0] && x == end[1] && z == end[2]) {
                result = cnt;
                return;
            }

            for (int i = 1; i < 4; i++) {
                int ny = y + d[z][0] * i;
                int nx = x + d[z][1] * i;

                if (!check(ny, nx)) continue;

                if (arr[ny][nx] == 1) break;

                if (!visited[ny][nx][z]) {
                    visited[ny][nx][z] = true;
                    q.offer(new Integer[]{ny, nx, z, cnt + 1});
                }
            }

            int left = 0;
            int right = 0;

            if (z == 0) {
                left = 3;
                right = 2;
            } else if (z == 1) {
                left = 2;
                right = 3;
            } else if (z == 2) {
                left = 0;
                right = 1;
            } else if (z == 3) {
                left = 1;
                right = 0;
            }

            if (!visited[y][x][left]) {
                visited[y][x][left] = true;
                q.offer(new Integer[]{y, x, left, cnt + 1});
            }

            if (!visited[y][x][right]) {
                visited[y][x][right] = true;
                q.offer(new Integer[]{y, x, right, cnt + 1});
            }
        }

        result = -1;
    }

    public static boolean check(int y, int x) {
        if (0 <= y && y < M && 0 <= x && x < N) return true;
        else return false;
    }
}
