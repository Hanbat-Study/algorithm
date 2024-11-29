import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][4];
        dp = new int[N][2];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            arr[i] = new int[]{a, b, c, d};
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[N - 1][0] = Integer.parseInt(st.nextToken());
        arr[N - 1][1] = Integer.parseInt(st.nextToken());

        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];

        if (1 < N) cal();

        System.out.println(Math.min(dp[N - 1][0], dp[N - 1][1]));
    }

    public static void cal() {
        for (int i = 1; i < N - 1; i++) {
            dp[i][0] = Math.min(dp[i-1][0] + arr[i][0], dp[i-1][1] + arr[i-1][3] + arr[i][0]);
            dp[i][1] = Math.min(dp[i-1][1] + arr[i][1], dp[i-1][0] + arr[i-1][2] + arr[i][1]);
        }

        dp[N-1][0] = Math.min(dp[N-2][0] + arr[N-1][0], dp[N-2][1] + arr[N-2][3] + arr[N-1][0]);
        dp[N-1][1] = Math.min(dp[N-2][1] + arr[N-1][1], dp[N-2][0] + arr[N-2][2] + arr[N-1][1]);
    }
}
