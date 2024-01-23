package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/algorithm/solve_240121/input.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				String temp = br.readLine();
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp.charAt(j) - '0';
				}
			}

			int result = 0;

			// 상
			int k = n / 2;
			for (int i = 0; i < n / 2; i++) {
				for (int j = k; j < n - k; j++) {
					result += arr[i][j];
				}
				k--;
			}

			// 아래
			for (int i = n / 2; i < n; i++) {
				for (int j = k; j < n - k; j++) {
					result += arr[i][j];
				}
				k++;
			}

			System.out.println("#" + test_case + " " + result);

		}
	}
}
