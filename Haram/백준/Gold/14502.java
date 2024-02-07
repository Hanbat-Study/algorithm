import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, M, map[][], n, answer, cnt;
	static List<Point> blanks;
	static boolean isSelected[], visited[][];
	static Point[] walls;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		blanks = new ArrayList<Point>();
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 0)
					blanks.add(new Point(i, j));
			}
		}
		
		n = blanks.size();
		isSelected = new boolean[n];
		walls = new Point[3];
		answer = 0;
		
		buildTheWall(0, 0, map);
		
		System.out.println(answer);
	}
	
	private static void buildTheWall(int start, int depth, int[][] map) {
		if(depth == 3) {
			for(int idx = 0; idx < 3; idx++)
				map[walls[idx].x][walls[idx].y] = 1;
			
			visited = new boolean[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 2 && !visited[i][j]) {
						bfs(new Point(i, j));					
					}
				}
			}
			
			cnt = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0 && !visited[i][j])
						cnt++;					
				}
			}
			
			answer = Math.max(cnt, answer);

			for(int idx = 0; idx < 3; idx++)
				map[walls[idx].x][walls[idx].y] = 0;
			return;
		}
		
		for(int i = start; i < n; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			walls[depth] = blanks.get(i);
			buildTheWall(i+1, depth+1, map);
			isSelected[i] = false;
		}
	}

	private static void bfs(Point startPoint) {
		Queue<Point> q = new LinkedList<Point>();
		q.offer(startPoint);
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			visited[p.x][p.y] = true;
			cnt++;
			
			for(int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				
				if(!isIn(x, y) || visited[x][y]) continue;
				if(map[x][y] == 0) {
					visited[x][y] = true;
					q.offer(new Point(x, y));
				}				
			}
		}
	}

	private static boolean isIn(int x, int y) {
		if(-1 < x && x < N && -1 < y && y < M) return true;
		else return false;
	}
}
