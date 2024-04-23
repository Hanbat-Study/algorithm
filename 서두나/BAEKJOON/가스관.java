package algorithm.baekjoon.s_0423;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2931 {

	static int n, m;
	static boolean[][][] map;
	static char[][] arr;
	static int[] drs = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dcs = { 0, 1, 0, -1 };
	static int result_r;
	static int result_c;
	static char resultBlock;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new boolean[4][n][m];
		arr = new char[n][m];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = temp.charAt(j);
				setDirect(arr[i][j], i, j);
			}
		}

		findNonBlock();

		System.out.println((result_r + 1) + " " + (result_c + 1) + " " + resultBlock);

	}

	static void findNonBlock() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == '.') {
					check(i, j);
					if (isNonblock(i, j)) {
						result_r = i;
						result_c = j;
						resultBlock = getBlock(i, j);
						return;
					}
				}
			}
		}
	}

	static boolean isNonblock(int r, int c) {
		for (int i = 0; i < 4; i++) {
			if (map[i][r][c]) {
				return true;
			}
		}
		return false;
	}

	static void check(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = drs[i] + r;
			int nc = dcs[i] + c;
			int nd = (i + 2) % 4;
			if (inRange(nr, nc) && map[nd][nr][nc]) {
				map[i][r][c] = true;
			}
		}
	}

	static char getBlock(int r, int c) {
		if (map[0][r][c] && map[1][r][c] && map[2][r][c] && map[3][r][c]) {
			return '+';
		}
		if (map[0][r][c] && map[2][r][c]) {
			return '|';
		}
		if (map[1][r][c] && map[3][r][c]) {
			return '-';
		}
		if (map[1][r][c] && map[2][r][c]) {
			return '1';
		}
		if (map[0][r][c] && map[1][r][c]) {
			return '2';
		}
		if (map[0][r][c] && map[3][r][c]) {
			return '3';
		}
		if (map[2][r][c] && map[3][r][c]) {
			return '4';
		}
		return ' ';
	}

	// 북, 동, 남, 서
	static void setDirect(char b, int r, int c) {
		if (b == '|') {
			map[0][r][c] = map[2][r][c] = true;
			return;
		}
		if (b == '-') {
			map[1][r][c] = map[3][r][c] = true;
			return;
		}
		if (b == '+') {
			for (int i = 0; i < 4; i++) {
				map[i][r][c] = true;
			}
			return;
		}
		if (b == '1') {
			map[1][r][c] = map[2][r][c] = true;
			return;
		}
		if (b == '2') {
			map[0][r][c] = map[1][r][c] = true;
			return;
		}
		if (b == '3') {
			map[0][r][c] = map[3][r][c] = true;
			return;
		}
		if (b == '4') {
			map[2][r][c] = map[3][r][c] = true;
			return;
		}
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}
