import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static int[][] map;
	static int N, M;
	static ArrayList<int[]> virusPoint = new ArrayList<>();
	static int zeroCount;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		M = Integer.parseInt(s[1]);

		map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if(map[i][j] == 2) 
					virusPoint.add(new int[] {i, j});
				if(map[i][j] == 0)
					zeroCount++;
			}
		}
		
		zeroCount -= 3;
		System.out.println(setWall());
	}
	
	private static int setWall() {
		int range = (N - 1) * 10 + (M - 1);
		int[] select = new int[3];
		int max = 0;
		
		int r, c;
		for(int i = 0; i <= range; i++) {
			if(i % 10 >= M) continue;
			
			r = i / 10;
			c = i % 10;
			if(map[r][c] == 1 || (map[r][c] == 2)) continue;
			
			select[0] = i;
			for(int j = i + 1; j <= range; j++) {
				if(i == j || j % 10 >= M) continue;
				
				r = j / 10;
				c = j % 10;
				if(map[r][c] == 1 || (map[r][c] == 2)) continue;
				
				select[1] = j;
				for(int k = j + 1; k <= range; k++) {
					if(i == k || j == k || k % 10 >= M) continue;
					
					r = k / 10;
					c = k % 10;
					if(map[r][c] == 1 || (map[r][c] == 2)) continue;
					
					select[2] = k;
					max = Math.max(calculate(select), max);
				}
			}
		}
		
		return max;
	}
	
	private static int calculate(int[] points) {
		int[] p1 = {points[0] / 10, points[0] % 10};
		int[] p2 = {points[1] / 10, points[1] % 10};
		int[] p3 = {points[2] / 10, points[2] % 10};
		
		int[][] copyMap = new int[N][];
		for(int i = 0; i < N; i++)
			copyMap[i] = Arrays.copyOf(map[i], M);
		
		copyMap[p1[0]][p1[1]] = 1;
		copyMap[p2[0]][p2[1]] = 1;
		copyMap[p3[0]][p3[1]] = 1;

		return BFS(copyMap);
	}
	
	private static int BFS(int[][] map) {
		int count = zeroCount;
		int[] cur = virusPoint.get(0);
		Queue<int[]> hasToVisit = new ArrayDeque<int[]>();
		
		for(int[] point : virusPoint)
			hasToVisit.offer(point);
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		while(!hasToVisit.isEmpty()) {
			cur = hasToVisit.poll();
			
			for(int i = 0; i < 4; i++) {
				int idx1 = cur[0] + dx[i];
				int idx2 = cur[1] + dy[i];
				
				if(idx1 < 0 || idx1 >= N || idx2 < 0 || idx2 >= M || map[idx1][idx2] == 1 || map[idx1][idx2] == 2) continue;
				
				map[idx1][idx2] = 2;
				hasToVisit.offer(new int[] {idx1, idx2});
				count--;
			}
		}
		return count;
	}
}
