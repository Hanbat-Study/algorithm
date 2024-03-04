package com.jurib.offline16;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471 {

	static int n;
	static int[] people;
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] visited;
	static Queue<Integer> q = new LinkedList<>();
	static int ans = Integer.MAX_VALUE;
	static boolean[] check;

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

		System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
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

		// 해당 조합이 적합한지
		for (int i = 1; i < n + 1; i++) {
			if (visited[i]) {
				a = i;
				break;
			}
		}

		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				b = i;
				break;
			}
		}

		int a_sum = 0;
		int b_sum = 0;
		check = new boolean[n + 1];

		if ((a != 0 && b != 0) && bfs(a, true) + bfs(b, false) == n) { // 두개의 합이 n일 때 모두 인접해 있다.

			for (int i = 1; i < n + 1; i++) {
				if (visited[i]) {
					a_sum += people[i];
				} else {
					b_sum += people[i];
				}

			}
			ans = Math.min(ans, Math.abs(a_sum - b_sum));
		}

	}

	private static int bfs(int num, boolean k) {

		q.offer(num);
		check[num] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph.get(cur)) {
				if (!check[next] && visited[next] == k) {
					check[next] = true;
					q.offer(next);
					cnt++;
				}
			}

		}
		return cnt;
	}
}
