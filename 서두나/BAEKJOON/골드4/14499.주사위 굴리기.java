import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] drs = { 0, 0, 0, -1, 1 }; // 동, 서, 북, 남
	static int[] dcs = { 0, 1, -1, 0, 0 };
	static int[] dice = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int v = Integer.parseInt(st.nextToken());

			// 이동
			int nr = x + drs[v];
			int nc = y + dcs[v];
			if (0 > nr || nr >= n || 0 > nc || nc >= m) {
				continue;
			}

			rollDice(v);

			if (arr[nr][nc] == 0) {
				arr[nr][nc] = dice[6];

			} else {
				dice[6] = arr[nr][nc];
				arr[nr][nc] = 0;
			}
			sb.append(dice[1] + "\n");
			x = nr;
			y = nc;
		}

		System.out.println(sb.toString());
	}

	static void rollDice(int dir) {
		int[] temp = dice.clone();

		if (dir == 1) { // 동쪽
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
		} else if (dir == 2) { // 서쪽
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
		} else if (dir == 3) { // 북쪽
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
		} else if (dir == 4) { // 남쪽
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
		}
	}

}
