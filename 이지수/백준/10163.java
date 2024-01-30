import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] strs = new String[N];
		
		for(int i = N - 1; i >= 0; i--)
			strs[i] = br.readLine();
		
		boolean[][] board = new boolean[1001][1001];
		int[] results = new int[N];
		
		for(int i = 0; i < N; i++) {
			String[] tmp = strs[i].split(" ");
			int x = Integer.parseInt(tmp[0]);
			int y = Integer.parseInt(tmp[1]);
			int l1 = Integer.parseInt(tmp[2]);
			int l2 = Integer.parseInt(tmp[3]);
			
			int m = 0;
			for(int r = y; r < y + l2; r++) {
				for(int c = x; c < x + l1; c++) {
					if(!board[r][c]) {
						board[r][c] = true;
						m++;
					}
				}
			}
			
			results[i] = m;
		}
		
		for(int i = N - 1; i >= 0; i--)
			System.out.println(results[i]);
	}
}
