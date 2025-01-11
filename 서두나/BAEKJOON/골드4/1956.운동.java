import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int[][] distance = new int[v + 1][v + 1];
		for (int i = 1; i <= v; i++) {
			Arrays.fill(distance[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int from = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			distance[to][from] = d;
		}

		// 경유지
		for (int k = 1; k <= v; k++) {
			// 출발지
			for (int i = 1; i <= v; i++) {
				// 도착지
				for (int j = 1; j <= v; j++) {
					if (distance[i][k] < Integer.MAX_VALUE && distance[k][j] < Integer.MAX_VALUE) {
						distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
					}
				}
			}
		}

		int ans = Integer.MAX_VALUE;

		for (int i = 1; i <= v; i++) {
			if (distance[i][i] < Integer.MAX_VALUE) {
				ans = Math.min(ans, distance[i][i]);
			}
		}
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}
	}
}
