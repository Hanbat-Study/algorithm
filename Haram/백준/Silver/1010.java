import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());	
			M = Integer.parseInt(st.nextToken());
			
			int[][] dp = new int[M+1][N+1];
			
			for(int i = 0; i <= M; i++) {
				for(int j = 0, end = Math.min(i, N); j <= end; j++) {
					if(j == 0 || j == i) dp[i][j] = 1;
					else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				}
			}
			
			System.out.println(dp[M][N]);
		}
	}
}
