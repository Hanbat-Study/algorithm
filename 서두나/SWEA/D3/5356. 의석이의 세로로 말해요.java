package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
    
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String[] arr = new String[5];
			for (int i = 0; i < 5; i++) {
				arr[i] = br.readLine();
			}
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < 15; j++) {
				for (int i = 0; i < 5; i++) {
					if (arr[i].length() > j) {
						sb.append(arr[i].charAt(j));
					}
				}
			}
			System.out.println("#" + test_case + " " + sb.toString());
		}
	}

}
