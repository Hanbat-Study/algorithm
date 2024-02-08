import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r;
		int c;
		int day;

		Node(int r, int c, int day) {
			this.r = r;
			this.c = c;
			this.day = day;
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };
	static int[][] arr;
	static Queue<Node> q = new LinkedList<>();
	static int n;
	static int m;
	static int result = 0;

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	static void bfs() {

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.day > result) {
				result = cur.day;
			}

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + cur.r;
				int nc = dc[i] + cur.c;

				if (inRange(nr, nc) && arr[nr][nc] == 0) {
					arr[nr][nc] = 1;
					q.offer(new Node(nr, nc, cur.day + 1));
				}
			}
		}
	}

	static void check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					result = -1;
					return;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					q.offer(new Node(i, j, 0));
					cnt++;
				}
			}
		}

		if (cnt == n * m) {
			result = 0;
		} else {
			bfs();
			check();
		}
		System.out.println(result);

	}
}
//가장 큰 날이 모든 토마토가 익는다. 인접한 익은 토마토가 없으면, 토마토는 안익는다.
// 이미 모든 토마토가 익는다. 1 다 안익는다. 0 다 익는 시간 result
