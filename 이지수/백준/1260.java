import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	static Map<Integer, ArrayList<Integer>> graph;
	static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);
        int V = Integer.parseInt(str[2]);
        
        graph = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0; i < M; i++) {
            String[] tmp = br.readLine().split(" ");
            int N1 = Integer.parseInt(tmp[0]);
            int N2 = Integer.parseInt(tmp[1]);
            
            if(graph.get(N1) == null)
            	graph.put(N1, new ArrayList<Integer>());
            graph.get(N1).add(N2);
            
            if(graph.get(N2) == null)
            	graph.put(N2, new ArrayList<Integer>());
            graph.get(N2).add(N1);
        }
        
        graph.forEach((key, value) -> Collections.sort(value));
        
        visited = new boolean[N];
        DFS(V);
        System.out.println();
        visited = new boolean[N];
        BFS(V);
    }
    
    private static void DFS(int cur) {
        List<Integer> hasToVisit = new ArrayList<Integer>();
        hasToVisit.add(cur);
        
        while(hasToVisit.size() > 0) {
        	cur = hasToVisit.get(0);
        	hasToVisit.remove(0);
        	
        	if(visited[cur - 1]) continue;
        	
        	System.out.print(cur + " ");
        	visited[cur - 1] = true;
        	
        	if(graph.get(cur) != null && graph.get(cur).size() != 0)
        		hasToVisit.addAll(0, graph.get(cur));
        }
    }
    
    private static void BFS(int cur) {
    	List<Integer> hasToVisit = new ArrayList<Integer>();
        hasToVisit.add(cur);
        
        while(hasToVisit.size() > 0) {
        	cur = hasToVisit.get(0);
        	hasToVisit.remove(0);
        	
        	if(visited[cur - 1]) continue;
        	
        	System.out.print(cur + " ");
        	visited[cur - 1] = true;
        	
        	if(graph.get(cur) != null && graph.get(cur).size() != 0)
        		hasToVisit.addAll(graph.get(cur));
        }
    }
}
