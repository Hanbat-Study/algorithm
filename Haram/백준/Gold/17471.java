import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, p[], answer = Integer.MAX_VALUE;
    static boolean visited[], isSelected[];
    
    static List<List<Integer>> graph;
    static List<Integer> a;
    static List<Integer> b;
    static BufferedReader br;
    public static void main(String[] args) throws Exception {
        input();
        
        for(int i = 1; i < N; i++) {    
        	isSelected = new boolean[N];
        	combinations(i, 0, 0);
        }
        
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    
    private static void combinations(int M, int cnt, int start) {
    	if(cnt == M) {
    		a = new ArrayList<>();
    		b = new ArrayList<>();
    		for(int i = 0; i < N; i++) {
    			if(isSelected[i]) a.add(i);
    			else b.add(i);
    		}
    		
    		if(check(a) && check(b)) {
    			int diff = Math.abs(count(a) - count(b));
    			answer = Math.min(answer, diff);
    		}
    		return;
    	}
    	
        for(int i = start; i < N; i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            combinations(M, cnt+1, i+1);
            isSelected[i] = false;            
        }
    }
    
    private static int count(List<Integer> list) {
    	int sum = 0;
		for(int idx : list) {
			sum += p[idx];
		}
		return sum;
	}

	private static boolean check(List<Integer> list) {
		
		boolean[] visited = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		int root = list.get(0);
		q.offer(root);
		int count = 1;
		visited[root] = true;
		
		while(!q.isEmpty()) {
			int v = q.poll();
			
			for(int n : graph.get(v)) {
				if(visited[n] || !list.contains(n)) continue;
				visited[n] = true;
				count++;
				q.offer(n);
			}
		}
		
		return count == list.size();
	}

    private static void input() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        
        p = new int[N];
        graph = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++) {
        	p[i] = Integer.parseInt(st.nextToken());
        	graph.add(new ArrayList<>());        	
        }
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++) {
            	graph.get(i).add(Integer.parseInt(st.nextToken())-1);
            }
        }
        
    }
}