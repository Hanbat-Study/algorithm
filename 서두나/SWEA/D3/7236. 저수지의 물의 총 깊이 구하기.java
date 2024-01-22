package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static int drs[][] = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
	static int n;

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());

			char arr[][] = new char[n][n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
			}

			// 탐색
			int total = 1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = 0;
					for (int k = 0; k < drs.length; k++) {
						int nr = i + drs[k][0];
						int nc = j + drs[k][1];
						if (inRange(nr, nc) && arr[nr][nc] == 'W') {
							cnt++;
						}
					}
					total = Math.max(total, cnt);
				}
			}
			System.out.println("#" + test_case + " " + total);
		}
	}
}
