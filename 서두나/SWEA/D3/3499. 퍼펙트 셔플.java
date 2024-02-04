package algorithm;

import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			String[] card = new String[n];
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < n; i++) {
				card[i] = st.nextToken();
			}

			StringBuilder sb = new StringBuilder();
			int k1 = 0;
			int k2 = n / 2;
			if (n % 2 != 0) {
				k2++;
			}
			while (k1 < n / 2) {
				sb.append(card[k1]);
				sb.append(" ");
				sb.append(card[k2]);
				sb.append(" ");
				k1++;
				k2++;
			}
			if (n % 2 != 0) {
				sb.append(card[n / 2]);
			}

			System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}
