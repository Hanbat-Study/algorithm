package com.algo.B_0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Node {
		int r;
		int c;
		char pre;

		Node(int r, int c, char pre) {
			this.r = r;
			this.c = c;
			this.pre = pre;
		}
	}

	static int n;
	static char[][] arr;
	static int[][] temp;
	static Queue<Node> q = new LinkedList<>();
	static int[] drs = { 0, 0, 1, -1 };
	static int[] dcs = { 1, -1, 0, 0 };

	// 기준에 따라 수 구함,

	public static void bfs(int r, int c) {
		q.offer(new Node(r, c, arr[r][c]));
		if (arr[r][c] == 'B') {
			arr[r][c] = '1';

		} else {
			arr[r][c] = '2';
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + drs[i];
				int nc = cur.c + dcs[i];
				if (0 <= nr && nr < n && 0 <= nc && nc < n && arr[nr][nc] == cur.pre) {
					q.offer(new Node(nr, nc, arr[nr][nc]));

					if (arr[nr][nc] == 'B') {
						arr[nr][nc] = '1';

					} else {
						arr[nr][nc] = '2';
					}
				}
			}
		}
	}

	public static void bfs2(int r, int c) {
		q.offer(new Node(r, c, arr[r][c]));
		arr[r][c] = '0';

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + drs[i];
				int nc = cur.c + dcs[i];
				if (0 <= nr && nr < n && 0 <= nc && nc < n && arr[nr][nc] == cur.pre) {
					q.offer(new Node(nr, nc, arr[nr][nc]));
					arr[nr][nc] = '0';
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new char[n][];
		temp = new int[n][];

		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != '1' && arr[i][j] != '2') {
					bfs(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt).append(" ");

		cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] != '0') {
					bfs2(i, j);
					cnt++;
				}
			}
		}
		sb.append(cnt);
		System.out.println(sb);
	}
}
