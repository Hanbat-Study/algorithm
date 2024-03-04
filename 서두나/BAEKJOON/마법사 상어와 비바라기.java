package com.jurib.offline18;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] map;
	static int[][] cloud;
	static int n, m;
	static int v = 1;

	static int[] drs = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dcs = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		cloud = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			// 구름 생성

			if (i == 0) {
				initCloud(d, s);
			} else {
				generateCloud(d, s);
			}

			rain();

			copy();

			v++;

		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] >= 2 && cloud[i][j] != v - 1) {
					map[i][j] -= 2;
				}
			}
		}
		
		
		int ans = 0;
		// 물의 양 합
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans += map[i][j];
			}
		}

		System.out.println(ans);
	}

	static Queue<Node> q = new LinkedList<>();

	static int[][] start = { { n - 1, 0 }, { n - 1, 1 }, { n - 2, 0 }, { n - 2, 1 } };

	static void initCloud(int d, int s) { // k는 버전, 1부터 시작

		for (int i = 0; i < 4; i++) {
			int nr = start[i][0] + drs[d] * s;
			int nc = start[i][1] + dcs[d] * s;

			while (!inRange(nr, nc)) {
				nr = (nr + n) % n;
				nc = (nc + n) % n;
			}
			q.offer(new Node(nr, nc));
		}
	}

	static void generateCloud(int d, int s) { // k는 버전, 2부터 시작

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] >= 2 && cloud[i][j] != v - 1) {
					int nr = i + drs[d] * s;
					int nc = j + dcs[d] * s;

					while (!inRange(nr, nc)) {
						nr = (nr + n) % n;
						nc = (nc + n) % n;

					}

					q.offer(new Node(nr, nc));
					map[i][j] -= 2;
				}
			}
		}
		// 이전에 구름이 생긴 칸은 생기지 않는다.
	}

	static int[] di = { -1, -1, 1, 1 }; // 대각선, 거리가 1
	static int[] dj = { -1, 1, -1, 1 };

	static void rain() { // 물 복사
		while (!q.isEmpty()) {
			Node cur = q.poll();

			cloud[cur.r][cur.c] = v; // 구름이 사라질 칸을 표시
			map[cur.r][cur.c]++;

			q2.add(cur);
		}

	}

	static Queue<Node> q2 = new LinkedList<>();

	static void copy() {
		while (!q2.isEmpty()) {
			Node cur = q2.poll();
			
			int cnt = 0;

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + di[i];
				int nc = cur.c + dj[i];

				if (inRange(nr, nc) && map[nr][nc] > 0) {
					cnt++;
				}

			}
			map[cur.r][cur.c] += cnt;// 물복사 버그, 비가 내려 물 1증가
		}
	}

	private static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

}
