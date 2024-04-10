import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] op = new int[4];
	static int n;
	static int minNum;
	static int maxNum;
	static int[] arr;
	static int[] check;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			n = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				op[i] = Integer.parseInt(st.nextToken());
			}

			arr = new int[n];
			check = new int[n - 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			minNum = 100_000_000;
			maxNum = -100_000_000;

			recur(0);

			System.out.println("#" + test_case + " " + (maxNum - minNum));
		}
	}

	static void recur(int depth) {
		if (depth == n - 1) {
			int num = getCalcu();
			minNum = Math.min(minNum, num);
			maxNum = Math.max(maxNum, num);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (op[i] > 0) {
				op[i]--;
				check[depth] = i;
				recur(depth + 1);
				op[i]++;
			}
		}
	}

	static int getCalcu() {
		int total = arr[0];
		for (int i = 1; i < n; i++) {
			switch (check[i - 1]) {
			case 0: // +
				total += arr[i];
				break;
			case 1:
				total -= arr[i];
				break;
			case 2:
				total *= arr[i];
				break;
			case 3:
				total /= arr[i];
				break;
			}
		}
		return total;
	}
}
