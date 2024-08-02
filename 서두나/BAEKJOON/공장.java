import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] tree;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		int[] b = new int[1_000_001];
		tree = new int[n * 4];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}

		long cnt = 0;

		st = new StringTokenizer(br.readLine());

		// 각 위치를 구해서, 각 구간(현재보다 순서가 큰 수)에서 나온 개수를 구한ㄴ다.
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			b[temp] = i;
		}

		for (int i = 0; i < n; i++) {
			cnt += find(1, 0, n - 1, b[a[i]] + 1, n - 1); // a값의 두번째 열 순서+1~n-1 구간에서 개수 찾기
			update(1, 0, n - 1, b[a[i]]); // a값의 두번째 열 순서
		}
		System.out.println(cnt);

	}

	private static long find(int node, int left, int right, int leftIndex, int rightIndex) {

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

	private static void update(int node, int left, int right, int index) {
		if (left > index || index > right) {
			return;
		}
		if (left == right) {
			tree[node] = 1;
			return;
		}

		int mid = (left + right) / 2;

		update(node * 2, left, mid, index);
		update(node * 2 + 1, mid + 1, right, index);
		tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
}
