import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	// 모든 레벨에 공하나로 채워도 총 55개
	static long[][][][] dp = new long[11][60][60][60];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		// 초기화
		for (int r = 0; r <= R; r++) {
			for (int g = 0; g <= G; g++) {
				for (int b = 0; b <= B; b++) {
					dp[0][r][g][b] = 1;
				}
			}
		}

		// 이전 해당 장난감이 사용된 경우의 수
		// 레벨 2에서 2개의 장난감을 빨간색 2개로 채움
		// dp[2][2][0][0]=dp[1][2-2][0][0] # 이전 레벨 1 빨강 장난감 0개 -> 현재 2(0+2)개
		// dp[2][3][0][0]=dp[1][3-2][0][0] # 이전 레벨 1 빨강 장난감 1개 -> 현재 3(1+2)개

		for (int n = 1; n <= N; n++) {
			for (int r = 0; r <= R; r++) {
				for (int g = 0; g <= G; g++) {
					for (int b = 0; b <= B; b++) {

						// 색 한개, 해당 레벨 n에 n개 이상의 장난감이 있는지
						if (r - n >= 0) {
							dp[n][r][g][b] += dp[n - 1][r - n][g][b];
						}
						if (g - n >= 0) {
							dp[n][r][g][b] += dp[n - 1][r][g - n][b];
						}
						if (b - n >= 0) {
							dp[n][r][g][b] += dp[n - 1][r][g][b - n];
						}

						// 색 두개, 나눈 개수가 같아야한다.
						if (n % 2 == 0) {
							int div = n / 2;
							if (r - div >= 0 && g - div >= 0) {
								dp[n][r][g][b] += dp[n - 1][r - div][g - div][b] * comb(n, 2);
							}
							if (r - div >= 0 && b - div >= 0) {
								dp[n][r][g][b] += dp[n - 1][r - div][g][b - div] * comb(n, 2);
							}
							if (g - div >= 0 && b - div >= 0) {
								dp[n][r][g][b] += dp[n - 1][r][g - div][b - div] * comb(n, 2);
							}
						}

						// 색 세개
						if (n % 3 == 0) {
							int div = n / 3;
							if (r - div >= 0 && g - div >= 0 && b - div >= 0) {
								dp[n][r][g][b] += dp[n - 1][r - div][g - div][b - div] * comb(n, 3);
							}
						}
					}
				}
			}
		}

		System.out.println(dp[N][R][G][B]);
	}

	// 순열 계산
	static long comb(long n, long k) {
		long a = factor(n);
		long b = factor(n / k);
		for (int i = 0; i < k; i++) {
			a /= b;
		}
		return a;
	}

	// 팩토리얼
	static long factor(long num) {
		long temp = 1;
		for (int i = 1; i <= num; i++) {
			temp *= i;
		}
		return temp;
	}
}
