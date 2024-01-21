package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int check = -1;
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i] == 1) {
					check = i;
				} else if (d + check == i && arr[d + check] == 0) {
					cnt += 1;
					check = i;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}
