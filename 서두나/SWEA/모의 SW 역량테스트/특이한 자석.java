import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[][] mag = new int[4][8];
	static int[] point = new int[4];
	static int[] check = new int[4];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int k = Integer.parseInt(br.readLine());
			StringTokenizer st;

			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					mag[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// point 초기화
			for (int i = 0; i < 4; i++) {
				point[i] = 0;
			}

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int num = Integer.parseInt(st.nextToken()) - 1;
				int d = Integer.parseInt(st.nextToken());

				move(num, d);
				// 이동하기
			}
			// 점수 구하기
			System.out.println("#" + test_case + " " + getScore());
		}
	}

	private static int getScore() {
		int ans = 0;
		for (int i = 0; i < 4; i++) {
			ans += Math.pow(2, i) * mag[i][point[i]];
		}
		return ans;
	}

	// 계속 옆에 자성이 다르면 회전
	private static void move(int num, int d) {

		getCheck(num, d);

		for (int i = 0; i < 4; i++) {
			if (check[i] != 0) {
				rotate(i, check[i]);
			}
		}
	}

	private static void getCheck(int num, int d) {

		// check 초기화
		for (int i = 0; i < 4; i++) {
			check[i] = 0;
		}
		check[num] = d;

		// 왼쪽
		int left = num;
		while (0 <= left - 1) {
			int a = (point[left] + 6) % 8;
			int b = (point[left - 1] + 2) % 8;
			if (mag[left][a] != mag[left - 1][b]) { // 자성이 다르면, 반대방향으로 1칸 회전
				check[left - 1] = check[left] * -1;
			} else {
				break;
			}
			left--;
		}

		int right = num;
		while (right + 1 < 4) {
			int a = (point[right] + 2) % 8;
			int b = (point[right + 1] + 6) % 8;

			if (mag[right][a] != mag[right + 1][b]) { // 자성이 다르면, 반대방향으로 1칸 회전
				check[right + 1] = check[right] * -1;
			} else {
				break;
			}
			right++;
		}
	}

	// 1: 시계 방향, -1: 반시계 방향
	private static void rotate(int num, int d) {
		if (d == -1) {
			point[num] = (point[num] + 1) % 8;
		} else {
			point[num] = (point[num] + 7) % 8;
		}
	}

}
