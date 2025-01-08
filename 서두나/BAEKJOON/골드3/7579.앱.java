import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[2][n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[0][i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			arr[1][i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[n + 1][n * 100+1];

		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n * 100; j++) {
				if (j - arr[1][i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j-arr[1][i]] + arr[0][i]);
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);

			}
		}
		for (int i = 0; i <= n * 100; i++) {
			if (dp[n][i] >= m) {
				System.out.println(i);
				break;
			}
		}
	}
}
