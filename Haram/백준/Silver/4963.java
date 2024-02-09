import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	static int w, h, map[][], answer;
	static boolean visited[][];
	static String input, inputs[];
	static Queue<Point> q;
	
	static int[] dx = {-1, 1, 0, 0, 1, 1, -1, -1};
	static int[] dy = {0, 0, -1, 1, 1, -1, 1, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			inputs = br.readLine().split(" ");
			w = Integer.parseInt(inputs[0]);
			h = Integer.parseInt(inputs[1]);
			
			if(w == 0 && h == 0) 
				break;
			
			map = new int[h][w];
			visited = new boolean[h][w];
			answer = 0;
			q = new ArrayDeque<>();
			
			for(int i = 0; i < h; i++) 
				map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(visited[i][j] || map[i][j] == 0) continue;
					bfs(new Point(i, j));
					answer++;	
				}
			}
			
			System.out.println(answer);
		}
	}

	private static void bfs(Point start) {
		q.offer(start);
		visited[start.x][start.y] = true;
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d = 0; d < 8; d++) {
				int x = p.x + dx[d];
				int y = p.y + dy[d];
				
				if(!isIn(x, y) || visited[x][y] || map[x][y] == 0) continue;
				q.offer(new Point(x, y));
				visited[x][y] = true;
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		if(-1 < x && x < h && -1 < y && y < w) return true;
		else return false;
	}
}