import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] drs = { -1, 0, 0, 1, -1, -1, 1, 1 };
	static int[] dcs = { 0, -1, 1, 0, -1, 1, -1, 1 };
	static int n;
	static int[][] arr;

	static Queue<Node> q = new LinkedList<>();

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			sb.append("#" + test_case + " ");

			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < n; j++) {
					if (temp.charAt(j) == '*') {
						arr[i][j] = -1;
						for (int k = 0; k < 8; k++) {
							int nr = i + drs[k];
							int nc = j + dcs[k];
							if (inRange(nr, nc) && arr[nr][nc] != -1) {
								arr[nr][nc]++;
							}
						}

					}
				}
			}

			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 0) {
						bfs(i, j);
						cnt++;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] != -1) {
						cnt++;
					}
				}
			}

			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

	private static void bfs(int r, int c) {

		q.add(new Node(r, c));
		arr[r][c] = -1;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 8; i++) {
				int nr = cur.r + drs[i];
				int nc = cur.c + dcs[i];

				if (!inRange(nr, nc)) {
					continue;
				}
				if (arr[nr][nc] == 0) {
					q.add(new Node(nr, nc));
				}
				arr[nr][nc] = -1;

			}
		}
	}
}
