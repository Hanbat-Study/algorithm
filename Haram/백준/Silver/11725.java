import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, result[];
	static boolean visited[];
	static List<ArrayList<Integer>> tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList<>();
		result = new int[N-1];
		visited = new boolean[N+1];
		
		for(int i = 0; i < N+1; i++)
			tree.add(new ArrayList<Integer>());
		
 		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
 		
 		visited[1] = true;
 		
 		dfs(1);	
 		
 		for(int i = 0; i < N-1; i++) 
 			System.out.println(result[i]);
	}
	
	private static void dfs(int node) {
		for(int n : tree.get(node)) {
			if(visited[n]) continue;
			visited[n] = true;
			result[n-2] = node;
			dfs(n);
		}
	}

}
