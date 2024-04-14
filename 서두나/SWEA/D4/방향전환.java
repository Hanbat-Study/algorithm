import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			int x = Math.abs(a - c);
			int y = Math.abs(b - d);

			if (x < y) {
				int temp = x;
				x = y;
				y = temp;
			}

			int ans = (x / 2) * 4 + (x % 2);

			if (y % 2 == 1) {
				if (x % 2 == 1) {
					ans++;
				} else {
					ans--;
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
