import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr;
	static int n;

	static int getCnt() {
		
		int maxN = arr[0];
		for (int i = 1; i < n; i++) {
			if ((arr[0] % 2) != (arr[i] % 2)) {
				return -1;
			}
			maxN = Math.max(maxN, arr[i]);
		}
		int cnt = 0;
		int k = 0;
		while (true) {
			if (cnt >= maxN && (cnt - maxN) % 2 == 0) {
				return k;
			}
			k++;
			cnt += k;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());

			arr = new int[n];

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[i] = Math.abs(a) + Math.abs(b);
			}

			System.out.println("#" + test_case + " " + getCnt());
		}

	}
}
