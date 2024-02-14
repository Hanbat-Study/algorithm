import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = temp.charAt(j) - '0';
			}
		}
		divided(0, 0, n);

		System.out.println(sb);
	}

	static void divided(int r, int c, int num) {
		int cnt = 0;
		for (int i = r; i < r + num; i++) {
			for (int j = c; j < c + num; j++) {
				cnt += arr[i][j];
			}
		}
		if (cnt == 0) {
			sb.append(0);
			return;
		}
		if (cnt == num * num) {
			sb.append(1);
			return;
		}

		if (num == 2) {
			sb.append('(');
			for (int i = r; i < r + num; i++) {
				for (int j = c; j < c + num; j++) {
					sb.append(arr[i][j]);
				}
			}
			sb.append(')');
			return;
		}

		int k = num / 2;
		sb.append('(');
		divided(r, c, k); // 1사 분면

		divided(r, c + k, k); // 2사 분면

		divided(r + k, c, k); // 3사 분면

		divided(r + k, c + k, k); // 4사 분면
		sb.append(')');
	}
}
