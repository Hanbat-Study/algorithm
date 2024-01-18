import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static final int NORTH_NUM = 1;
	private static final int SOUTH_NUM = 2;
	private static int answer = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 0; t < 10; t++) {
			answer = 0;
			
			int N = Integer.parseInt(br.readLine());
			int[][] table = new int[N][N];
			
			
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					table[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(table[i][j] == NORTH_NUM) 
						search(table, i, j, N);
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(table[i][j] == -1)
						answer++;
				}
			}
			
			System.out.printf("#%d %d\n", t+1, answer);
		}
	}

	private static void search(int[][] table, int i, int j, int N) {
		for(int idx = i+1; idx < N; idx++) {
			if(table[idx][j] == SOUTH_NUM) {
				answer++;
				break;
			}
			else if(table[idx][j] == NORTH_NUM) 
				break;
		}
		table[i][j] = 0;
	}
}
