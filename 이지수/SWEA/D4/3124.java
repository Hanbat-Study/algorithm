import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Solution {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;
		
		Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;			
		}

		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}
	
	static int V;
	static int[] parents;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		String[] tmp;
		for(int t = 1; t <= T; t++) {
			int E;
			tmp = br.readLine().split(" ");
			V = Integer.parseInt(tmp[0]);
			E = Integer.parseInt(tmp[1]);
			Edge[] eList = new Edge[E];
			
			for(int e = 0; e < E; e++) {
				int from, to, weight;
				tmp = br.readLine().split(" ");
				from = Integer.parseInt(tmp[0]);
				to = Integer.parseInt(tmp[1]);
				weight = Integer.parseInt(tmp[2]);
				
				eList[e] = new Edge(from, to, weight);
			}
			
			Arrays.sort(eList);
			
			parents = new int[V + 1];			
			makeSet();
			
			int cnt = 0;
			long result = 0;
			for(Edge edge : eList) {
				if(!union(edge.from, edge.to)) continue;
				
				result += (long)edge.weight;
				if(++cnt == V - 1) break; 
			}
			
			System.out.println("#" + t + " " + result);
		}
		
	}
	
	private static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	private static int findSet(int a) {
		if(a == parents[a]) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	
	private static void makeSet() {
		for(int i = 1; i < V + 1; i++)
			parents[i] = i;
	}
}
