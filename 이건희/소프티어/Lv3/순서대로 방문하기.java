import java.io.*;
import java.util.*;

public class Main {
    static int n, m, y, x;
    static int[][] arr, root;
    static HashSet<String> set;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        root = new int[m][2];
        set = new HashSet<>();
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            root[i] = new int[]{a, b};
        }

        y = root[0][0];
        x = root[0][1];
        visited[y][x] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(y).append(x);

        go(y, x, sb, 1);

        System.out.println(set.size());
    }

    public static void go(int y, int x, StringBuilder sb, int goal) {
        if (y == root[m - 1][0] && x == root[m - 1][1] && goal == m) {
            set.add(sb.toString());

            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if (0 <= ny && ny < n && 0 <= nx && nx < n && arr[ny][nx] == 0 && !visited[ny][nx]) {
                visited[ny][nx] = true;

                if (ny == root[goal][0] && nx == root[goal][1]) {
                    go(ny, nx, new StringBuilder(sb).append(ny).append(nx), goal + 1);
                } else {
                    go(ny, nx, new StringBuilder(sb).append(ny).append(nx), goal);
                }

                visited[ny][nx] = false;
            }
        }
    }
}
