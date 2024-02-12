import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int l = Integer.parseInt(br.readLine());
			
			String[] tmp = br.readLine().split(" ");
			int[] cur = new int[] {Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])};

			tmp = br.readLine().split(" ");
			int[] dest = new int[] {Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])};
			
			System.out.println(BFS(l, cur, dest));
		}
		
	}
	
	private static int BFS(int l, int[] cur, int[] dest) {
		Queue<int[]> hasToVisit = new ArrayDeque<int[]>();
		int[][] board = new int[l][l];
		int cnt = 0;
		
		board[cur[0]][cur[1]] = 1;
		hasToVisit.offer(cur);
		
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
		while(!hasToVisit.isEmpty()) {
			int size = hasToVisit.size();
			for(int i = 0; i < size; i++) {
				cur = hasToVisit.poll();
				if(cur[0] == dest[0] && cur[1] == dest[1]) return cnt;
				
				for(int k = 0; k < 8; k++) {
					int idxR = cur[0] + dx[k];
					int idxC = cur[1] + dy[k];
					
					if(idxR < 0 || idxR >= l || idxC < 0 || idxC >= l || board[idxR][idxC] == 1) continue;
					
					
					board[idxR][idxC] = 1;
					hasToVisit.offer(new int[] {idxR, idxC});
				}
			}
			
			cnt++;
		}
		
		return cnt;
	}
}
