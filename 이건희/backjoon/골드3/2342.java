import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] d = {{0, 2, 2, 2, 2},{0, 1, 3, 4, 3}, {0, 3, 1, 3, 4}, {0, 4, 3, 1, 3}, {0, 3, 4, 3, 1}};
    static int[][][] dp;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();

        while (true) {
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) break;

            list.add(n);
        }

        dp = new int[list.size()][5][5];

        System.out.println(cal(0, 0, 0));
    }

    public static int cal(int now, int l, int r) {
        if (now == list.size()) return 0;

        if (dp[now][l][r] != 0) return dp[now][l][r];

        int next = list.get(now);

        dp[now][l][r] = Math.min(cal(now + 1, next, r) + d[l][next], cal(now + 1, l, next) + d[r][next]);

        return dp[now][l][r];
    }
}
