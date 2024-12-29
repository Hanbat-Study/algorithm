import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int L, R, C, result;
    static int[] start;
    static char[][][] arr;
    static int[][] d = {{0, -1, 0}, {0, 0, 1}, {0, 1, 0}, {0, 0, -1}, {-1, 0, 0}, {1, 0, 0}};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();

            if (line.equals("0 0 0")) break;

            StringTokenizer st = new StringTokenizer(line);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            arr = new char[L][R][C];
            visited = new boolean[L][R][C];
            result = -1;
            start = new int[3];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = br.readLine();

                    for (int k = 0; k < C; k++) {
                        arr[i][j][k] = s.charAt(k);
                        if (arr[i][j][k] == 'S') start = new int[]{i, j, k};
                    }
                }

                br.readLine();
            }

            go(start[0], start[1], start[2]);

            if (result == -1) System.out.println("Trapped!");
            else System.out.println("Escaped in " + result + " minute(s).");
        }
    }

    public static void go(int h, int y, int x) {
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{h, y, x, 0});
        visited[h][y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int dh = cur[0];
            int dy = cur[1];
            int dx = cur[2];
            int dCnt = cur[3];

            if (arr[dh][dy][dx] == 'E') {
                result = dCnt;

                return;
            }

            for (int i = 0; i < 6; i++) {
                int nh = d[i][0] + dh;
                int ny = d[i][1] + dy;
                int nx = d[i][2] + dx;

                if (0 <= nh && nh < L && 0 <= ny && ny < R && 0 <= nx && nx < C
                        && !visited[nh][ny][nx] && (arr[nh][ny][nx] == '.' || arr[nh][ny][nx] == 'E')) {
                    visited[nh][ny][nx] = true;
                    q.add(new int[]{nh, ny, nx, dCnt + 1});
                }
            }
        }
    }
}
