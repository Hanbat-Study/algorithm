import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[3][N + 1];

        if (N == 1) {
            System.out.println(0);

            return;
        }

        dp[0][2] = 1;
        dp[1][2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[0][i] = (dp[1][i - 1] + dp[2][i - 1]) % 1000000007;
            dp[1][i] = (dp[0][i - 1] + dp[2][i - 1]) % 1000000007;
            dp[2][i] = (dp[0][i - 1] + dp[1][i - 1]) % 1000000007;
        }

        System.out.println(dp[0][N]);
    }
}
