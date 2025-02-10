import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] arr;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		parent = new int[n];

		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					union(i, j);
				}
			}
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int check = Integer.parseInt(st.nextToken()) - 1;
		String ans = "YES";
		for (int i = 1; i < m; i++) {
			int temp = Integer.parseInt(st.nextToken()) - 1;
			if (find(check) != find(temp)) {
				ans = "NO";
				break;
			}
		}

		System.out.println(ans);
	}

	static int find(int v) {
		if (parent[v] != v) {
			parent[v] = find(parent[v]);
		}

		return parent[v];
	}

	static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);

		if (roota != rootb) {
			parent[rootb] = roota;
		}
	}
}
