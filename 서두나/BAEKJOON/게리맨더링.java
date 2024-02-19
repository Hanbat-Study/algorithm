package algorithm.baekjoon.s_0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {

	static int n;
	static int[] people;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int[] order;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		graph = new ArrayList<>();

		n = Integer.parseInt(br.readLine());

		people = new int[n + 1];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i < n + 1; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 1; i < n + 1; i++) {
			st = new StringTokenizer(br.readLine());

			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}

		visited = new boolean[n + 1];
		dfs(1); // 그래프가 몇개가 있는지 확인한다.

		System.out.println(ans);
	}

	static void getCom(int depth) {

	}

	private static void dfs(int depth) {
		if (depth == n + 1) {
			getDiff();
			return;
		}

		visited[depth] = true;
		dfs(depth + 1);
		visited[depth] = false;
		dfs(depth + 1);

	}

	private static void getDiff() {
		int a = 0;
		int b = 0;
		int a_num = 0;
		int b_num = 0;
		for (int i = 1; i < n + 1; i++) {
			if (visited[i]) {
				a++;
				a_num = i;
			} else {
				// b++;
				b_num = i;
			}
		}
		int people_a = 0;
		int people_b = 0;

		System.out.println(bfs(a_num) + " " + a + " " + bfs(b_num) + " " + (n - a));
		int b_check=bfs(b_num);
		if (bfs(a_num) == a && (b_check == n - a || b_check == a)) { // 둘 다 인접해 있는 그래프
			for (int i = 1; i < n + 1; i++) {
				if (visited[i]) {
					people_a += people[i];

				} else {
					people_b += people[i];

				}
			}
			System.out.println(people_a + " " + people_b);
			ans = Math.min(ans, Math.abs(people_a - people_b));
		}

	}

	private static int bfs(int num) {

		boolean[] check = new boolean[n + 1];
		q.offer(num);
		check[num] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph.get(cur)) {
				if (!check[next]) {
					check[next] = true;
					q.offer(next);
					if (visited[next]) {
						cnt++;
					}
				}
			}

		}
		return cnt;
	}
}
