import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static char[][] arr;
	static int[][][] dp;
	static String word;
	static int N, M, K;

	static int[] drs = { 0, 0, 1, -1 };
	static int[] dcs = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new char[N][M];

		for (int i = 0; i < N; i++) {
			String temp = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = temp.charAt(j);
			}
		}

		word = br.readLine();

		dp = new int[N][M][word.length()];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				Arrays.fill(dp[i][j], -1);
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == word.charAt(0)) {
					ans += dfs(i, j, 0);
				}
			}
		}

		System.out.println(ans);
	}

	static int dfs(int r, int c, int d) {
		if (d == word.length() - 1) {
			return 1;
		}

		if (dp[r][c][d] != -1) {
			return dp[r][c][d];
		}

		// 초기값
		dp[r][c][d] = 0;
		for (int k = 1; k <= K; k++) {
			for (int i = 0; i < 4; i++) {
				int nr = drs[i] * k + r;
				int nc = dcs[i] * k + c;
				if (0 > nr || nr >= N || 0 > nc || nc >= M) {
					continue;
				}

				if (arr[nr][nc] == word.charAt(d + 1)) {
					dp[r][c][d] += dfs(nr, nc, d + 1);
				}
			}
		}
		return dp[r][c][d];
	}
}
