package algorithm.baekjoon.s_0201;

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

	static int[][] arr;
	static int n;
	static int m;

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static Queue<Node> q = new LinkedList<>();

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n + 1 && 0 <= c && c < m + 1;
	}

	static void bfs(int r, int c) {
		q.offer(new Node(r, c));
		arr[r][c] = 0;

		while (!q.isEmpty()) {

			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + cur.r;
				int nc = dc[i] + cur.c;

				if (inRange(nr, nc) && arr[nr][nc] == 1) {
					q.offer(new Node(nr, nc));
					arr[nr][nc] = 0;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			arr = new int[n + 1][m + 1];

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[b][a] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < n + 1; i++) {
				for (int j = 0; j < m + 1; j++) {
					if (arr[i][j] == 1) {
						bfs(i, j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
