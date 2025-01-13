import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] w = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				w[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 20이하까지
		int[][] dp = new int[1 << n][n];

		for (int i = 0; i < (1 << n); i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}

		dp[1 << 0][0] = 0;

		for (int visited = 0; visited < (1 << n); visited++) {
			for (int cur = 0; cur < n; cur++) {
				if ((visited & (1 << cur)) == 0) { // 방문하지 않았다.
					continue;
				}
				for (int next = 0; next < n; next++) {
					// 이미 방문했으면
					if ((visited & (1 << next)) != 0 || w[cur][next]==0 || dp[visited][cur] == Integer.MAX_VALUE) {
						continue;
					}
					dp[visited | (1 << next)][next] = Math.min(dp[visited | (1 << next)][next],
							dp[visited][cur] + w[cur][next]);
				}

			}
		}

		int ans = Integer.MAX_VALUE;
		for (int cur = 0; cur < n; cur++) {
			if (dp[(1 << n) - 1][cur] != Integer.MAX_VALUE && w[cur][0] > 0) {
				ans = Math.min(ans, dp[(1 << n) - 1][cur] + w[cur][0]);
			}
		}

		System.out.println(ans);

	}
}
