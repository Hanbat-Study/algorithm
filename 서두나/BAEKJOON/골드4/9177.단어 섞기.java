import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static String aword;
	static String bword;
	static String cword;
	static boolean[][] dp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			aword = st.nextToken();
			bword = st.nextToken();
			cword = st.nextToken();
			dp = new boolean[aword.length() + 1][bword.length() + 1];

			dp[0][0] = true;

			for (int r = 1; r <= aword.length(); r++) {
				if (aword.charAt(r - 1) == cword.charAt(r - 1)) {
					dp[r][0] = dp[r - 1][0];
				}
			}

			for (int c = 1; c <= bword.length(); c++) {
				if (bword.charAt(c - 1) == cword.charAt(c - 1)) {
					dp[0][c] = dp[0][c - 1];
				}
			}

			for (int c = 1; c <= bword.length(); c++) {
				for (int r = 1; r <= aword.length(); r++) {

					if (dp[r - 1][c] && cword.charAt(r + c - 1) == aword.charAt(r - 1)) {
						dp[r][c] = true;
					} else if (dp[r][c - 1] && cword.charAt(r + c - 1) == bword.charAt(c - 1)) {
						dp[r][c] = true;
					}

				}
			}

			if (dp[aword.length()][bword.length()]) {
				sb.append("Data set " + (i + 1) + ": yes\n");
			} else {
				sb.append("Data set " + (i + 1) + ": no\n");
			}
		}
		System.out.println(sb.toString());

	}
}
