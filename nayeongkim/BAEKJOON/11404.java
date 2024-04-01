import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	private static int n, m;
	private static int[][] cities;
	private static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		cities = new int[m][3];
		StringBuilder sb = new StringBuilder();
		dp = new int[n+1][n+1];
		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=n; j++) {
				dp[i][j] = 1000000000;
			}
		}
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dp[a][b] = Math.min(dp[a][b], c);
			
			
		}
		for (int k = 1; k <=n; k++) {
			for (int i = 1; i <= n; i++) {
				if (i != k) {
					for (int j = 1; j <= n; j++) {
						if (j !=k && j != i) {
							dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
				
						
						}
					}
					
				}
				
				
			}
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <=n; j++) {
			if (dp[i][j]== 1000000000) dp[i][j] = 0;
				sb.append(dp[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}

}
