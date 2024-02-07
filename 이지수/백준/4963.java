import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int[][] map;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		
		while(!s.equals("0 0")) {
			int w = Integer.parseInt(s.split(" ")[0]);
			int h = Integer.parseInt(s.split(" ")[1]);
			
			map = new int[h + 2][w + 2];
			int cnt = 0;
			for(int i = 1; i <= h; i++) {
				String[] tmp = br.readLine().split(" ");
				for(int j = 1; j <= w; j++) {
					map[i][j] = Integer.parseInt(tmp[j - 1]);
					if(map[i][j] == 1) cnt++;
				}
			}
			
			int r = 1;
			int c = 0;
			int result = 0;
			while(cnt > 0) {
				if(c >= w) {
					c = 1;
					r++;
				}
				else
					c++;

				if(map[r][c] == 0) continue;

				cnt -= DFS(new int[] {r, c});
				result++;
			}
		
			System.out.println(result);			
			s = br.readLine();
		}
	}
	
	private static int DFS(int[] cur) {
		int cnt = 0;
		Stack<int[]> hasToVisit = new Stack<int[]>();
		hasToVisit.push(cur);
		
		int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
		int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1}; 
		while(!hasToVisit.isEmpty()) {
			cur = hasToVisit.pop();
			
			if(map[cur[0]][cur[1]] == 0) continue;
			
			map[cur[0]][cur[1]] = 0;
			
			for(int i = 0; i < 8; i++) {
				int idxR = cur[0] + dx[i];
				int idxC = cur[1] + dy[i];
						
				if(map[idxR][idxC] == 0) continue;
				
				hasToVisit.push(new int[] {idxR, idxC});
			}
			
			cnt++;
		}
		
		
		return cnt;
	}
}
