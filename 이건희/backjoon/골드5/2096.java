import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            cal1(i, 0);
            cal1(i, 1);
            cal1(i, 2);
        }

        int maxNum = Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = 1000000;
            }
        }

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for (int i = 1; i < n; i++) {
            cal2(i, 0);
            cal2(i, 1);
            cal2(i, 2);
        }

        int minNum = Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));

        System.out.println(maxNum + " " + minNum);
    }

    public static void cal1(int x, int y) {
        if (y == 0) {
            dp[x][y] = Math.max(dp[x - 1][0] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.max(dp[x - 1][1] + arr[x][y], dp[x][y]);
        } else if (y == 1) {
            dp[x][y] = Math.max(dp[x - 1][0] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.max(dp[x - 1][1] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.max(dp[x - 1][2] + arr[x][y], dp[x][y]);
        } else {
            dp[x][y] = Math.max(dp[x - 1][1] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.max(dp[x - 1][2] + arr[x][y], dp[x][y]);
        }
    }

    public static void cal2(int x, int y) {
        if (y == 0) {
            dp[x][y] = Math.min(dp[x - 1][0] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.min(dp[x - 1][1] + arr[x][y], dp[x][y]);
        } else if (y == 1) {
            dp[x][y] = Math.min(dp[x - 1][0] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.min(dp[x - 1][1] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.min(dp[x - 1][2] + arr[x][y], dp[x][y]);
        } else {
            dp[x][y] = Math.min(dp[x - 1][1] + arr[x][y], dp[x][y]);
            dp[x][y] = Math.min(dp[x - 1][2] + arr[x][y], dp[x][y]);
        }
    }
}
