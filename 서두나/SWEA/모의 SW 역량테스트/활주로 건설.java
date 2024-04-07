import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int n;
	static int x;
	static int[][] map;
	static int[] check = new int[2];

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			sb.append("#" + test_case + " " + getCnt() + "\n");
		}
		System.out.println(sb.toString());
	}

	static int getCnt() {
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			boolean flag = true;
			check[0] = map[i][0];
			check[1] = 0;
			for (int j = 0; j < n; j++) {
				if (check[0] > map[i][j] + 1 || check[0] < map[i][j] - 1) {
					flag = false;
					break;
				}
				if (check[0] < map[i][j]) { // 1>2
					if (check[1] < x) {
						flag = false;
						break;
					}
					check[0] = map[i][j];
					check[1] = 1;
				} else if (check[0] > map[i][j]) { // 2>1
					if (check[1] < 0) {
						flag = false;
						break;
					}
					check[0] = map[i][j];
					check[1] = -x + 1;
				} else { // 2>2
					check[1]++;
				}
			}
			if (flag && check[1] >= 0) {
				cnt++;
			}
		}

		for (int j = 0; j < n; j++) {
			boolean flag = true;
			check[0] = map[0][j];
			check[1] = 0;
			for (int i = 0; i < n; i++) {
				if (check[0] > map[i][j] + 1 || check[0] < map[i][j] - 1) {
					flag = false;
					break;
				}
				if (check[0] < map[i][j]) { // 1>2
					if (check[1] < x) {
						flag = false;
						break;
					}
					check[0] = map[i][j];
					check[1] = 1;
				} else if (check[0] > map[i][j]) { // 2>1
					if (check[1] < 0) {
						flag = false;
						break;
					}
					check[0] = map[i][j];
					check[1] = -x + 1;
				} else { // 2>2
					check[1]++;
				}
			}
			if (flag && check[1] >= 0) {
				cnt++;
			}
		}
		return cnt;
	}
}
