import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        dp[6] = 6;

        for (int i = 7; i <= N; i++) {
            for (int j = 2; j <= 5; j++) {
                dp[i] = Math.max(dp[i - (j + 1)] * j, dp[i]);
            }
        }

        System.out.println(dp[N]);
    }
}
