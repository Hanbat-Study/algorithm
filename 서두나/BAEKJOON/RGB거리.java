import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][3];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[3][n];

		for (int i = 0; i < 3; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < 3; i++) {
			dp[i][0] = arr[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					if (k == j) {
						continue;
					}
					dp[j][i] = Math.min(dp[j][i], dp[k][i - 1] + arr[i][j]);
				}
			}
		}

		System.out.println(Math.min(dp[0][n-1], Math.min(dp[1][n-1],dp[2][n-1])));
	}
}
