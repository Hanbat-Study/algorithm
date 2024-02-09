import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] result;
	static ArrayList<ArrayList<Integer>> list;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		result = new int[N + 1];
		list = new ArrayList<>();
		
		for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }
		
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		dfs(1, 0);

       StringBuilder sb = new StringBuilder();
       
       for (int i = 2; i <= N; i++) {
    	   sb.append(result[i]).append(" ");
       }
       System.out.println(sb);
    }

    private static void dfs(int node, int parent) {
    	result[node] = parent;
        for (int child : list.get(node)) {
            if (child != parent) {
                dfs(child, node);
            }
        }
    }
}
