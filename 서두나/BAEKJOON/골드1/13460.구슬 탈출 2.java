import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static char[][] map;

	static class Ball {
		int r, c;

		Ball(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public String toString() {
			return "[ " + r + ", " + c + " ]";
		}
	}

	static class Pair {
		Ball red;
		Ball blue;
		int d;

		Pair(Ball red, Ball blue, int d) {
			this.red = red;
			this.blue = blue;
			this.d = d;
		}
	}

	static int[] drs = { 0, 0, 1, -1 };
	static int[] dcs = { 1, -1, 0, 0 };

	static Queue<Pair> q = new LinkedList<>();

	static boolean[][][][] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		visited = new boolean[n][m][n][m];

		Ball red = null, blue = null;

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'R') {
					map[i][j] = '.';
					red = new Ball(i, j);
				} else if (map[i][j] == 'B') {
					map[i][j] = '.';
					blue = new Ball(i, j);
				}
			}
		}
		q.offer(new Pair(red, blue, 0));
		visited[red.r][red.c][blue.r][blue.c] = true;

		System.out.println(move());
	}

	// 10번 이하 이동
	private static int move() {
		while (!q.isEmpty()) {
			Pair cur = q.poll();

			for (int d = 0; d < 4; d++) {
				Ball nRed = Move(cur.red, d);
				Ball nBlue = Move(cur.blue, d);

				// 이미 방문
				if (visited[nRed.r][nRed.c][nBlue.r][nBlue.c]) {
					continue;
				}

				// 파란 공이 구멍
				if (isHole(nBlue)) {
					continue;
				}
				// 빨간 공이 구멍
				if (isHole(nRed)) {
					return cur.d + 1;
				}
				// 같은 위치
				if (nRed.r == nBlue.r && nRed.c == nBlue.c) {
					int dRed = Math.abs(nRed.r - cur.red.r) + Math.abs(nRed.c - cur.red.c);
					int dBlue = Math.abs(nBlue.r - cur.blue.r) + Math.abs(nBlue.c - cur.blue.c);
					if (dRed < dBlue) {
						nBlue.r -= drs[d];
						nBlue.c -= dcs[d];
					} else {
						nRed.r -= drs[d];
						nRed.c -= dcs[d];
					}
				}

				if (cur.d + 1 < 10) {
					q.offer(new Pair(nRed, nBlue, cur.d + 1));
					visited[nRed.r][nRed.c][nBlue.r][nBlue.c] = true;
				}
			}
		}
		return -1;
	}

	// 벽까지 이동
	private static Ball Move(Ball ball, int d) {
		int r = ball.r;
		int c = ball.c;
		while (map[r + drs[d]][c + dcs[d]] != '#') {
			r += drs[d];
			c += dcs[d];
			if (map[r][c] == 'O') {
				break;
			}
		}
		return new Ball(r, c);
	}

	// 구멍 유무
	private static boolean isHole(Ball ball) {
		return map[ball.r][ball.c] == 'O';
	}
}
