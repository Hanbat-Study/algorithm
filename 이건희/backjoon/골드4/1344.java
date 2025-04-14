import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static double A, B, result;
    static int[] nums = {0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18};
    static double[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = Double.parseDouble(br.readLine()) / 100;
        B = Double.parseDouble(br.readLine()) / 100;
        result = 0;
        dp = new double[19][19][19];

        dp[0][0][0] = 1;

        for (int i = 1; i <= 18; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= i; k++) {
                    if(0 < j) dp[i][j][k] += dp[i - 1][j - 1][k] * A * (1 - B);
                    if(0 < k) dp[i][j][k] += dp[i - 1][j][k - 1] * (1 - A) * B;
                    if(0 < j && 0 < k) dp[i][j][k] += dp[i - 1][j - 1][k - 1] * A * B;
                    dp[i][j][k] += dp[i - 1][j][k] * (1 - A) * (1 - B);
                }
            }
        }

        for (int j : nums) {
            for (int num : nums) {
                result += dp[18][j][num];
            }
        }

        System.out.println(1 - result);
    }
}
