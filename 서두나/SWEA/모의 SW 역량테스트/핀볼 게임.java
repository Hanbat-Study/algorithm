package algorithm.baekjoon.s_0223;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5650 {

	static class Node {
		int r;
		int c;

		Node() {

		}

		void set(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N;
	static int[][] map = new int[100][100];
	static StringTokenizer st;
	static int[] drs = { -1, 0, 1, 0 }; // 북, 동, 남, 서
	static int[] dcs = { 0, 1, 0, -1 };
	static Node[][] worm = new Node[2][5]; // 웜홀
	static boolean[] wormCheck = new boolean[5]; // 웜홀
	static long ans;

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/data/5650.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(br.readLine());

		// 초기화
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 5; j++) {
				worm[i][j] = new Node();
			}
		}

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			// 초기화
			ans = 0;
			for (int i = 0; i < 5; i++) {
				wormCheck[i] = false;
			}

			// 입력
			N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 6) {
						if (wormCheck[map[i][j] - 6]) {
							worm[1][map[i][j] - 6].set(i, j);
						} else {
							worm[0][map[i][j] - 6].set(i, j);
							wormCheck[map[i][j] - 6] = true;
						}
					}
				}
			}

			// 공 이동, 처음 시작 위치, 방향, 지정

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 0) { // 블록, 웜홀, 블랙홀 위치에서는 출발할 수 없다.
						move(i, j);
					}

				}
			}

			sb.append(ans + "\n");
		}
		System.out.println(sb.toString().trim());
	}

	static void move(int r, int c) {

		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			int d = i;
			long cnt = 0; // 점수

			while (true) {
				nr += drs[d];
				nc += dcs[d];

				if (!inRange(nr, nc)) { // 벽에 부딪힐때, 범위 밖일때
					nr -= drs[d];
					nc -= dcs[d];
					d = (d + 2) % 4;
					cnt++;
				}

				// 웜홀, 이동이 되면서, 이동방향은 유지
				if (map[nr][nc] >= 6) {
					Node node = setRc(map[nr][nc], nr, nc);
					nr = node.r;
					nc = node.c;
				}

				// 블록
				else if (map[nr][nc] >= 1) {
					d = setDirect(map[nr][nc], d);
					cnt++;
				} else if (map[nr][nc] == -1 || (nr == r && nc == c)) { // 블랙홀, 원래 위치
					ans = Math.max(ans, cnt);
					break;
				}

			}
		}
	}

	// 벽이나 블록을 부딪힌 횟수가 점수

	// 블록 종류에 따른 방향 변환
	static int setDirect(int num, int d) {
		if (num == 1) { //
			if (d == 3) { // 서
				return (d + 1) % 4;
			}

			if (d == 2) { // 남
				return (d + 3) % 4;
			}
		}

		if (num == 3) {
			if (d == 1) { // 동
				return (d + 1) % 4;
			}

			if (d == 0) { // 북
				return (d + 3) % 4;
			}
		}

		if (num == 2) {
			if (d == 3) { // 서
				return (d + 3) % 4;
			}
			if (d == 0) { // 북
				return (d + 1) % 4;
			}
		}

		if (num == 4) {
			if (d == 1) { // 동
				return (d + 3) % 4;
			}
			if (d == 2) { // 남
				return (d + 1) % 4;
			}
		}

		// 나머지 부분과 5
		return (d + 2) % 4;
	}

	static Node temp = new Node();

	// 웜홀
	static Node setRc(int num, int r, int c) {

		for (int i = 0; i < 2; i++) {
			if (worm[i][num - 6].r == r && worm[i][num - 6].c == c) {
				temp.set(worm[(i + 1) % 2][num - 6].r, worm[(i + 1) % 2][num - 6].c);
				return temp;
			}
		}

		return null;
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < N && 0 <= c && c < N;
	}
}
