import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] order = { 9, 4, 8, 7, 2, 1, 6, 5, 0, 3 };

	static class Node implements Comparable<Node> {
		int a;
		int b;
		int o1;
		int o2;

		Node(int a) {
			this.a = a;
			this.b = -1;
			this.o1 = order[a];
			this.o2 = -1;
		}

		Node(int a, int b) {
			this.a = a;
			this.b = b;
			this.o1 = order[a];
			this.o2 = order[b];
		}

		@Override
		public int compareTo(Node o) {
			if (this.o1 == o.o1) {
				return this.o2 - o.o2;
			}
			return this.o1 - o.o1;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		Node[] node = new Node[n - m + 1];

		for (int i = m; i <= n; i++) {
			if (10 <= i) {
				node[i-m] = new Node((i / 10), (i % 10));
			} else {
				node[i-m] = new Node(i);
			}
		}

		Arrays.sort(node);

		int cnt = 0;
		for (Node no : node) {
			if (no.b == -1) {
				System.out.print(no.a + " ");
			} else {
				System.out.print((no.a * 10 + no.b) + " ");
			}
			if (++cnt == 10) {
				cnt = 0;
				System.out.println();
			}
		}
	}
}
