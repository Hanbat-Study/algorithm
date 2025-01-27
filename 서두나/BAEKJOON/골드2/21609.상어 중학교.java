import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[][] arr;
	static int[][] visited;

	static int[] drs = { 0, 0, 1, -1 };
	static int[] dcs = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		visited = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int score = 0;
		while (true) {
			maxCnt = -1;
			maxRainbow = -1;
			groupR = -1;
			groupC = -1;

			// visited 초기화
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					visited[i][j] = 0;
				}
			}

			// 그룹
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] > 0 && visited[i][j] == 0) {
						findGroup(i, j, arr[i][j]);
					}
				}
			}

			if (maxCnt == -1) {
				break;
			}

			score += Math.pow(maxCnt, 2);
			// 선택된 그룹 삭제
			remove(groupR, groupC, arr[groupR][groupC]);
			
			// 중력
			gravity();

			// 90도 반시계방향
			rotate();

			// 중력
			gravity();
		}

		System.out.println(score);
	}

	static void print() {
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println();
	}

	static void rotate() {
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				int temp = arr[i][j];

				// 오른 -> 위
				arr[i][j] = arr[j][n - 1 - i];

				// 아래 -> 오른
				arr[j][n - 1 - i] = arr[n - 1 - i][n - 1 - j];

				// 왼 -> 아래
				arr[n - 1 - i][n - 1 - j] = arr[n - 1 - j][i];

				// 위 -> 왼
				arr[n - 1 - j][i] = temp;
			}
		}
	}

	static void gravity() {

		for (int j = 0; j < n; j++) {
			int down = 0;

			for (int i = n - 1; i >= 0; i--) {
				if (arr[i][j] == -2) {
					down = i;
					break;
				}
			}

			for (int i = down - 1; i >= 0; i--) {
				if (arr[i][j] == -2) {
					continue;
				}
				if (arr[i][j] == -1) {
					down = i - 1;
					continue;
				}
				if (down != i) {
					arr[down][j] = arr[i][j];
					arr[i][j] = -2;
				}
				down--;
			}
		}

	}

	static void remove(int r, int c, int color) {
		arr[r][c] = -2;

		for (int i = 0; i < 4; i++) {
			int nr = r + drs[i];
			int nc = c + dcs[i];

			if (0 > nr || nr >= n || 0 > nc || nc >= n) {
				continue;
			}

			if (arr[nr][nc] == color || arr[nr][nc] == 0) {
				remove(nr, nc, color);
			}
		}
	}

	static int cnt;
	static int rainbow;
	static int maxCnt;
	static int maxRainbow;
	static int groupR;
	static int groupC;

	static void findGroup(int r, int c, int color) {
		cnt = 1;
		rainbow = 0;

		visited[r][c] = color;
		dfs(r, c, color);

		if (cnt < 2) {
			return;
		}

		if (maxCnt < cnt || (maxCnt == cnt && maxRainbow <= rainbow)) {
			maxCnt = cnt;
			maxRainbow = rainbow;
			groupR = r;
			groupC = c;
		}

		return;
	}

	static void dfs(int r, int c, int color) {

		for (int i = 0; i < 4; i++) {
			int nr = r + drs[i];
			int nc = c + dcs[i];

			if (0 > nr || nr >= n || 0 > nc || nc >= n || visited[nr][nc] == color) {
				continue;
			}

			if (arr[nr][nc] == color || arr[nr][nc] == 0) {
				cnt++;

				if (arr[nr][nc] == 0) {
					rainbow++;
				}
				visited[nr][nc] = color;
				dfs(nr, nc, color);
			}
		}
	}
}
