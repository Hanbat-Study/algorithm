import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] items = new int[N + 1][2];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			items[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		int[] dp = new int[K + 1];
		
		for (int i = 1; i <= N; i++) {
			for (int j = K; items[i][0] <= j; j--) {
				dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
			}
		}
		
		System.out.println(dp[K]);
	}
}
