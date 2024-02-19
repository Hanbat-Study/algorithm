import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, map[][], dp[][][];
	static BufferedReader br;

	static int[] dx = {0, 1, 1};
	static int[] dy = {1, 0, 1};
	public static void main(String[] args) throws Exception {
		input();
		
		dp[0][1][0] = 1;
		for(int y = 2; y < N; y++) {
			if(map[0][y] == 1) continue;
			dp[0][y][0] = dp[0][y-1][0];
		}
		
		for(int x = 1; x < N; x++) { 
			for(int y = 1; y < N; y++) { 
				if(map[x][y] == 0 && map[x][y-1] == 0 && map[x-1][y] == 0) {
					dp[x][y][2] = dp[x-1][y-1][0] + dp[x-1][y-1][1] + dp[x-1][y-1][2];
				}
				if(map[x][y] == 0) {
					dp[x][y][0] = dp[x][y-1][0] + dp[x][y-1][2];
					dp[x][y][1] = dp[x-1][y][1] + dp[x-1][y][2];
				}
			}
		}
		
		System.out.println(dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2]);
	}
	
	private static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		// 가로, 세로, 대각선 
		dp = new int[N][N][3];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
