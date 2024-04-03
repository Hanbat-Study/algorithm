package com.jurib.offline.day0403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 물 : '*', 돌:'x', 비버 굴:'D', 고슴도치의 위치: 'S' 

public class Main_3055 {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class Node2 {
		int r;
		int c;
		int d;

		Node2(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	static int[] drs = { -1, 1, 0, 0 };
	static int[] dcs = { 0, 0, 1, -1 };

	static char[][] map;
	static int[][] water;

	static int ans;

	public static void main(String[] args) throws Exception {

		Queue<Node> q = new LinkedList<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		Node start = null;
		Node end = null;

		map = new char[r][c];
		water = new int[r][c];

		ans = -1;

		for (int i = 0; i < r; i++) {
			String temp = br.readLine();
			for (int j = 0; j < c; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == '*') {
					q.offer(new Node(i, j));
					water[i][j] = 1;
				} else if (map[i][j] == 'S') {
					start = new Node(i, j);
				} else if (map[i][j] == 'D') {
					end = new Node(i, j);
				}
			}
		}

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = drs[i] + cur.r;
				int nc = dcs[i] + cur.c;
				if (!(0 <= nr && nr < r && 0 <= nc && nc < c)) {
					continue;
				}
				if (map[nr][nc] == 'X') {
					continue;
				}
				if (water[nr][nc] > 0) {
					continue;
				}
				if (map[nr][nc] != 'D') {
					water[nr][nc] = water[cur.r][cur.c] + 1;
					q.offer(new Node(nr, nc));
				}
			}
		}

		findMinDist(start, end, r, c);

		System.out.println((ans != -1) ? ans : "KAKTUS");
	}

	static void findMinDist(Node start, Node end, int r, int c) {
		Queue<Node2> q2 = new LinkedList<>();

		q2.offer(new Node2(start.r, start.c, 1));
		water[start.r][start.c] = -1;

		while (!q2.isEmpty()) {
			Node2 cur = q2.poll();

			for (int i = 0; i < 4; i++) {
				int nr = drs[i] + cur.r;
				int nc = dcs[i] + cur.c;
				if (!(0 <= nr && nr < r && 0 <= nc && nc < c)) {
					continue;
				}
				if (nr == end.r && nc == end.c) {
					ans = cur.d;
					return;
				}
				if (map[nr][nc] == 'X') {
					continue;
				}
				if (water[nr][nc] > cur.d + 1 || water[nr][nc] == 0) {
					q2.offer(new Node2(nr, nc, cur.d + 1));
					water[nr][nc] = -1;
				}

			}
		}
	}

}
