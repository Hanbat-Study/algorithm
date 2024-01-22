package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int cnt = 0;
			for (int j = 0; j < n; j++) {
				int pre = 0;
				for (int i = 0; i < n; i++) {
					if (pre == 1 && arr[i][j] == 2) {
						cnt++;
						pre = 0;
					} else if (arr[i][j] == 1) {
						pre = 1;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);

		}
	}
}
