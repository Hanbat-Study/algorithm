import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static class Time {
		int s;
		int e;

		public Time(int s, int e) {
			this.s = s;
			this.e = e;
		}
	}

	static Time[] arr; // 시간
	static int[] sum; // 누적합
	static int n;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			int l = Integer.parseInt(br.readLine());
			n = Integer.parseInt(br.readLine());

			arr = new Time[n];
			sum = new int[n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				arr[i] = new Time(s, e);
				if (i == 0) {
					sum[i] = e - s;
				} else {
					sum[i] = sum[i - 1] + e - s;
				}
			}

			int ans = 0;
			for (int i = 0; i < n; i++) {
				int target = arr[i].s + l;
				int next = findNext(target);

				int temp = sum[next - 1];
				if (i != 0) {
					temp -= sum[i - 1];
				}
				if (next != n && arr[next].s < target) {
					temp += target - arr[next].s;
				}
				ans = Math.max(ans, temp);
			}

			System.out.println("#" + test_case + " " + ans);
		}
	}

	static int findNext(int target) {
		int left = 0;
		int right = n - 1;

		int result = n;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid].e > target) {
				right = mid - 1;
				result = Math.min(result, mid);
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
}
