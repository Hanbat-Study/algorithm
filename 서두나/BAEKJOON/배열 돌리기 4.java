import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] drs = { 1, 0, -1, 0 }; // 남, 동, 북, 서
	static int[] dcs = { 0, 1, 0, -1 };
	static int[][] arr;
	static Queue<Integer> q;
	static int[] order = new int[6];
	static boolean[] visited = new boolean[6];
	static int n;
	static int m;
	static int k;
	static int[][] culcurate;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		culcurate = new int[k][3];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			culcurate[i][0] = Integer.parseInt(st.nextToken()) - 1;
			culcurate[i][1] = Integer.parseInt(st.nextToken()) - 1;
			culcurate[i][2] = Integer.parseInt(st.nextToken());

		}

		dfs(0);

		System.out.println(ans);
	}

	private static void dfs(int depth) {

		if (depth == k) {
			// 배열 복사
			int[][] temp = new int[n][];

			for (int i = 0; i < n; i++) {
				temp[i] = arr[i].clone();
			}

			for (int i = 0; i < k; i++) {
				int r = culcurate[order[i]][0];
				int c = culcurate[order[i]][1];
				int s = culcurate[order[i]][2];
				for (int j = 1; j < s + 1; j++) {
					rotate(r - j, c - j, 2 * j, temp);
				}
			}
			ans = Math.min(ans, getAddNum(temp));
			return;
		}

		for (int i = 0; i < k; i++) {
			if (!visited[i]) {
				visited[i] = true;
				order[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}
	}

	private static int getAddNum(int[][] temp) {
		int total = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int t = 0;
			for (int j = 0; j < m; j++) {
				t += temp[i][j];
			}
			total = Math.min(total, t);
		}
		return total;
	}

	static void rotate(int r1, int c1, int cnt, int[][] temp) {
		int r = r1;
		int c = c1;
		int t = temp[r][c];

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < cnt; j++) {
				int nr = r + drs[i];
				int nc = c + dcs[i];
				temp[r][c] = temp[nr][nc];
				r = nr;
				c = nc;
			}
		}
		temp[r][c + 1] = t;
	}

}
