import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			System.out.printf("#%d ", t+1);
			char[][] board = new char[5][15];
			
			for(int i = 0; i < 5; i++) {
				String temp = br.readLine();
				for(int j = 0; j < temp.length(); j++) {
					board[i][j] = temp.charAt(j);
				}
			}
			
			for(int i = 0; i < 15; i++) {
				for(int j = 0; j < 5; j++) {
                    if(board[j][i] == '\u0000')
						continue;
					System.out.print(board[j][i]);
				}
			}
			System.out.println();
 		}
	}
}