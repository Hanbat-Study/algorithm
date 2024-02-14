import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt = 0;
	static int ar, ac;
	static int result = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		ar = Integer.parseInt(st.nextToken());
		ac = Integer.parseInt(st.nextToken());

		int k = (int) (int) Math.pow(2, n);

		divide(0, 0, k);

		System.out.println(result);

	}

	static void divide(int r, int c, int num) {

		if (num == 1) {
			if (ar == r && ac == c) {
				result = cnt;

			}
			return;
		}

		int k = num / 2;

		if (r + k <= ar && c + k <= ac) {
			cnt += (k * k) * 3;
			divide(r + k, c + k, k); // 4사분면
		} else if (r + k <= ar) {
			cnt += (k * k) * 2;
			divide(r + k, c, k); // 3사분면
		} else if (c + k <= ac) {
			cnt += (k * k);
			divide(r, c + k, k); // 2사분면
		} else {
			divide(r, c, k); // 1사분면

		}
	}
}
