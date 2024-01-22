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
			String str = br.readLine();
			int[] bit = new int[str.length()];
			for (int i = 0; i < bit.length; i++) {
				bit[i] = str.charAt(i) - '0';
			}

			int cnt = 0;
			for (int i = 0; i < bit.length; i++) {
				if (bit[i] == 1) {
					cnt++;
					for (int j = i; j < bit.length; j++) {
						bit[j] = (bit[j] + 1) % 2;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
