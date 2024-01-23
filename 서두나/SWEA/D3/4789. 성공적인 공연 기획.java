package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws Exception {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String clap = br.readLine();
			int cnt = 0;
			int result = 0;
			for (int i = 0; i < clap.length(); i++) {
				int temp = Math.max(0, i - cnt);
				result += temp;
				cnt += clap.charAt(i) - '0' + temp;
			}
			System.out.println("#" + test_case + " " + result);
		}
	}
}
