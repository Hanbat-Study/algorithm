import java.io.BufferedReader;
import java.io.IOException;
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

	static int n;
	static int m;
	static int[][] arr;
	static Queue<Node> q = new LinkedList<>();
	static int result = 0;
	static int[] drs = { 0, 0, 1, -1 };
	static int[] dcs = { 1, -1, 0, 0 };

	public static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	public static int getCnt(int[][] temp) {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 2) {
					q.offer(new Node(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = drs[i] + cur.r;
				int nc = dcs[i] + cur.c;
				if (inRange(nr, nc) && temp[nr][nc] == 0) {
					temp[nr][nc] = 2;
					q.offer(new Node(nr, nc));
				}
			}

		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public static void setMap(int depth, int r, int c) {
		if (depth == 3) {
			int[][] temp = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					temp[i][j] = arr[i][j];
				}
			}
			result = Math.max(result, getCnt(temp));
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0 && (i > r || (i == r && j > c))) {
					arr[i][j] = 1;
					setMap(depth + 1, i, j);
					arr[i][j] = 0;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		setMap(0, -1, -1);
		System.out.println(result);
	}
}
