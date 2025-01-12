import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	static int[][] check;
	static int[] cnt;
	static int num;
	static int n, m;
	static Queue<int[]> q = new LinkedList<>();

	static int[] drs = { 0, 0, 1, -1 }; // 동,서,남,북
	static int[] dcs = { 1, -1, 0, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		check = new int[n][m];
		cnt = new int[n * m * 10];
		num = 1;

		for (int i = 0; i < n; i++) {
			String temp = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0 && check[i][j] == 0) {
					run(i, j);
				}
			}
		}

		Set<Integer> temp = new HashSet<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						int nr = drs[k] + i;
						int nc = dcs[k] + j;

						if (0 > nr || nr >= n || 0 > nc || nc >= m || check[nr][nc] == 0) {
							continue;
						}
						temp.add(check[nr][nc]);
					}

					for (int t : temp) {
						map[i][j] = (map[i][j] + cnt[t]) % 10;
					}
					temp.clear();
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb.toString());
	}

	static void run(int r, int c) {
		q.offer(new int[] { r, c });
		check[r][c] = ++num;
		cnt[num]++;

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = drs[i] + cur[0];
				int nc = dcs[i] + cur[1];

				if (0 > nr || nr >= n || 0 > nc || nc >= m || map[nr][nc] == 1 || check[nr][nc] != 0) {
					continue;
				}

				check[nr][nc] = num;
				cnt[num]++;
				q.offer(new int[] { nr, nc });
			}

		}
	}

}
