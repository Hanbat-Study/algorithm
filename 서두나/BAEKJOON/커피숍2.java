import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;

	static long[] tree;
	static long[] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int q = Integer.parseInt(st.nextToken());

		tree = new long[4 * n];
		arr = new long[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}

		init(1, 0, n - 1);

		for (int i = 0; i < q; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long b = Long.parseLong(st.nextToken());

			if (x > y) {
				int temp = x;
				x = y;
				y = temp;
			}

			System.out.println(find(1, 0, n - 1, x - 1, y - 1));
			update(1, 0, n - 1, a - 1, b);
		}
	}

	private static void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = arr[left];
			return;
		}

		int mid = (left + right) / 2;

		init(node * 2, left, mid);
		init(node * 2 + 1, mid + 1, right);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	private static void update(int node, int left, int right, int index, long value) {
		if (index < left || right < index) {
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

	private static long find(int node, int left, int right, int queryLeft, int queryRight) {
		if (queryRight < left || right < queryLeft) {
			return 0;
		}

		if (queryLeft <= left && right <= queryRight) {
			return tree[node];
		}

		int mid = (left + right) / 2;

		long leftSum = find(node * 2, left, mid, queryLeft, queryRight);
		long rightSum = find(node * 2 + 1, mid + 1, right, queryLeft, queryRight);

		return leftSum + rightSum;
	}
}
