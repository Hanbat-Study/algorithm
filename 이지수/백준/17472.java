import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static int[][] map;
	static int N, M, islandCnt;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		
		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = -Integer.parseInt(tmp[j]);
			}
		}
		
		int r = 0;
		int c = 0;
		while(r < N && c < M) {
			if(map[r][c] == -1) {
				map[r][c] = ++islandCnt;
				bfs(islandCnt, r, c);
			}
			
			if(c == M - 1) {
				r++;
				c = 0;
			}
			else
				c++;
		}
		
		int[][] weights = new int[islandCnt][islandCnt];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] != 0) {
					int[] d = makeBridge(map[i][j], i, j);

					if(d != null && (weights[map[i][j] - 1][d[1] - 1] == 0 || weights[map[i][j] - 1][d[1] - 1] > d[0])) {
						weights[map[i][j] - 1][d[1] - 1] = d[0];
						weights[d[1] - 1][map[i][j] - 1] = d[0];
					}
				}
			}
		}
		
		int[] minEdge = new int[islandCnt];
		boolean[] visited = new boolean[islandCnt];
		Arrays.fill(minEdge,  1, islandCnt, Integer.MAX_VALUE);
		
		int result = 0;
		int i;
		for(i = 0; i < islandCnt; i++) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for(int j = 0; j < islandCnt; j++) {
				if(!visited[j] && minEdge[j] < min) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			if(minVertex == -1) break;
			
			result += min;
			visited[minVertex] = true;
			
			for(int j = 0; j < islandCnt; j++) {
				if(!visited[j] && weights[minVertex][j] != 0 && weights[minVertex][j] < minEdge[j]) {
					minEdge[j] = weights[minVertex][j];
				}
			}
		}
		
		System.out.println(i == islandCnt ? result : -1);
	}
	
	private static int[] makeBridge(int islandNum, int r, int c) {		
		for(int k = 0; k < 4; k++) {
			int d = 0;
			int other = 0;
			
			int idx1 = r;
			int idx2 = c;
			while(true) {
				idx1 += dx[k];
				idx2 += dy[k];
				
				if(idx1 < 0 || idx1 >= N || idx2 < 0 || idx2 >= M || map[idx1][idx2] == islandNum) break;

				if(map[idx1][idx2] == 0) {
					d++;
					continue;
				}
				
				other = map[idx1][idx2];
				if(d >= 2) 
					return new int[] {d, other};
				else
					break;
			}
		}
		
		return null;
	}

	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	private static void bfs(int islandN, int r, int c) {
		Queue<Integer> hasToVisit = new ArrayDeque<Integer>();
		hasToVisit.offer(r);
		hasToVisit.offer(c);
		
		while(!hasToVisit.isEmpty()) {
			r = hasToVisit.poll();
			c = hasToVisit.poll();
			
			for(int k = 0; k < 4; k++) {
				int idx1 = r + dx[k];
				int idx2 = c + dy[k];
				
				if(idx1 < 0 || idx1 >= N || idx2 < 0 || idx2 >= M) continue;
				
				if(map[idx1][idx2] != -1) continue;
				
				map[idx1][idx2] = islandN;
				
				hasToVisit.offer(idx1);
				hasToVisit.offer(idx2);
			}
		}
	}
}
