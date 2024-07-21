import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		arr = new long[n];
		tree = new long[n * 4];

		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}

		init(1, 0, n - 1);

		for (int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 1) { // 수의 변경
				long c = Long.parseLong(st.nextToken());
				update(1, 0, n - 1, b - 1, c);

			} else { // 구간 합
				int c = Integer.parseInt(st.nextToken());
				System.out.println(find(1, 0, n - 1, b - 1, c - 1));
			}
		}
	}

	static private void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = arr[left];
			return;
		}

		int mid = (left + right) / 2;
		init(node * 2, left, mid);
		init(node * 2 + 1, mid + 1, right);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static private void update(int node, int left, int right, int index, long value) {
		if (left > index || index > right) {
			return;
		}

		if (left == right) {
			tree[node] = value;
			return;
		}

		int mid = (left + right) / 2;
		update(node * 2, left, mid, index, value);
		update(node * 2 + 1, mid + 1, right, index, value);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static private long find(int node, int left, int right, int indexLeft, int indexRight) {
		if (left > indexRight || indexLeft > right) {
			return 0;
		}

		if (indexLeft <= left && right <= indexRight) {
			return tree[node];
		}

		int mid = (left + right) / 2;
		return find(node * 2, left, mid, indexLeft, indexRight)
				+ find(node * 2 + 1, mid + 1, right, indexLeft, indexRight);

	}
}
