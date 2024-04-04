import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] map;
	static int[] check;
	static int d;
	static int w;
	static int k;
	static int ans;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			map = new int[d][w];
			check = new int[d];

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = Integer.MAX_VALUE;
			// 약품 투입하는 조합 생성
			comb(0, 0);

			System.out.println("#" + test_case + " " + ans);

		}
	}

	static boolean flag;

	// 선택 x: -1, a: 0 , b: 1
	static void comb(int depth, int cnt) {
		if (depth == d) {
			// 확인하는 작업 필요
			if (isValid()) {
				ans = Math.min(ans, cnt);
			}
			return;
		}

		// 선택 x
		check[depth] = -1;
		comb(depth + 1, cnt);
		// a
		check[depth] = 0;
		comb(depth + 1, cnt + 1);
		// b
		check[depth] = 1;
		comb(depth + 1, cnt + 1);
	}

	// 확인

	static boolean isValid() {
		for (int j = 0; j < w; j++) {
			int cnt = 0;
			int state = -1;
			for (int i = 0; i < d; i++) {
				if (check[i] != -1) {
					if (state == check[i]) {
						cnt++;
					} else if (state != check[i]) {
						cnt = 1;
						state = check[i];
					}
				} else {
					if (state == map[i][j]) {
						cnt++;
					} else if (state != map[i][j]) {
						cnt = 1;
						state = map[i][j];
					}
				}
				if (cnt == k) {
					break;
				}
			}
			if (cnt != k) {
				return false;
			}
		}
		return true;
	}
}
