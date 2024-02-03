import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
	static int N, map[][];
	static boolean[][] visited;
	static List<Integer> nums;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][];
		
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
		
		visited = new boolean[N][N];
		
		int cnt = 0;
		nums = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 || visited[i][j]) continue; 
				cnt++;
				visited = bfs(new Point(i, j), 0);
			}
		}
		
		Collections.sort(nums);
		bw.append(cnt + "\n");
		for(int i = 0; i < nums.size(); i++) 
			bw.append(nums.get(i) + "\n");
		
		bw.flush();
		bw.close();
	}
	
	private static boolean[][] bfs(Point p, int n) {
		Queue<Point> q = new LinkedList<>();
		q.offer(p);
		
		while(!q.isEmpty()) {
			p = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int x = p.x + dx[d];
				int y = p.y + dy[d];
				
				if(!isIn(x,y) || visited[x][y] || map[x][y] == 0) continue;
				visited[x][y] = true;
				n++;
				q.offer(new Point(x, y));
			}
		}
		
		if(n == 0)
			n++;
		nums.add(n);
		return visited;
	}

	private static boolean isIn(int x, int y) {
		if(-1 < x && x < N && -1 < y && y < N) return true;
		else return false;
	}
}
