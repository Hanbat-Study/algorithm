import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] arr;
	static int n;
	static int cnt = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[0] = i;
			recursive(1);
		}
		System.out.println(cnt);
	}

	static void recursive(int depth) {

		if (depth == n) {
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (isValid(depth, i)) {
				arr[depth] = i;
				recursive(depth + 1);
			}
		}

	}

	static boolean isValid(int depth, int i) {

		for (int j = 0; j < depth; j++) {
			if (arr[j] == i || (depth - 1 * (depth - j) == j && i - 1 * (depth - j) == arr[j])
					|| (depth - 1 * (depth - j) == j && i + 1 * (depth - j) == arr[j])) {
				return false;
			}
		}
		return true;
	}
}
