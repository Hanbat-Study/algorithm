import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953 {
	static int n, m, r, c, l, res;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };// udlr
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] p = {
			{},
			{0, 1, 2, 3},
			{0, 1},
			{2, 3},
			{0, 3},
			{1, 3},
			{1, 2},
			{0, 2}
	};
	static int[][] ternels = { { 1, 2, 5, 6 }, { 1, 2, 4, 7 }, { 1, 3, 4, 5 }, { 1, 3, 6, 7 } };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			res = 0;
			map = new int[n][m];
			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			bfs();
			System.out.println("#" + t + " " + res);
		}

	}

	private static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;
		int time = 1;
		while (!q.isEmpty()) {
			if (time == l + 1)
				break;
			int size = q.size();
			for (int s = 0; s < size; s++) {
				int[] cur = q.poll();
				res++;
				int curR = cur[0];
				int curC = cur[1];
				int[] dir = p[map[curR][curC]];
				for (int d : dir) {
					int nr = curR + dr[d];
					int nc = curC + dc[d];
					if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] != 0) {
						int[] ter = ternels[d];
						for (int t : ter) {
							if (map[nr][nc] == t) {
								q.offer(new int[] {nr, nc});
								visited[nr][nc] = true;
								
							}
						}
					}
				}
				
			}
			time++;


		}
	}

	private static boolean isIn(int nr, int nc) {
		return 0 <= nr && nr < n && 0 <= nc && nc < m;
	}
}
