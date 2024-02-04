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

	static Queue<Node> q = new LinkedList<>();
	static int n;
	static int[][] arr;
	static boolean[][] isVisited;
	static int[] dr = { 0, 0, 1, -1 };
	static int[] dc = { 1, -1, 0, 0 };

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < n;
	}

	static void bfs(int r, int c, int k) {
		q.offer(new Node(r, c));
		isVisited[r][c] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];

				if (inRange(nr, nc) && !isVisited[nr][nc] && arr[nr][nc] > k) {
					q.offer(new Node(nr, nc));
					isVisited[nr][nc] = true;
				}
			}
		}
	}

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

		int result = 1;	//비가 안오는 경우
		for (int k = 1; k < 101; k++) {
			isVisited = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (isVisited[i][j] || arr[i][j] <= k) {
						continue;
					}
					bfs(i, j, k);
					cnt++;
				}
			}
			if (cnt == 0) {
				break;
			}
			result = Math.max(result, cnt);
		}
		System.out.println(result);
	}

}
