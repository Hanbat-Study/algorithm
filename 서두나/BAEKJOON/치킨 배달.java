import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Node> home;
	static List<Node> chicken;
	static boolean[] check;
	static int result = Integer.MAX_VALUE;
	static int M;

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		home = new ArrayList<>();
		chicken = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				char num = st.nextToken().charAt(0);
				if (num == '1') {
					home.add(new Node(i, j));
				} else if (num == '2') {
					chicken.add(new Node(i, j));
				}
			}
		}
		check = new boolean[chicken.size()];

		dfs(0, 0);
		System.out.println(result);

	}

	static void dfs(int depth, int k) {
		if (depth == chicken.size()) {
			if (k == M) {
				result = Math.min(result, getDistance());
			}
			return;
		}

		if (k < M) {
			check[depth] = true;
			dfs(depth + 1, k + 1);
			check[depth] = false;
		}
		dfs(depth + 1, k);
	}

	private static int getDistance() {
		int total = 0;
		for (int i = 0; i < home.size(); i++) {
			int cnt = Integer.MAX_VALUE;
			for (int j = 0; j < chicken.size(); j++) {
				if (check[j]) {

					cnt = Math.min(cnt,
							Math.abs(home.get(i).r - chicken.get(j).r) + Math.abs(home.get(i).c - chicken.get(j).c));
				}
			}
			total += cnt;
		}
		return total;
	}
}
