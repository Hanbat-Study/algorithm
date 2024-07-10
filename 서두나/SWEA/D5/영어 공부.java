import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] arr;
	static int p;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());

			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int ans = 0;
			for (int i = 0; i < n; i++) {
				int left = i;
				int right = n - 1;
				while (left <= right) {
					int mid = (left + right) / 2;

					int blank = (arr[mid] - arr[i] + 1) - (mid - i + 1);

					if (blank <= p) {
						left = mid + 1;
						ans = Math.max(ans, (arr[mid] - arr[i] + 1) + (p - blank));
					} else {
						right = mid - 1;
					}

				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
