import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			arr = new int[n];

			st = new StringTokenizer(br.readLine());
			int c1 = Integer.parseInt(st.nextToken());
			int c2 = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			int diff = 200_000_000;
			int cnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				int t = Integer.parseInt(st.nextToken());
				int x = getMinStree(t); // t 이상인 소들 중 가장 왼쪽

				if (x < arr.length) { // t 기준 오른쪽 유무
					int temp = arr[x] - t;
					if (diff == temp) {
						cnt += 1;
					} else if (diff > temp) {
						diff = temp;
						cnt = 1;
					}
				}
				if (x - 1 >= 0) { // t 기준 왼쪽 존재 유무
					int temp = t - arr[x - 1];
					if (diff == temp) {
						cnt += 1;
					} else if (diff > temp) {
						diff = temp;
						cnt = 1;
					}
				}
			}

			if (c1 > c2) {
				diff += c1 - c2;
			} else {
				diff += c2 - c1;
			}

			System.out.println("#" + test_case + " " + diff + " " + cnt);

		}
	}

	private static int getMinStree(int t) {

		int left = 0;
		int right = arr.length - 1;
		int result = arr.length;
		while (left <= right) {
			int mid = (left + right) / 2;

			if (arr[mid] >= t) {
				right = mid - 1;
				result = mid;
			} else {
				left = mid + 1;
			}
		}
		return result;
	}
}
