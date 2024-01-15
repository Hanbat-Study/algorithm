import java.io.*;

class Solution {

	static int[][] drcs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int dir = 0;

			int[][] arr = new int[n][n];
			boolean[][] visited = new boolean[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i] = new int[n];
				}
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i] = new boolean[n];
				}
			}

			int r = 0;
			int c = 0;

			for (int i = 1; i <= n * n; i++) {
				arr[r][c] = i;
				visited[r][c] = true;

				int nr = r + drcs[dir][0];
				int nc = c + drcs[dir][1];

				if (0 > nr || nr >= n || 0 > nc || nc >= n || visited[nr][nc]) {
					dir = (dir + 1) % 4;
					nr = r + drcs[dir][0];
					nc = c + drcs[dir][1];
				}
				r = nr;
				c = nc;
			}

			System.out.println("#" + test_case);

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
}
