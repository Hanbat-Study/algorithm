import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String A, B;
    static StringBuilder sb;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A = br.readLine();
        B = br.readLine();
        sb = new StringBuilder();
        dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int cnt = dp[A.length()][B.length()];
        int n = A.length();
        int m = B.length();

        while (0 < cnt) {
            if (dp[n - 1][m] == cnt) n--;
            else if (dp[n][m - 1] == cnt) m--;
            else {
                sb.append(A.charAt(n - 1));
                cnt--;
                n--;
                m--;
            }
        }

        System.out.println(sb.reverse());
    }
}
