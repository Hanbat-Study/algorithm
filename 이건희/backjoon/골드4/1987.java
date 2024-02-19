import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, result;
    static int[][] arr;
    static boolean[] visited;
    static int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        result = 0;

        arr = new int[R][C];
        visited = new boolean[26];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j) - 'A';
            }
        }

        dfs(0, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int y, int x, int cnt) {
        visited[arr[y][x]] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + dis[i][0];
            int dx = x + dis[i][1];

            if (0 <= dy && dy < R && 0 <= dx && dx < C && !visited[arr[dy][dx]]) {
                dfs(dy, dx, cnt + 1);
            }
        }

        visited[arr[y][x]] = false;

        result = Math.max(result, cnt);
    }
}
