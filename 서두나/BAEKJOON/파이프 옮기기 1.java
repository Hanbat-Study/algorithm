package algorithm.baekjoon.s_0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17070 {
	static int n;
	static int[][] arr;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1, 2, 1);
		System.out.println(cnt);
	}

	static void dfs(int r, int c, int check) {

		if (r == n && c == n) {
			cnt++;
			return;
		}
		// 가로
		if (check != 2 && inRange(r - 1, c) && arr[r - 1][c] == 0) {
			dfs(r, c + 1, 1);
		}
		// 세로
		if (check != 1 && inRange(r, c - 1) && arr[r][c - 1] == 0) {
			dfs(r + 1, c, 2);
		}
		if (inRange(r, c) && arr[r][c] == 0 && inRange(r - 1, c) && arr[r - 1][c] == 0 && inRange(r, c - 1)
				&& arr[r][c - 1] == 0)
			dfs(r + 1, c + 1, 3);
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}
}
