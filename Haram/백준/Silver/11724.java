import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int answer;
	static List<ArrayList<Integer>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		boolean[] visited = new boolean[N];
		answer = 0;
		
		for(int i = 0; i < N; i++)
			graph.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			
			graph.get(u-1).add(v-1);
			graph.get(v-1).add(u-1);
		}
		
		for(int i = 0; i < N; i++) {
			if(visited[i]) continue;
			dfs(i, visited);
			answer++;
		}
		
		System.out.println(answer);
	}
	
	private static void dfs(int i, boolean[] visited) {
		for(int n : graph.get(i)) {
			if(visited[n]) continue;
			visited[n] = true;
			dfs(n, visited);
		}
	}

}
