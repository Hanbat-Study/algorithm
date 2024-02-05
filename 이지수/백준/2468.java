import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

	static int[][] map;
	static boolean[][] visited;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N + 2][N + 2];
		
		Set<Integer> hashSet = new HashSet<Integer>();
		for(int i = 1; i <= N; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(tmp[j - 1]);
				hashSet.add(map[i][j]);
			}
		}
		
		List<Integer> heights = new ArrayList<Integer>(hashSet);
		Collections.sort(heights);
		int[] heightCnt = new int[heights.size()];
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				heightCnt[heights.indexOf(map[i][j])]++;
			}
		}
		
		int result = 1;
		int cntSum = N * N;
		for(int i = 0; i < heights.size() - 1; i++) {
			visited = new boolean[N + 2][N + 2];
			cntSum -= heightCnt[i];
			int tmp = cntSum;
			int cnt = 0;

			int r = 1;
			int c = 1;
			while(tmp > 0) {
				if(map[r][c] <= heights.get(i) || visited[r][c]) {
					if(c < N)
						c++;
					else {
						c = 1;
						r++;
					}
					continue;
				}
				
				tmp -= DFS(heights.get(i), new int[] {r, c});
				cnt++;
			}
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);
	}
	
	private static int DFS(int height, int[] cur) {
		int cnt = 0;
		Stack<int[]> hasToVisit = new Stack<int[]>();
		hasToVisit.push(cur);
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while(!hasToVisit.isEmpty()) {
			cur = hasToVisit.pop();

			if(visited[cur[0]][cur[1]]) continue;
			
			visited[cur[0]][cur[1]] = true;
			
			for(int i = 0; i < 4; i++) {
				int r = cur[0] + dx[i];
				int c = cur[1] + dy[i];
				
				if(visited[r][c] || map[r][c] <= height) continue;
				
				hasToVisit.push(new int[] {r, c});
			}
			
			cnt++;
		}
		
		return cnt;
	}
}
