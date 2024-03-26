package com.jurib.offline.day0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_12865 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] dp = new int[k + 1];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			for (int j = k; j >= w; j--) {
				dp[j] = Math.max(dp[j], Math.max(dp[j - w] + v, dp[j - 1]));
			}
		}

		int ans = 0;
		for (int j = 0; j < k + 1; j++) {
			ans = Math.max(ans, dp[j]);
		}

		System.out.println(ans);
	}
}
