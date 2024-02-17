import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static int[][] room;
	static int N, result;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		room = new int[N][N];
		
		String[] tmp;
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for(int j = 0; j < N; j++)
				room[i][j] = Integer.parseInt(tmp[j]);
		}
		
		dfs(new int[] {0, 0}, new int[] {0, 1}, 0);
		
		System.out.println(result);
	}
	
	// dir -> 가로 0 / 세로 1 / 대각선 2
	static int[][] dx = {{0, 1}, {1, 1}, {0, 1, 1}};
	static int[][] dy = {{1, 1}, {0, 1}, {1, 0, 1}};
	static int[][] nextdir = {{0, 2}, {1, 2}, {0, 1, 2}};
	private static void dfs(int[] cur1, int[] cur2, int dir) {	
		if(cur2[0] == N - 1 && cur2[1] == N - 1) {
			result++;
			return;
		}

		if(room[cur2[0]][cur2[1]] == 1) return;

		room[cur1[0]][cur1[1]] = 1;
			
		for(int d = 0; d < nextdir[dir].length; d++) {
			int idxr2, idxc2;

			idxr2 = cur2[0] + dx[dir][d];
			idxc2 = cur2[1] + dy[dir][d];

			if(idxr2 >= N || idxc2 >= N) continue;

			if(nextdir[dir][d] != 2 && room[idxr2][idxc2] == 1) continue;
			
			if(nextdir[dir][d] == 2 && (room[idxr2][idxc2] == 1 || room[idxr2 - 1][idxc2] == 1 || room[idxr2][idxc2 - 1] == 1)) continue;
				
				
			dfs(cur2, new int[] {idxr2, idxc2}, nextdir[dir][d]);
		}

		room[cur1[0]][cur1[1]] = 0;
	}
}
