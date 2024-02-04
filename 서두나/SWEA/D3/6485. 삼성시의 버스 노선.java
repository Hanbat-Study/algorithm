import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] bus = new int[5001];
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				for (int j = a; j <= b; j++) {
					bus[j] += 1;
				}
			}

			int p = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < p; i++) {
				int c = Integer.parseInt(br.readLine());
				sb.append(bus[c]);
				sb.append(" ");
			}

			System.out.println("#" + test_case + " " + sb.toString());
		}
	}
}
