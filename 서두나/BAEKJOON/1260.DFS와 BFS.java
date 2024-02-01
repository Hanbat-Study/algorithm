package algorithm.baekjoon.s_0131;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] isVisited;
	static StringBuilder sb;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int n;
	static int m;
	static int v;

	static void bfs() {
		q.offer(v);
		isVisited[v] = true;

		while (!q.isEmpty()) {
			int cur = q.poll();

			sb.append(cur).append(" ");

			for (int next : graph.get(cur)) {
				if (isVisited[next]) {
					continue;
				}
				q.offer(next);
				isVisited[next] = true;
			}
		}
	}

	static void dfs(int cur) {
		isVisited[cur] = true;
		sb.append(cur).append(" ");

		for (int next : graph.get(cur)) {
			if (isVisited[next]) {
				continue;
			}
			dfs(next);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		graph = new ArrayList<ArrayList<Integer>>();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());

		isVisited = new boolean[n + 1];

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		for (int i = 0; i < n + 1; i++) {
			graph.get(i).sort(null);
		}

		sb = new StringBuilder();
		dfs(v);
		System.out.println(sb.toString());

		sb.setLength(0);
		isVisited = new boolean[n + 1];
		bfs();
		System.out.println(sb.toString());

	}
}
