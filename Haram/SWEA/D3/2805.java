//import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int profit = 0;
			
			int N = Integer.parseInt(br.readLine());
			
			if(N == 1) {
				System.out.printf("#%d %d\n", t+1, Integer.parseInt(br.readLine()));
				break;
			}
			
			int[][] farm = new int[N][N];
			
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
		
			for(int i = 0; i < N/2; i++) {
				for(int j = N/2-i; j < N/2+i+1; j++) {
					profit += farm[i][j];
				}
			}
			
			for(int i = N/2; i < N; i++) {
				for(int j = i-N/2; j < N-i+N/2; j++) {
					profit += farm[i][j];
				}
			}
			
			System.out.printf("#%d %d\n", t+1, profit);
		}
	}
}