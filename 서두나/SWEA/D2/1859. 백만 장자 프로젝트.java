import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			long total = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int maxNum=arr[n-1];
			for (int i = n-2; i >=0; i--) {
				total+=Math.max(0, maxNum-arr[i]);
				if (maxNum<arr[i]) {
					maxNum=arr[i];
				}
				
			}
			System.out.println("#" + test_case + " " + total);
		}
	}
}
