import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, populations[], parents[], answer = Integer.MAX_VALUE;
	static boolean[] isSelected;
	static List<int[]> graph;
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		input();
		
		for(int r = 1; r < N; r++) {			
			isSelected = new boolean[N];
			combi(0, 0, r);
		}
		
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}
		
	private static void combi(int start, int cnt, int r) {
		if(cnt == r) {
			List<Integer> group1 = new ArrayList<>();
			List<Integer> group2 = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				if(isSelected[i]) group1.add(i);
				else group2.add(i);
			}
			
			if(connect(group1) && connect(group2))
				answer = Math.min(answer, cal(group1, group2));
				
			return;
		}
		
		for(int i = start; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			combi(i+1, cnt+1, r);
			isSelected[i] = false;
		}
	}

	private static int cal(List<Integer> group1, List<Integer> group2) {
		int cnt1 = 0;
		int cnt2 = 0;
		
		for(int idx : group1) 
			cnt1 += populations[idx];

		for(int idx : group2) 
			cnt2 += populations[idx];
		
		return Math.abs(cnt1 - cnt2);
	}

	private static boolean connect(List<Integer> group) {
		make();
		
		for(int a : group) {
			for(int b : graph.get(a)) {
				if(isSelected[a] && isSelected[b]) union(a, b);
				else if(!isSelected[a] && !isSelected[b]) union(a, b);
			}
		}
		
		int root = find(group.get(0));
		for(int node : group) {
			if(root != find(node)) return false;
		}
 		
		return true;
	}

	private static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return;
		parents[bRoot] = aRoot;
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		else return parents[a] = find(parents[a]);
	}

	private static void make() {
		parents = new int[N];
		for(int i = 0; i < N; i++) 
			parents[i] = i;
	}
	
	private static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		populations = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) 
			populations[i] = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] children = new int[num];
			for(int k = 0; k < num; k++) {
				int b = Integer.parseInt(st.nextToken()) - 1;
				children[k] = b;
			}
			graph.add(children);
		}
	}
}
