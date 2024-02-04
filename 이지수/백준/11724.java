import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Main {

	static Map<Integer, List<Integer>> graphs = new HashMap<Integer, List<Integer>>();
	static boolean[] visited;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		
		visited = new boolean[N];

		for(int i = 0; i < M; i++) {
			String[] tmp2 = br.readLine().split(" ");
			int N1 = Integer.parseInt(tmp2[0]);
			int N2 = Integer.parseInt(tmp2[1]);
			
			if(graphs.get(N1) == null)
				graphs.put(N1, new ArrayList<Integer>());
			if(graphs.get(N2) == null)
				graphs.put(N2, new ArrayList<Integer>());
			
			graphs.get(N1).add(N2);
			graphs.get(N2).add(N1);
		}
		
		int currentN = 0;
		int result = 0;
		while(N > 0) {
			currentN++;
			if(visited[currentN - 1]) continue;
			
			N -= DFS(currentN);
			result++;
		}
		
		System.out.println(result);
	}
	
	private static int DFS(int cur) {
		int cnt = 0;
		Stack<Integer> hasToVisit = new Stack<Integer>();
		hasToVisit.push(cur);
		
		while(!hasToVisit.isEmpty()) {
			cur = hasToVisit.pop();
			
			if(visited[cur - 1]) continue;
			
			visited[cur - 1] = true;
			cnt++;
			
			if(graphs.get(cur) == null) continue;
			for(int i = 0; i < graphs.get(cur).size(); i++) {
				if(visited[graphs.get(cur).get(i) - 1]) continue;
				
				hasToVisit.push(graphs.get(cur).get(i));
			}
		}
		
		return cnt;
	}
}
