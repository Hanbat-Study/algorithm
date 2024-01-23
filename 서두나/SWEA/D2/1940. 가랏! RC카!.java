import java.util.Scanner;
import java.util.StringTokenizer;
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
			int d = 0;
			int sp = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				if (c != 0) {
					int m = Integer.parseInt(st.nextToken());
					if (c == 1) { // 가속
						sp += m;

					} else if (c == 2) { // 감속
						sp = Math.max(0, sp - m);
					}
				}
				d += sp;

			}
			System.out.println("#" + test_case + " " + d);
		}
	}
}
