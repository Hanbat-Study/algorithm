import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] a, b;
    static int x, y;
    static int[][] dp;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().split("");
        b = br.readLine().split("");
        x = 0;
        y = 0;
        dp = new int[a.length + 1][b.length + 1];
        sb = new StringBuilder();

        for (int i = 1; i <= a.length; i++) {
            for (int j = 1; j <= b.length; j++) {
                if (a[i - 1].equals(b[j - 1])) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        System.out.println(dp[a.length][b.length]);

        go(a.length, b.length);
        
        System.out.println(sb.reverse());
    }

    public static void go(int y, int x) {
        int num = dp[y][x];

        if (num == 0) return;

        if (dp[y - 1][x] == num) {
            go(y - 1, x);
        } else if (dp[y][x - 1] == num) {
            go(y, x - 1);
        } else {
            sb.append(a[y - 1]);
            go(y - 1, x - 1);
        }
    }
}
