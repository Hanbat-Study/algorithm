import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
	
	static int[][] maps;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		maps = new int[N + 2][N + 2];
		
		for(int i = 1; i <= N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 1; j <= N; j++)
				maps[i][j] = Integer.parseInt(tmp[j - 1]);
		}
		
		int cnt = 0;
		int[] cnts = new int[N * N / 2 + 1];
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(maps[i][j] == 1)
					cnts[cnt++] = DFS(new int[] {i, j});
			}
		}
		
		System.out.println(cnt);
		Arrays.sort(cnts, 0, cnt);
		for(int i = 0; i < cnt; i++)
			System.out.println(cnts[i]);
	}
	
	private static int DFS(int[] point) {
		int cnt = 0;
		Stack<int[]> hasToVisit = new Stack<int[]>(); 
		hasToVisit.push(point);
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while(!hasToVisit.isEmpty()) {
			point = hasToVisit.pop();
			
			if(maps[point[0]][point[1]] == 0) continue;
			
			maps[point[0]][point[1]] = 0;
			cnt++;
			
			for(int i = 0; i < 4; i++) {
				if(maps[point[0] + dx[i]][point[1] + dy[i]] == 0) continue;
				
				hasToVisit.push(new int[] {point[0] + dx[i], point[1] + dy[i]});
			}
		}
		
		return cnt;
	}
}
