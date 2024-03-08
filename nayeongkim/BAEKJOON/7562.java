import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[][] map;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			visited = new boolean[n][n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			bfs(startX, startY);
			System.out.println(map[endX][endY]);
		}
	}
	private static void bfs(int startX, int startY) {
		Queue<int[]> q = new LinkedList<>();
		visited[startX][startY] = true;
		q.offer(new int[] {startX, startY});
		while(!q.isEmpty()) {
				int[] now = q.poll();
				int nowX = now[0];
				int nowY = now[1];
				for (int d = 0; d <8; d++) {
					int nx = nowX + dx[d];
					int ny = nowY + dy[d];
					
					if (isIn(nx, ny) && !visited[nx][ny]) {
						q.offer(new int[] {nx, ny});
						visited[nx][ny] = true;
						map[nx][ny] = map[nowX][nowY] + 1;
					}
				
			}

		}
	}
	private static boolean isIn(int nx, int ny) {
		return (0 <= nx && nx < n && 0 <=ny && ny < n);
	}
}
