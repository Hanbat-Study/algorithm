package algorithm.baekjoon.s_0201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static Queue<Integer> q = new LinkedList<>();
	static boolean[] isVisited;
	static ArrayList<ArrayList<Integer>> graph;
	static int n;

	public static void bfs(int pos) {
		q.offer(pos);
		isVisited[pos]=true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph.get(cur)) {
				if (isVisited[next]) {
					continue;
				}
				isVisited[next] = true;
				q.offer(next);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		isVisited = new boolean[n + 1];

		graph = new ArrayList<>();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		int cnt=0;
		for(int i =1; i<n+1;i++) {
			if(isVisited[i]) {
				continue;
			}
			bfs(i);
			cnt++;
		}
		
		System.out.println(cnt);

	}
}
