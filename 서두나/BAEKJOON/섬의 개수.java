import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] drs = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dcs = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Queue<Node> q = new LinkedList<>();
	static int w;
	static int h;
	static int[][] arr;

	static boolean inRange(int r, int c) {
		return 0 <= r && r < h && 0 <= c && c < w;
	}

	static void bfs(int r, int c) {
		arr[r][c] = 0;
		q.offer(new Node(r, c));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 8; i++) {
				int nr = cur.r + drs[i];
				int nc = cur.c + dcs[i];

				if (inRange(nr, nc) && arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
					q.offer(new Node(nr, nc));
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				break;
			}

			arr = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1) {
						cnt++;
						bfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
