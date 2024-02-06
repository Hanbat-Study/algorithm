import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

	static Map<Integer, ArrayList<Integer>> tree;
	static boolean[] visited;
	static int N;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N];
		
		tree = new HashMap<Integer, ArrayList<Integer>>();
		for(int i = 0; i < N - 1; i++) {
			String[] tmp = br.readLine().split(" ");
			int n1 = Integer.parseInt(tmp[0]);
			int n2 = Integer.parseInt(tmp[1]);
			
			if(tree.get(n1) == null)
				tree.put(n1, new ArrayList<Integer>());
			if(tree.get(n2) == null)
				tree.put(n2, new ArrayList<Integer>());
			
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}
		
		System.out.println(DFS());
	}
	
	private static String DFS() {
		String[] result = new String[N - 1];
		Stack<Integer> hasToVisit = new Stack<Integer>();
		hasToVisit.push(1);
		
		while(!hasToVisit.isEmpty()) {
			int node = hasToVisit.pop();
			
			if(tree.get(node) == null || visited[node - 1]) continue;
			
			visited[node - 1] = true;
			
			for(int child : tree.get(node)) {
				if(visited[child - 1]) continue;
				
				hasToVisit.push(child);
				result[child - 2] = "" + node;
			}
		}
		
		return String.join("\n", result);
	}
}
