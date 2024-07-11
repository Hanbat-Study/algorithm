import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			long left = 0;
			long right = 2_000_000_000L; // 최대 나올수 있는 단수의 개수

			long n = Long.parseLong(br.readLine());
			long ans = -1;

			while (left <= right) {
				long mid = (left + right) / 2;

				long temp = (mid * (mid + 1)) / 2;

				if (temp == n) {
					ans = mid;
					break;
				}
				if (temp < n) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
