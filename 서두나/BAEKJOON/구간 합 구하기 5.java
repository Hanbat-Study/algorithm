import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[][] map = new int[n+1][n+1];
		for (int i = 1; i < n+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < n+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] add = new int[n+1][n+1];

		add[1][1] = map[1][1];
		for (int i = 2; i < n+1; i++) {
			add[i][1] = add[i - 1][1] + map[i][1];
			add[1][i] = add[1][i - 1] + map[1][i];
		}

		for (int i = 2; i < n+1; i++) {
			for (int j = 2; j < n+1; j++) {
				add[i][j] = add[i - 1][j] + add[i][j - 1] + map[i][j] - add[i - 1][j - 1];
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			System.out.println(add[x2][y2] - add[x1 - 1][y2] - add[x2][y1 - 1] + add[x1 - 1][y1 - 1]);
		}
	}
}
