import java.io.*;

class Solution {
	static int n;
	static char[][] arr;

	public static char[][] rotate() {
		char[][] temp = new char[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = arr[n - j - 1][i];
			}
		}
		return temp;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());
			arr = new char[n][n];

			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					arr[i][j] = temp[j].charAt(0);
				}
			}
			String[][] result = new String[n][3];

			for (int k = 0; k < 3; k++) {
				arr = rotate();
				for (int i = 0; i < n; i++) {
					String temp = "";
					for (int j = 0; j < n; j++) {
						temp += arr[i][j];
					}
					result[i][k] = temp;
				}
			}
			System.out.println("#" + test_case);
			for (int i = 0; i < n; i++) {
				System.out.println(result[i][0] + " " + result[i][1] + " " + result[i][2]);
			}

		}
	}
}
