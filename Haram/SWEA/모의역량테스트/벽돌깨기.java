import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, W, H, map[][], originMap[][], targets[], answer;
	static StringTokenizer st;
	static BufferedReader br;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t < T+1; t++) {
			input();
			
			targets = new int[N];
			permutation(0);
				
			StringBuilder sb = new StringBuilder();
			sb.append("#" + t + " " + answer);
			System.out.println(sb.toString());
		}
	}
	
	private static void permutation(int num) {
		if(num == N) {
			map = copy(originMap);
			for(int target : targets) {
				Point start = findTop(target);
				if(start == null) continue; 
				bfs(start);
				rebuildMap();
			}
			answer = Math.min(answer, count());
			return;
		}
		
		for(int i = 0; i < W; i++) {
			targets[num] = i;
			permutation(num+1);
		}
	}

	private static int count() {
		int cnt = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(map[i][j] > 0) cnt++;
			}
		}
		return cnt;
	}

	private static void rebuildMap() {
		for(int j = 0; j < W; j++) {
			Queue<Integer> queue = new ArrayDeque<>();
			for(int i = H-1; i > -1; i--) {
				if(map[i][j] == 0) continue;
				queue.offer(map[i][j]);
				map[i][j] = 0;
			}

			for(int i = H-1; i > -1; i--) {
				if(queue.isEmpty()) break;
				map[i][j] = queue.poll();
			}
		}
	}

	private static void bfs(Point start) {
		Queue<Point> queue = new ArrayDeque<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			Point target = queue.poll();
			int range = map[target.x][target.y];
			map[target.x][target.y] = 0;
			
			//if(range == 1) continue;
			for(int d = 0; d < 4; d++) {
				int nx = target.x;
				int ny = target.y;
				for(int r = 0; r < range-1; r++) {
					nx += dx[d];
					ny += dy[d];
					
					if(!isIn(nx, ny)) continue;
					if(map[nx][ny] == 0) continue; 
					queue.offer(new Point(nx, ny));
				}
			}
		}
	}

	private static boolean isIn(int x, int y) {
		return (-1 < x && x < H && -1 < y && y < W) ? true : false;
	}

	private static Point findTop(int y) {
		for(int i = 0; i < H; i++) {
			if(map[i][y] == 0) continue;
			else return new Point(i, y);
		}
		return null;
	}

	private static void input() throws Exception {
		answer = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		originMap = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; j++) {
				int ele = Integer.parseInt(st.nextToken());
				map[i][j] = ele;
				originMap[i][j] = ele;
			}
		}
	}

	private static int[][] copy(int[][] map) {
		int[][] result = new int[H][W];
		
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				result[i][j] = map[i][j];
			}
		}
		return result;
	}
}
