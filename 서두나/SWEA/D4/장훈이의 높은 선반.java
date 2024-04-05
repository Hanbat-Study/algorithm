package com.jurib.offline.day0405;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1486 {
	static int n;
	static int b;
	static int[] h;
	static int minNum;

	public static void main(String args[]) throws Exception {

		System.setIn(new FileInputStream("data/1486.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());

			h = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}

			minNum = Integer.MAX_VALUE;
			recur(0, 0);
			System.out.println("#" + test_case + " " + (minNum - b));
		}
	}

	static void recur(int depth, int cnt) {
		if (cnt >= b) {
			minNum = Math.min(minNum, cnt);
			return;
		}
		if (depth == n) {
			return;
		}
		recur(depth + 1, cnt);
		recur(depth + 1, cnt + h[depth]);
	}
}
