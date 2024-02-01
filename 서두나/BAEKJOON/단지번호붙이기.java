package algorithm.baekjoon.s_0201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static Queue<Node> q = new LinkedList<>();
	static int n;
	static int[][] arr;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	static int getCnt(int r, int c) {
		int cnt = 0;
		q.offer(new Node(r, c));
		arr[r][c] = 0;

		while (!q.isEmpty()) {
			Node cur = q.poll();
			cnt++;

			for (int i = 0; i < 4; i++) {
				int nr = dr[i] + cur.r;
				int nc = dc[i] + cur.c;

				if (inRange(nr, nc) && arr[nr][nc] == 1) {
					arr[nr][nc] = 0;
					q.offer(new Node(nr, nc));
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					result.add(getCnt(i, j));
				}
			}
		}
		result.sort(null);
		System.out.println(result.size());
		for (int num : result) {
			System.out.println(num);
		}
	}

}
