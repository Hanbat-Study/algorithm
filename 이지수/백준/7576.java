import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	static int[][] tomatoes;
	static int N, M;
	static ArrayList<int[]> matureTomatoes;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		M = Integer.parseInt(tmp[0]);
		N = Integer.parseInt(tmp[1]);
		
		tomatoes = new int[N][M];
		matureTomatoes = new ArrayList<int[]>();
		int tomatoesCnt = 0;
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				tomatoes[i][j] = Integer.parseInt(tmp[j]);
				if(tomatoes[i][j] != -1) tomatoesCnt++;
				if(tomatoes[i][j] == 1) matureTomatoes.add(new int[] {i, j});
			}
		}
		
		if(tomatoesCnt == matureTomatoes.size()) {
			System.out.println(0);
			return;
		}
		
		int[] result = BFS();
		
		if(result[1] + matureTomatoes.size() < tomatoesCnt)
			System.out.println(-1);
		else
			System.out.println(result[0]);
		
	}
	
	private static int[] BFS() {
		Queue<int[]> hasToVisit = new ArrayDeque<int[]>();
		int cnt = 0;
		int tomatoCnt = 0;
		
		for(int i = 0; i < matureTomatoes.size(); i++)
			hasToVisit.offer(matureTomatoes.get(i));
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		while(!hasToVisit.isEmpty()) {
			int size = hasToVisit.size();
			for(int i = 0; i < size; i++) {
				int[] cur = hasToVisit.poll();
				
				for(int j = 0; j < 4; j++) {
					int idx1 = cur[0] + dx[j];
					int idx2 = cur[1] + dy[j];
					
					if(idx1 < 0 || idx1 >= N || idx2 < 0 || idx2 >= M || tomatoes[idx1][idx2] != 0) continue;
					
					tomatoes[idx1][idx2] = 1;
					hasToVisit.offer(new int[] {idx1, idx2});
					tomatoCnt++;
				}
			}
			cnt++;
		}
		
		return new int[] {cnt - 1, tomatoCnt};
	}
}
