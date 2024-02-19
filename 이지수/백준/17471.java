import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	static int N, total;
	static int result = Integer.MAX_VALUE;
	static int[] population;
	static boolean[] selected;
	static boolean[][] graph;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		population = new int[N];
		graph = new boolean[N][N];
		
		String[] tmp = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(tmp[i]);
			total += population[i];
		}
		
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for(int j = 1; j <= Integer.parseInt(tmp[0]); j++) {
				int c = Integer.parseInt(tmp[j]) - 1;
				graph[i][c] = true;
				graph[c][i] = true;
			}
		}
		
		for(int i = 1; i <= N / 2; i++) {
			selected = new boolean[N];
			comb(i, 0, 0);
		}
		
		if(result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}
	
	private static void comb(int maxN, int cnt, int idx) {
		if(cnt == maxN) {
			int sum = 0;
			
			if(bfs()) {
				for(int i = 0; i < N; i++) {
					if(selected[i])
						sum += population[i];
				}
				
				result = Math.min(result, Math.abs(sum - (total - sum)));
			}
			return;
		}
		
		for(int i = idx; i < N; i++) {
			if(selected[i]) continue;
			
			selected[i] = true;
			comb(maxN, cnt + 1, i + 1);
			selected[i] = false;
		}
	}
	
	private static boolean bfs() {
		Queue<Integer> q1 = new ArrayDeque<Integer>();
		Queue<Integer> q2 = new ArrayDeque<Integer>();
		boolean p = selected[0];

		q1.offer(0);
		for(int i = 1; i < N; i++) {
			if(selected[i] != p) {
				q2.offer(i);
				break;
			}
		}
		
		int cnt1 = 1;
		boolean[] visited = new boolean[N];
		visited[0] = true;
		while(!q1.isEmpty()) {
			int cur = q1.poll();

			for(int i = 0; i < N; i++) {
				if(graph[cur][i] && !visited[i] && selected[i] == p) {
					q1.offer(i);
					visited[i] = true;
					cnt1++;
				}
			}
		}

		int cnt2 = 1;
		visited = new boolean[N];
		visited[q2.peek()] = true;
		while(!q2.isEmpty()) {
			int cur = q2.poll();
			
			for(int i = 0; i < N; i++) {
				if(graph[cur][i] && !visited[i] && selected[i] != p) {
					q2.offer(i);
					visited[i] = true;
					cnt2++;
				}
			}
		}
		
		if(cnt1 + cnt2 == N)
			return true;
		
		return false;
	}
}
