import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main{
	private static int n, k, res;
	private static int[] weight, value;
	private static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		weight = new int[n + 1];
		value = new int[n + 1];
		dp= new int[n+1][k + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 0;
		}
		for (int i = 0; i <= k; i++) {
			dp[0][i] = 0;
		}
		for (int i = 1; i <= n; i++) {
			for (int w = 1; w <= k; w++) {
				if (weight[i] > w) dp[i][w] = dp[i - 1][w];
				else {
					dp[i][w] = Math.max(dp[i - 1][ w - weight[i]] + value[i], dp[i - 1][w]);
				}
			}
		}
		System.out.println(dp[n][k]);
	}

}
