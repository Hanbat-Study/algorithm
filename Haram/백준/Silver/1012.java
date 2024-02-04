import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, N, M, K, map[][], answer;
	static boolean visited[][];

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t < T+1; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken()); // y
			N = Integer.parseInt(st.nextToken()); // x
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			answer = 0;
			
			for(int i = 0; i < K; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken()); // y
				int b = Integer.parseInt(st2.nextToken()); // x
				map[b][a] = 1;
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(visited[i][j] || map[i][j] == 0) continue;
					answer++;
					bfs(new Point(i, j));
				}
			}
			
			System.out.println(answer);
		}
		
	}
	
	private static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		visited[start.x][start.y] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int x = p.x + dx[d];
				int y = p.y + dy[d];
				
				if(!isIn(x,y) || visited[x][y] || map[x][y] == 0)
					continue;
				visited[x][y] = true;
				q.offer(new Point(x, y));
			}
		}
	}

	private static boolean isIn(int x, int y) {
		if(-1 < x && x < N && -1 < y && y < M) return true;
		else return false;
	}

}
