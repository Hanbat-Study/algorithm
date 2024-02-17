import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, map[][], answer;
	static boolean[] isSelected;
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {			
			input();
			
			isSelected = new boolean[N];
			answer = 20000;
			
			combinations(0, 0);
			
			System.out.println("#" + (t+1) + " " + answer);
		}
	}
	
	private static void combinations(int start, int cnt) {
		if(cnt == N/2) {
			answer = Math.min(answer, cook());
			return;
		}
		
		for(int i = start; i < N; i++) {
			isSelected[i] = true;
			combinations(i+1, cnt+1);
			isSelected[i] = false;
		}
	}
		

	private static int cook() {
		int a = 0, b = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(isSelected[i] && isSelected[j]) 
					a += map[i][j];
				if(!isSelected[i] && !isSelected[j])
					b += map[i][j];
			}
		}
		
		return Math.abs(a - b);
	}

	private static void input() throws Exception {
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}