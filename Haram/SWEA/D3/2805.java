import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t < T+1; t++) {
			int profit = 0;
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String str = br.readLine();
				for(int j = 0; j < N; j++) {
					farm[i][j] = str.charAt(j) - '0';
				}
			}
			
			int cnt = N/2;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(Math.abs(cnt) > j || Math.abs(cnt) >= N-j) continue;
					profit += farm[i][j];
				}
				cnt--;
			}
			
			System.out.println("#" + t + " " + profit);
		}
	}
}
