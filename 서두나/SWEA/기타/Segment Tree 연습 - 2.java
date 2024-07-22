import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int[] a;
	static long[] tree;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());

			a = new int[n];
			tree = new long[n * 4];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(st.nextToken());
				if (i % 2 == 1) {
					a[i] = -a[i];
				}
			}

			init(1, 0, n - 1);

			for (int i = 0; i < q; i++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());

				if (p == 0) {
					int k = Integer.parseInt(st.nextToken());
					long x = Integer.parseInt(st.nextToken());
					if (k % 2 == 1) { // 해당 위치가 홀수면 - 값으로 변환해 저장
						x = -x;
					}
					update(1, 0, n - 1, k, x);
				} else {
					int l = Integer.parseInt(st.nextToken());
					int r = Integer.parseInt(st.nextToken());
					long sum = find(1, 0, n - 1, l, r - 1);

					if (l % 2 == 1) { // 시작 위치가 홀수면 -으로 (+ - +) => (- + -)로 변경
						sum = -sum;
					}
					sb.append(sum + " ");
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static private void init(int node, int left, int right) {
		if (left == right) {
			tree[node] = a[left];
			return;
		}

		int mid = (left + right) / 2;

		init(node * 2, left, mid);
		init(node * 2 + 1, mid + 1, right);

		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}

	static private void update(int node, int left, int right, int index, long value) {
		if (index < left || index > right) {
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

	static private long find(int node, int left, int right, int leftIndex, int rightIndex) {
		if (leftIndex > right || rightIndex < left) {
			return 0;
		}
		if (leftIndex <= left && right <= rightIndex) {
			return tree[node];
		}

		int mid = (left + right) / 2;

		long leftNode = find(node * 2, left, mid, leftIndex, rightIndex);
		long rightNode = find(node * 2 + 1, mid + 1, right, leftIndex, rightIndex);

		return leftNode + rightNode;
	}
}
