import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] arr;
	static int n;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		recursive(0);
		System.out.println(result);
	}

	static void recursive(int depth) {

		if (depth == n) {
			int cnt = 0;
			for (int i = 0; i < n; i++) {
				if (arr[i][0] <= 0) {
					cnt++;
				}
			}
			result = Math.max(result, cnt);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (i == depth) {
				continue;
			}
			if (arr[i][0] > 0 && arr[depth][0] > 0) {
				arr[i][0] -= arr[depth][1];
				arr[depth][0] -= arr[i][1];

				recursive(depth + 1);

				arr[i][0] += arr[depth][1];
				arr[depth][0] += arr[i][1];
			} else {
				recursive(depth + 1);
			}
		}
	}
}
