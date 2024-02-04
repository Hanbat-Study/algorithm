import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1260_Main {
	static boolean[] DFS_VISITED, BFS_VISITED;
	static int N, M, V;
	static List<ArrayList<Integer>> graph;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			graph.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			graph.get(a-1).add(b-1);
			graph.get(b-1).add(a-1);
		}
		
		for(int i = 0; i < N; i++) {
			Collections.sort(graph.get(i));
		}
		
		DFS_VISITED = new boolean[N];
//		dfs();
		recurDfs(V-1);
		System.out.println();
		
		BFS_VISITED = new boolean[N];
		bfs();
	}

	private static void recurDfs(int node) {
		System.out.print(node+1 + " ");
		DFS_VISITED[node] = true;
		
		for(int n : graph.get(node)) {
			if(DFS_VISITED[n]) continue;
			recurDfs(n);
		}
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(V-1);
		BFS_VISITED[V-1] = true;
		
		while(!q.isEmpty()) {
			int node = q.poll();
			System.out.print(node+1 + " ");
			
			for(int n : graph.get(node)) {
				if(BFS_VISITED[n]) continue;
				BFS_VISITED[n] = true;
				q.add(n);
			}
		}
	}

	private static void dfs() {
		Stack<Integer> s = new Stack<>();
		s.add(V-1);
		DFS_VISITED[V-1] = true;
		
		while(!s.isEmpty()) {
			int node = s.pop();
			System.out.print(node+1 + " ");
			
			for(int n : graph.get(node)) {
				if(DFS_VISITED[n]) continue;
				DFS_VISITED[n] = true;
				s.add(n);
			}
		}
	}
}
