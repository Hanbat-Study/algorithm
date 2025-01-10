import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Node {
		int r, c, d;

		Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int[] drs = { 0, 0, 0, -1, 1, -1, -1, 1, 1 };
	static int[] dcs = { 0, 1, -1, 0, 0, 1, -1, 1, -1 };

	static char[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[8][8];

		for (int i = 0; i < 8; i++) {
			String temp = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = temp.charAt(j);
			}
		}

		System.out.println(run(new Node(7, 0, 1)));

	}

	static int run(Node node) {
		Queue<Node> q = new LinkedList<>();

		q.offer(node);

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 9; i++) {
				int nr = cur.r + drs[i];
				int nc = cur.c + dcs[i];

				if (0 > nr || nr >= 8 || 0 > nc || nc >= 8) {
					continue;
				}
				// 이동전
				if (nr - (cur.d - 1) >= 0 && map[nr - (cur.d - 1)][nc] == '#') {
					continue;
				}

				// 이동 후
				if (nr - cur.d >= 0 && map[nr - cur.d][nc] == '#') {
					continue;
				}

				if (nr == 0 && nc == 7) {
					return 1;
				}

				q.offer(new Node(nr, nc, cur.d + 1));
			}

		}
		return 0;
	}
}
