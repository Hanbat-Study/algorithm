import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

	static int[] arr = new int[10001];
	static boolean[] isVisited;
	static int ans;
	static ArrayList<ArrayList<Integer>> list;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			isVisited = new boolean[V + 1];
			list = new ArrayList<>();

			for (int i = 0; i < V + 1; i++) {
				list.add(new ArrayList<>());
			}

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				arr[b] = a;
				list.get(a).add(b);
			}

			parent(A);
			findParent(B);
			sb.append("#" + test_case + " " + ans + " " + cntSubTree(ans) + "\n");
		}
		System.out.println(sb);
	}

	static void parent(int cur) {

		isVisited[cur] = true;

		if (cur == 1) {
			return;
		}

		parent(arr[cur]);
	}

	static void findParent(int cur) {

		if (isVisited[cur]) {
			ans = cur;
			return;
		}

		findParent(arr[cur]);
	}

	static int cntSubTree(int cur) {

		int cnt = 1;
		if (list.get(cur).isEmpty()) {
			return 1;
		}

		for (int next : list.get(cur)) {
			cnt += cntSubTree(next);
		}

		return cnt;
	}
}
