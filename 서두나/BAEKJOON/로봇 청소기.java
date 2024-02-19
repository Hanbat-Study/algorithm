import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14503 {

	static class Node {
		int r, c, d;

		Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int n;
	static int m;
	static int cnt;
	static int[][] arr;
	static Queue<Node> q = new LinkedList<>();

	static int[] drs = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dcs = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.offer(new Node(r, c, d));
		arr[r][c] = 2;

		cnt = 1;
		bfs();

		System.out.println(cnt);
	}

	private static void bfs() {

		while (!q.isEmpty()) {

			Node cur = q.poll();

			if (!isClean(cur.r, cur.c, cur.d)) { // 청소할 곳이 없다.
				int dir = (cur.d + 2) % 4;

				int nr = cur.r + drs[dir];
				int nc = cur.c + dcs[dir];

				if (!inRange(nr, nc) || arr[nr][nc] == 1) {
					return;
				}
				if (arr[nr][nc] == 0) {	// 뒤로 갈때 청소가 안된다.
					arr[nr][nc] = 2;
					cnt++;
				}
				q.offer(new Node(nr, nc, cur.d));
			}

		}

	}

	private static boolean isClean(int r, int c, int d) {

		int dir = d;
		for (int i = 0; i < 4; i++) {
			dir = (dir + 3) % 4;

			int nr = r + drs[dir];
			int nc = c + dcs[dir];

			if (inRange(nr, nc) && arr[nr][nc] == 0) {
				q.offer(new Node(nr, nc, dir));
				arr[nr][nc] = 2;
				cnt++;
				return true;
			}
		}
		return false;
	}

	private static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}
