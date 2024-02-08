import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

	static char[][] area1;
	static char[][] area2;
	static int N;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		area1 = new char[N][N];
		area2 = new char[N][N];
		
		for(int i = 0; i < N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 0; j < N; j++)
				area1[i][j] = tmp[j].charAt(0);
			area2[i] = Arrays.copyOf(area1[i], N);
		}
		
		int r = 0;
		int c = 0;
		
		int result1 = 0;
		
		while(r < N && c < N) {
			if(area1[r][c] != '\0') {
				BFSN(new int[] {r, c});
				result1++;
			}
			
			if(c >= N - 1) {
				r++;
				c = 0;
			}
			else
				c++;
		}
		
		r = 0;
		c = 0;
		
		int result2 = 0;
		
		while(r < N && c < N) {
			if(area2[r][c] != '\0') {
				BFSA(new int[] {r, c});
				result2++;
			}
			
			if(c >= N - 1) {
				r++;
				c = 0;
			}
			else
				c++;
		}

		System.out.println(result1 + " " + result2);
	}
	
	private static void BFSN(int[] cur) {
		Queue<int[]> hasToVisit = new ArrayDeque<>();
		hasToVisit.offer(cur);
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		char color = area1[cur[0]][cur[1]];

		while(!hasToVisit.isEmpty()) {
			
			int size = hasToVisit.size();
			for(int i = 0; i < size; i++) {
				
				cur = hasToVisit.poll();
				for(int j = 0; j < 4; j++) {
					int idx1 = cur[0] + dx[j];
					int idx2 = cur[1] + dy[j];
					
					if(idx1 < 0 || idx1 >= N || idx2 < 0 || idx2 >= N || area1[idx1][idx2] != color) continue;
					
					area1[idx1][idx2] = '\0';
					hasToVisit.offer(new int[] {idx1, idx2});
				}
			}
			
		}
	}
	
	private static void BFSA(int[] cur) {
		Queue<int[]> hasToVisit = new ArrayDeque<>();
		hasToVisit.offer(cur);
		
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, 1, 0, -1};
		
		char color = area2[cur[0]][cur[1]];

		while(!hasToVisit.isEmpty()) {
			int size = hasToVisit.size();
			for(int i = 0; i < size; i++) {
				
				cur = hasToVisit.poll();
				for(int j = 0; j < 4; j++) {
					int idx1 = cur[0] + dx[j];
					int idx2 = cur[1] + dy[j];
					if(idx1 < 0 || idx1 >= N || idx2 < 0 || idx2 >= N || area2[idx1][idx2] == '\0') continue;
					
					if((color == 'B' && area2[idx1][idx2] != color) || (area2[idx1][idx2] == 'B' && color != 'B')) continue;

					area2[idx1][idx2] = '\0';
					hasToVisit.offer(new int[] {idx1, idx2});
				}
			}
			
		}
	}
}
