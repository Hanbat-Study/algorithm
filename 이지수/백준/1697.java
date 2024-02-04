import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		
		if(K < N) {
			System.out.println(N - K);
			return;
		}
		
		System.out.println(BFS(N, K));
	}
	
	private static int BFS(int cur, int end) {
		int cnt = 0;
		Queue<int[]> hasToVisit = new ArrayDeque<int[]>();
		boolean[] visited = new boolean[100_001];
		hasToVisit.offer(new int[] {cur, 0});
		visited[cur] = true; 
		
		while(cur != end) {
			int idx = hasToVisit.size();
			for(int i = 0; i < idx; i++) {
				cur = hasToVisit.peek()[0];
				cnt = hasToVisit.peek()[1];
				hasToVisit.poll();

				if(end == cur) break;
				
				int idx1 = cur + 1;
				int idx2 = cur - 1;
				int idx3 = cur * 2;

				if(idx1 >= 0 && idx1 <= 100000 && !visited[idx1]) {
					visited[idx1] = true;
					hasToVisit.offer(new int[] {idx1, cnt + 1});
				}	
				if(idx2 >= 0 && idx2 <= 100000 && !visited[idx2]) {
					visited[idx2] = true;
					hasToVisit.offer(new int[] {idx2, cnt + 1});
				}
				if(idx3 >= 0 && idx3 <= 100000 && !visited[idx3]) {
					visited[idx3] = true;
					hasToVisit.offer(new int[] {idx3, cnt + 1});
				}
			}
		}
		
		return cnt;
	}
}
