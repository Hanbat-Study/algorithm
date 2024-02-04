import java.io.BufferedReader;
import java.io.InputStreamReader;
//14min
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String msg = br.readLine();
		int N = msg.length();
		
		int R = 1;
		int C = N;
		int tmp = 1;
		while(tmp <= C) {
			if(N % tmp == 0 && tmp <= C) {
				R = tmp;
				C = N / R;
			}
			
			tmp++;
		}

		char[][] board = new char[R][C];
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				board[i][j] = msg.charAt(i * C + j);
			}
		}
		
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++)
				System.out.print(board[j][i]);
		}
	}
}
