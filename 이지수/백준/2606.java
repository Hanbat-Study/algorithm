import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Main {
	
	static boolean[] visited;
	static Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int v = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		
		for(int i = 0; i < v; i++) {
			String[] str = br.readLine().split(" ");
			int n1 = Integer.parseInt(str[0]);
			int n2 = Integer.parseInt(str[1]);
			
			if(graph.get(n1) == null)
				graph.put(n1, new ArrayList<Integer>());
			
			if(graph.get(n2) == null)
				graph.put(n2, new ArrayList<Integer>());
				
			graph.get(n1).add(n2);
			graph.get(n2).add(n1);
		}
		
		System.out.println(BFS());
	}
	
	private static int BFS() {
		int cnt = 0;
		int cur;
		Queue<Integer> hasToVisit = new ArrayDeque<Integer>();
		hasToVisit.offer(1);
		visited[0] = true;
		
		while(!hasToVisit.isEmpty()) {
			cur = hasToVisit.poll();
			
			if(graph.get(cur) == null) continue;
				
			for(int i = 0; i < graph.get(cur).size(); i++) {
				int child = graph.get(cur).get(i);
				
				if(visited[child - 1]) continue;
				
				hasToVisit.offer(child);
				visited[child - 1] = true;
				cnt++;
			}
		}
		
		return cnt;
	}
}
