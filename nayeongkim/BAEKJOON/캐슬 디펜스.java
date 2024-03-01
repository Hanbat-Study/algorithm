package algorithm.baekjoon.s_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17135 {

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

		void set(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n;
	static int m;
	static int d;

	static List<Node> target = new ArrayList<>();
//	static boolean[] die; // 필드에서 사라질때
	static int[][] map;
	static int[] hunter = new int[3];

	static int ans = 0;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 입력
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		map = new int[n][m];
//		temp = new boolean[m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 궁수 조합
		comb(0, 0);

		// 적의 위치 이동

		//
		System.out.println(ans);

	}

	// m개의 수에서 3개의 위치를 찾는다.
	private static void comb(int depth, int cur) {
		if (depth == 3) {
			// System.out.println(Arrays.toString(hunter));
			getMax();
			ans = Math.max(ans, cnt);
			return;
		}

		for (int i = cur; i < m; i++) {
			hunter[depth] = i;
			comb(depth + 1, i + 1);
		}
	}

//	static int[] temp;

	private static void getMax() {

		cnt = 0;

		while (true) {
			boolean[][] visited = new boolean[n][m];

			for (int k = 0; k < 3; k++) {
				for (int i = n - 1; i > n - 1 - d; i--) {
					for (int j = 0; j < m; j++) {
						System.out.println(i + " " + j);
						if (map[i][j] == 1 && Math.abs(i - n) + Math.abs(j - hunter[k]) <= d) {
							if (!visited[i][j]) {
								cnt++;
							}
							visited[i][j] = true;
							break;
						}
					}
				}
			}

			for (int i = n - 1; i > -1; i--) {
				if (i == 0) {
					for (int j = 0; j < m; j++) {
						map[i][j] = 0;
					}
				} else {
					for (int j = 0; j < m; j++) {
						map[i][j] = map[i - 1][j];
					}
				}
			}

			if (check()) {
				break;
			}
		}
	}

	static boolean check() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}

}
