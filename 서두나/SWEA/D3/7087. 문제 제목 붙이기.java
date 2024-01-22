package algorithm.solve_240121;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			boolean[] alphabet = new boolean[26];

			for (int i = 0; i < n; i++) {
				alphabet[br.readLine().charAt(0) - 'A'] = true;
			}

			int result=26;
			for (int i = 0; i < 26; i++) {
				if (!alphabet[i]) {
					result=i;
					break;
				}
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
