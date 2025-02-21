import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] arr;
    static int[][][] dp;
    static int[] d = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        arr = new int[N][M];
        dp = new int[N][M][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int j = 0; j < M; j++) {
            dp[0][j][0] = dp[0][j][1] = dp[0][j][2] = arr[0][j];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    int prev = j + d[k];
                    
                    if (prev >= 0 && prev < M) {
                        if (k == 0) dp[i][j][k] = Math.min(dp[i][j][k], Math.min(dp[i-1][prev][1], dp[i-1][prev][2]) + arr[i][j]);
                        else if (k == 1) dp[i][j][k] = Math.min(dp[i][j][k], Math.min(dp[i-1][prev][0], dp[i-1][prev][2]) + arr[i][j]);
                        else dp[i][j][k] = Math.min(dp[i][j][k], Math.min(dp[i-1][prev][0], dp[i-1][prev][1]) + arr[i][j]);
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int k = 0; k < 3; k++) {
                result = Math.min(result, dp[N - 1][i][k]);
            }
        }

        System.out.println(result);
    }
}
