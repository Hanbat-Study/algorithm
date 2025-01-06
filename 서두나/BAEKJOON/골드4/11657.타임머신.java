import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int from, to, d;

		Node(int from, int to, int d) {
			this.from = from;
			this.to = to;
			this.d = d;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			nodes.add(new Node(from, to, d));
		}

		long[] dist = new long[n + 1];
		Arrays.fill(dist, Long.MAX_VALUE);
		dist[1] = 0;

		boolean updated = false;
		for (int i = 1; i <= n; i++) {
			updated = false;
			for (Node node : nodes) {
				if (dist[node.from] != Long.MAX_VALUE && dist[node.from] + node.d < dist[node.to]) {
					dist[node.to] = dist[node.from] + node.d;
					updated = true;
				}
			}
			// 마지막 반복에 업데이트시, 음수 사이클
			if (i == n && updated) {
				System.out.println("-1");
				return;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (dist[i] == Long.MAX_VALUE) {
				System.out.println("-1");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

}
