import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static class Pos {
		double x, y;

		Pos(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Node implements Comparable<Node> {
		int u, v;
		double d;

		Node(int u, int v, double d) {
			this.u = u;
			this.v = v;
			this.d = d;
		}

		@Override
		public int compareTo(Node n) {
			return Double.compare(d, n.d);
		}
	}

	static int[] parent;

	static int find(int node) {
		if (parent[node] != node) {
			parent[node] = find(parent[node]);
		}
		return parent[node];
	}

	static void union(int u, int v) {
		int rootu = find(u);
		int rootv = find(v);

		if (rootu != rootv) {
			parent[rootu] = rootv;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Pos[] arr = new Pos[n];
		List<Node> nodes = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			arr[i] = new Pos(x, y);

			for (int j = 0; j < i; j++) {
				double diff = Math.sqrt(Math.pow(arr[i].x - arr[j].x, 2) + Math.pow(arr[i].y - arr[j].y, 2));
				nodes.add(new Node(i, j, diff));
			}
		}

		Collections.sort(nodes);
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		double mstD = 0;
		for (Node node : nodes) {
			if (find(node.u) != find(node.v)) {
				union(node.u, node.v);
				mstD += node.d;
			}
		}

		System.out.printf("%.2f", mstD);
	}
}
