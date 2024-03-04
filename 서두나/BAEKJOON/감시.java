package algorithm.baekjoon.s_0225;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_15683 {

	static class Node {
		int no;
		int r, c;

		Node() {

		}

		void set(int no, int r, int c) {
			this.no = no;
			this.r = r;
			this.c = c;
		}
	}

	static int n;
	static int m;
	static int[][] map;
	static int[][] temp;
	static Node[] cctv = new Node[8];
	static int[] comb = new int[8];
	static int cnt = 0;

	static List<int[][]> nums = new ArrayList<>();
	static int[][] num1 = { { 0 }, { 1 }, { 2 }, { 3 } };
	static int[][] num2 = { { 1, 3 }, { 0, 2 } };
	static int[][] num3 = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } };
	static int[][] num4 = { { 3, 0, 1 }, { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 } };
	static int[][] num5 = { { 0, 1, 2, 3 } };

	static int[] drs = { -1, 0, 1, 0 };
	static int[] dcs = { 0, 1, 0, -1 };

	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 초기화
		nums.add(num1);
		nums.add(num2);
		nums.add(num3);
		nums.add(num4);
		nums.add(num5);

		for (int i = 0; i < 8; i++) {
			cctv[i] = new Node();
		}

		// 입력
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		temp = new int[n][];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= map[i][j] && map[i][j] <= 5) { // cctv
					cctv[cnt++].set(map[i][j], i, j);
				}
			}
		}

		// 방향 조합
		getComb(0);

		System.out.println(result);
	}

	// 방향 조합
	private static void getComb(int depth) {

		if (depth == cnt) {
			setMap();
			return;
		}

		for (int i = 0; i < nums.get(cctv[depth].no - 1).length; i++) {
			comb[depth] = i;
			getComb(depth + 1);
		}
	}

	// 지도 세팅
	private static void setMap() {
		for (int i = 0; i < n; i++) { // 복제
			temp[i] = map[i].clone();
		}

		for (int i = 0; i < cnt; i++) {
			for (int d : nums.get(cctv[i].no - 1)[comb[i]]) { // 이동할 방향
				int nr = cctv[i].r;
				int nc = cctv[i].c;
				while (true) {
					nr += drs[d];
					nc += dcs[d];

					if (!inRange(nr, nc) || temp[nr][nc] == 6) { // 벽이거나 범위를 벗어나면 중지
						break;
					}

					if (temp[nr][nc] == 0) {
						temp[nr][nc] = 7;
					}
				}
			}
		}

		// 사각 지대 최소 크기
		result = Math.min(result, getSafezone());
	}

	private static int getSafezone() {
		int k = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (temp[i][j] == 0) {
					k++;
				}
			}
		}

		return k;
	}

	private static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}
}
