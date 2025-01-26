import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[][] friend;

	static int[] drs = { 0, 0, 1, -1 };
	static int[] dcs = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		friend = new int[n * n + 1][4];

		for (int i = 0; i < n * n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < 4; j++) {
				int f = Integer.parseInt(st.nextToken());
				friend[num][j] = f;
			}

			// 탐색
			int maxLike = -1;
			int maxEmpty = -1;
			int checkR = -1;
			int checkC = -1;

			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++) {

					if (arr[r][c] == 0) {
						int likeCnt = 0;
						int emptyCnt = 0;

						// 인점한 칸 개수
						// 친구
						for (int d = 0; d < 4; d++) {
							int nr = drs[d] + r;
							int nc = dcs[d] + c;
							if (0 > nr || nr >= n || 0 > nc || nc >= n) {
								continue;
							}

							if (isLike(nr, nc, num)) {
								likeCnt++;
							} else if (arr[nr][nc] == 0) {
								emptyCnt++;
							}
						}

						if (maxLike < likeCnt || (maxLike == likeCnt && maxEmpty < emptyCnt)) {
							maxLike = likeCnt;
							maxEmpty = emptyCnt;
							checkR = r;
							checkC = c;
						}
					}

				}
			}
			arr[checkR][checkC] = num;
		}

		int ans = 0;
		for (int r = 0; r < n; r++) {
			for (int c = 0; c < n; c++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = drs[d] + r;
					int nc = dcs[d] + c;
					if (0 > nr || nr >= n || 0 > nc || nc >= n) {
						continue;
					}

					if (isLike(nr, nc, arr[r][c])) {
						cnt++;
					}
				}
				if (cnt == 2) {
					ans += 10;
				} else if (cnt == 3) {
					ans += 100;
				} else if (cnt == 4) {
					ans += 1000;
				} else {
					ans += cnt;
				}
			}
		}

		System.out.println(ans);
	}

	static boolean isLike(int r, int c, int num) {
		for (int k = 0; k < 4; k++) {
			if (arr[r][c] == friend[num][k]) {
				return true;
			}
		}

		return false;
	}
}
