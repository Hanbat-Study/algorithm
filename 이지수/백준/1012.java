import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	
	static int[][] map;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			String[] tmp = br.readLine().split(" ");
			
			int M = Integer.parseInt(tmp[0]);
			int N = Integer.parseInt(tmp[1]);
			int K = Integer.parseInt(tmp[2]);
			
			map = new int[M + 2][N + 2];
			
			for(int i = 0; i < K; i++) {
				String[] tmp2 = br.readLine().split(" ");
				map[Integer.parseInt(tmp2[0]) + 1][Integer.parseInt(tmp2[1]) + 1] = 1;
			}
			
			int cnt = 0;
			for(int i = 1; i <= M; i++) {
				for(int j = 1; j <= N; j++) {
					if(map[i][j] == 1) {
						cnt++;
						DFS(new int[] {i, j});
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	private static void DFS(int[] point) {
		Stack<int[]> hasToVisit = new Stack<int[]>();
		hasToVisit.push(point);
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while(!hasToVisit.isEmpty()) {
			point = hasToVisit.pop();
			
			if(map[point[0]][point[1]] == 0) continue;
			
			map[point[0]][point[1]] = 0;
			
			for(int i = 0; i < 4; i++) {
				if(map[point[0] + dx[i]][point[1] + dy[i]] == 0) continue;
				
				hasToVisit.push(new int[] {point[0] + dx[i], point[1] + dy[i]});
			}
		}
	}
}
