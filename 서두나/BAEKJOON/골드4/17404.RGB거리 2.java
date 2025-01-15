import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];
		int[][][] dp = new int[n][3][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 3; i++) {
			dp[0][i][i] = arr[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (dp[i - 1][(j + 1) % 3][k] != 0 && dp[i - 1][(j + 2) % 3][k] != 0) {
						dp[i][j][k] = Math.min(dp[i - 1][(j + 1) % 3][k], dp[i - 1][(j + 2) % 3][k]) + arr[i][j];
					} else if (dp[i - 1][(j + 1) % 3][k] != 0) {
						dp[i][j][k] = dp[i - 1][(j + 1) % 3][k] + arr[i][j];
					} else if (dp[i - 1][(j + 2) % 3][k] != 0) {
						dp[i][j][k] = dp[i - 1][(j + 2) % 3][k] + arr[i][j];
					}
				}
			}
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i != j && dp[n - 1][i][j] != 0) {
					ans = Math.min(ans, dp[n - 1][i][j]);
				}
			}
		}

		System.out.println(ans);
	}

}
