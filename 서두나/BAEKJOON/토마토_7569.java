package algorithm.baekjoon.s_0210;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int k;
		int r;
		int c;
		int d;

		Node(int k, int r, int c, int d) {
			this.k = k;
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static Queue<Node> q = new LinkedList<>();
	static int m;
	static int n;
	static int h;
	static int day = -1;
	static int total = 0;
	static int[][][] tomato;
	static int[] dks = { 0, 0, 0, 0, -1, 1 }; // 동, 서, 남, 북, 상, 하
	static int[] drs = { 0, 0, 1, -1, 0, 0 };
	static int[] dcs = { 1, -1, 0, 0, 0, 0 };

	static boolean inRange(int k, int r, int c) {
		return 0 <= k && k < h && 0 <= r && r < n && 0 <= c && c < m;
	}

	static void bfs() {

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.d > day) {
				day = cur.d;
			}

			for (int i = 0; i < 6; i++) {
				int nk = dks[i] + cur.k;
				int nr = drs[i] + cur.r;
				int nc = dcs[i] + cur.c;

				if (inRange(nk, nr, nc) && tomato[nk][nr][nc] == 0) {
					tomato[nk][nr][nc] = 1;
					q.offer(new Node(nk, nr, nc, cur.d + 1));
					total++;
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		tomato = new int[h][n][m];
		int cnt = m * n * h;

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					tomato[k][i][j] = Integer.parseInt(st.nextToken());

					if (tomato[k][i][j] == 1) { // 익은 토마토
						q.offer(new Node(k, i, j, 0));
					} else if (tomato[k][i][j] == -1) { // 토마토 아님
						cnt--;
					}

				}
			}
		}
		if (q.size() == cnt) { // 다 익음
			day = 0;
		} else {
			total = q.size();
			bfs();
			if (total != cnt) { // 다 못익음
				day = -1;
			}
		}

		System.out.println(day);
	}
}
