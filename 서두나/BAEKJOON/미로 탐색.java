package com.algo.B_0201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int r;
		int c;
		int d;

		Node(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static int n;
	static int m;

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}

		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(0, 0, 1));
		arr[0][0] = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.r == n - 1 && cur.c == m - 1) {
				System.out.println(cur.d);
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + cur.r;
				int nc = dc[i] + cur.c;

				if (inRange(nr, nc) && arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
					q.offer(new Node(nr, nc, cur.d + 1));
				}
			}
		}

	}
}
