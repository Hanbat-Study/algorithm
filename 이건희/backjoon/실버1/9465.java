import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][2];
            dp = new int[n][2];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = arr[0][0];
            dp[0][1] = arr[0][1];

            for (int i = 1; i < n; i++) {
                cal(0, i);
                cal(1, i);
            }

            System.out.println(Math.max(dp[n - 1][0], dp[n - 1][1]));
        }
    }

    public static void cal(int y, int x) {
        if (x == n) return;

        if (1 < x) {
            dp[x][y] = Math.max(dp[x - 2][y] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.max(dp[x - 2][(y + 1) % 2] + arr[x][y], dp[x][y]);
        }

        dp[x][y] = Math.max(dp[x - 1][(y + 1) % 2] + arr[x][y], dp[x][y]);
    }
}
