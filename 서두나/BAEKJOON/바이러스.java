package algorithm.baekjoon.s_0201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		boolean isVisited[] = new boolean[n + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int cnt=0;
		q.offer(1);
		isVisited[1]=true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			cnt++;
			
			for(int next: graph.get(cur)) {
				if(isVisited[next]) {
					continue;
				}
				isVisited[next]=true;
				q.offer(next);
			}
		}
		System.out.println(cnt-1);
	}

}
