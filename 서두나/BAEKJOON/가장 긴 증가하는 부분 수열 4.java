package algorithm.baekjoon.s_0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14002 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n + 1];
		int[] dp = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i + 1] = Integer.parseInt(st.nextToken());
			for (int j = i; j >= 0; j--) {
				if (a[j] < a[i + 1]) {
					dp[i + 1] = Math.max(dp[j] + 1, dp[i + 1]);
				}
			}
		}

		int index = 0;

		for (int i = 1; i < n + 1; i++) {
			if (index < dp[i]) {
				index = dp[i];
			}
		}

		StringBuilder sb = new StringBuilder();
		int temp = index;
		for (int i = n; i > 0; i--) {
			if (dp[i] == temp) {
				temp--;
				sb.insert(0, a[i] + " ");
			}
		}

		System.out.println(index);
		System.out.println(sb.toString().strip());
	}
}
