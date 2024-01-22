import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[] dX = {-1, -1, -1, 0, 1, 1, 1, 0};
	private static int[] dY = {-1, 0, 1, 1, 1, 0, -1, -1};	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {		
			int N = Integer.parseInt(br.readLine());
			int[][] reservoir = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					reservoir[i][j] = st.nextToken().charAt(0);
				}
			}
			
			int maxDepth = 1;
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(reservoir[i][j] == 'W') {
						int tempDepth = measureDepth(i, j, reservoir, N);
						if(tempDepth > maxDepth)
							maxDepth = tempDepth;
					}
				}
			}
			
			System.out.printf("#%d %d\n", (t+1), maxDepth);
 		}
	}
	private static int measureDepth(int i, int j, int[][] reservoir, int N) {
		int result = 0;
		for(int idx = 0; idx < 8; idx++) {
			int x = i + dX[idx];
			int y = j + dY[idx];
			if(isIn(x, y, N) && reservoir[x][y] == 'W')
				result++;
		}
		return result;
	}
	
	private static boolean isIn(int x, int y, int N) {
		if(-1 < x && x < N && -1 < y && y < N)
			return true;
		else
			return false;
	}
}