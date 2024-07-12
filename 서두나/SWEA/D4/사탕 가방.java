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
			long m = Long.parseLong(st.nextToken());

			long[] arr = new long[n];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}

			long left = 1;
			long right = 1000_000_000_000_000_000L;
			long ans = 0;

			while (left <= right) {
				long mid = (left + right) / 2;
				long sum = 0;

				for (int i = 0; i < n; i++) {
					sum += (arr[i] / mid);
				}

				if (m > sum) {
					right = mid - 1;
				} else {
					ans = Math.max(ans, mid);
					left = mid + 1;
				}
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}
}
