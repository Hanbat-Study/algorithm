import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static class Node {
		int r, c, cnt, d;

		Node(int r, int c, int cnt, int d) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.d = d;
		}
	}

	static int[] drs = { -1, 0, 1, 0 }; // 북,동,남,서
	static int[] dcs = { 0, 1, 0, -1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		char[][] map = new char[n][n];
		boolean[][][] visited = new boolean[4][n][n];

		Deque<Node> q = new ArrayDeque<>();

		boolean check = true;

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == '#' && check) {
					check = false;
					for (int k = 0; k < 4; k++) {
						q.offer(new Node(i, j, 0, k));
						visited[k][i][j] = true;
					}
					map[i][j] = '.';
				}
			}
		}

		while (!q.isEmpty()) {

			Node cur = q.poll();

			int nr = drs[cur.d] + cur.r;
			int nc = dcs[cur.d] + cur.c;

			if (!(0 <= nr && nr < n && 0 <= nc && nc < n) || visited[cur.d][nr][nc] || map[nr][nc] == '*') {
				continue;
			}

			// 현재 방향, 거울 방향 2개
			if (map[nr][nc] == '.') {
				visited[cur.d][nr][nc] = true;
				q.addFirst(new Node(nr, nc, cur.cnt, cur.d));
			} else if (map[nr][nc] == '!') {
				visited[cur.d][nr][nc] = true;
				q.addFirst(new Node(nr, nc, cur.cnt, cur.d));

				visited[(cur.d + 1) % 4][nr][nc] = true;
				q.addLast(new Node(nr, nc, cur.cnt + 1, (cur.d + 1) % 4));

				visited[(cur.d + 3) % 4][nr][nc] = true;
				q.addLast(new Node(nr, nc, cur.cnt + 1, (cur.d + 3) % 4));
			} else {
				System.out.println(cur.cnt);
				return;
			}

		}

	}
}
