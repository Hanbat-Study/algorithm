package algorithm.baekjoon.s_0218;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_4012 {

	static int n;
	static int[][] arr;
	static boolean[] check;
	static int ans;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("src/data/4012.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			ans = Integer.MAX_VALUE;
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			check = new boolean[n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dfs(0, 0);
			System.out.println("#" + test_case + " " + ans);
		}
	}

	static void dfs(int depth, int cnt) {

		if (cnt == n / 2) {
			ans = Math.min(ans, getDiff());
			return;
		}
		if (depth == n) {
			return;
		}

		check[depth] = true;
		dfs(depth + 1, cnt + 1);
		check[depth] = false;
		dfs(depth + 1, cnt);
	}

	static int getDiff() {
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (check[i] && check[j]) {
					a += arr[i][j];
				} else if (!check[i] && !check[j]) {
					b += arr[i][j];
				}
			}
		}
		return Math.abs(a - b);
	}
}
