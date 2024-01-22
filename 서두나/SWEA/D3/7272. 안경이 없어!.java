package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Solution {

	static List<Character> one = new ArrayList<>(Arrays.asList('A', 'D', 'O', 'P', 'Q', 'R'));

	static boolean validChar(char a, char b) {
		if (a == b) {
			return true;
		}
		if (a == 'B' || b == 'B') {
			return false;
		}
		if (one.indexOf(a)!=-1 && one.indexOf(b)!=-1) {
			return true;
		}
		if (one.indexOf(a)==-1 && one.indexOf(b)==-1) {
			return true;
		}

		return false;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			String result = "SAME";
			if (a.length() != b.length()) {
				System.out.println("#" + test_case + " " + "DIFF");
			} else {
				for (int i = 0; i < a.length(); i++) {
					if (!validChar(a.charAt(i), b.charAt(i))) {
						result = "DIFF";
						break;
					}
				}
				System.out.println("#" + test_case + " " + result);
			}
		}
	}
}
