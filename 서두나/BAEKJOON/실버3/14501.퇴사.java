import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			if (i + t - 1 >= n) {
				continue;
			}
			int pre = 0;
			// 이전 수 확인
			for (int j = 0; j < i; j++) {
				pre = Math.max(pre, dp[j]);
			}
			dp[i + t - 1] = Math.max(dp[i + t - 1], p + pre);
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
