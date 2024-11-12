import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class Main {
    static int N, M, areaId;
    static int[] areaSize;
    static int[][] arr, area;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        areaId = 2;
        arr = new int[N][M];
        area = new int[N][M];
        areaSize = new int[N * M + 2];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            s = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0 && area[i][j] == 0) {
                    bfs(i, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) sb.append(0);
                else sb.append((cal(i, j) + 1) % 10);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int cal(int y, int x) {
        int cnt = 0;
        HashSet<Integer> set  = new HashSet<>();

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i][0];
            int dx = x + d[i][1];

            if (0 <= dy && dy < N && 0 <= dx && dx < M && arr[dy][dx] == 0) {
                set.add(area[dy][dx]);
            }
        }

        for (Integer i : set) {
            cnt += areaSize[i];
        }

        return cnt;
    }

    public static void bfs(int y, int x) {
        int cnt = 0;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{y, x});
        area[y][x] = areaId;
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int ny = cur[0];
            int nx = cur[1];
            cnt++;

            for (int i = 0; i < 4; i++) {
                int dy = ny + d[i][0];
                int dx = nx + d[i][1];

                if (0 <= dy && dy < N && 0 <= dx && dx < M && arr[dy][dx] == 0 && !visited[dy][dx]) {
                    area[dy][dx] = areaId;
                    visited[dy][dx] = true;
                    q.add(new int[]{dy, dx});
                }
            }
        }

        areaSize[areaId] = cnt;
        areaId++;
    }
}
