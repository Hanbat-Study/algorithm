import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static int[][] arr, dp;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = 0;
        arr = new int[n][n];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == 0) dfs(i, j);

                result = Math.max(result, dp[i][j]);
            }
        }

        System.out.println(result);
    }

    public static void dfs(int y, int x) {
        dp[y][x] = 1;

        for (int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if (0 <= ny && ny < n && 0 <= nx && nx < n && arr[y][x] < arr[ny][nx]) {
                if (dp[ny][nx] == 0) dfs(ny, nx);

                dp[y][x] = Math.max(dp[y][x], dp[ny][nx] + 1);
            }
        }
    }
}
