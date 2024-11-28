import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, result;
    static int[] arrN, arrM;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arrN = new int[N];
        arrM = new int[M];
        result = 0;
        dp = new int[N][M];
        String[] s = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arrN[i] = Integer.parseInt(s[i]);
        }

        s = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            arrM[i] = Integer.parseInt(s[i]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result = Math.max(result, dfs(i, j));
            }
        }

        System.out.println(result);
    }

    public static int dfs(int i, int j) {
        if (i < 0 || j < 0) return 0;
        else if (dp[i][j] != 0) return dp[i][j];
        else if (arrN[i] == arrM[j]) {
            dp[i][j] = 1 + dfs(i - 1, j - 1);

            return dp[i][j];
        }

        return dp[i][j];
    }
}
