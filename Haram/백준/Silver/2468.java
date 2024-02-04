import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, n, maxHeight, map[][], answer, cnt;
	static boolean[][] visited;
	
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) 
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		maxHeight = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(maxHeight < map[i][j])
					maxHeight = map[i][j];
			}
		}
		
		answer = 0;
		
		for(n = 0; n < maxHeight+1; n++) {
			cnt = 0;
			visited = new boolean[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(visited[i][j] || map[i][j] <= n) continue;
					cnt++;
					dfs(0, new Point(i, j));
				}				
			}
			answer = Math.max(answer, cnt);
		}
		
		System.out.println(answer);
	}
	
	private static void dfs(int depth, Point p) {
		for(int d = 0; d < 4; d++) {
			int x = p.x + dx[d];
			int y = p.y + dy[d];
			if(!isIn(x, y) || visited[x][y] || map[x][y] <= n) continue;
			visited[x][y] = true;
			dfs(depth+1, new Point(x, y));
		}
	}

	private static boolean isIn(int x, int y) {
		if(-1 < x && x < N && -1 < y && y < N) return true;
		else return false;
	}
}
