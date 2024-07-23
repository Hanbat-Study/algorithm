import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();

			int[][] arr = new int[a.length() + 1][b.length() + 1];

			for (int i = 1; i < a.length() + 1; i++) {
				for (int j = 1; j < b.length() + 1; j++) {
					if (a.charAt(i - 1) == b.charAt(j - 1)) {
						arr[i][j] = arr[i - 1][j - 1] + 1;
					} else {
						arr[i][j] = Math.max(arr[i-1][j], arr[i][j - 1]);
					}
				}
			}

			int ans = arr[a.length()][b.length()];
			System.out.println("#" + test_case + " " + ans);
		}
	}
}
