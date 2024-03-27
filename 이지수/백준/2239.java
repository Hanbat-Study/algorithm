import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static StringBuilder sb = new StringBuilder();
	static int totalCnt = 0;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] board = new int[9][9];
		String[] tmp;
		for(int i = 0; i < 9; i++) {
			tmp = br.readLine().split("");
			for(int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(tmp[j]);
				if(board[i][j] == 0)
					totalCnt++;
			}
		}
		
		dfs(0, board);
	}
	
	private static void dfs(int cnt, int[][] board) {
		int r = cnt / 9;
		int c = cnt % 9;

		if(cnt == 81) {
			for(int i = 0; i < 9; i++) {
				for(int j = 0; j < 9; j++) {
					sb.append(board[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
			return;
		}

		if(board[r][c] == 0) {
			for(int i = 1; i <= 9; i++) {
				board[r][c] = i;
				if(check(r, c, board)) {
					dfs(cnt + 1, board);
				}
				board[r][c] = 0;
			}
		} 
		else
			dfs(cnt + 1, board);
	}
	
	private static boolean check(int r, int c, int[][] board) {
		boolean[] rNums = new boolean[9];
		boolean[] cNums = new boolean[9];
		for(int i = 0; i < 9; i++) {
			if(board[r][i] != 0 && rNums[board[r][i]- 1])
				return false;
			if(board[i][c] != 0 && cNums[board[i][c] - 1])
				return false;
			if(board[r][i] != 0)
				rNums[board[r][i] - 1] = true;
			if(board[i][c] != 0)
				cNums[board[i][c] - 1] = true;
		}

		boolean[] sNums = new boolean[9];
		for(int x = r - r % 3; x < r - r % 3 + 3; x++) {
			for(int y = c - c % 3; y < c - c % 3 + 3; y++) {
				if(board[x][y] != 0 && sNums[board[x][y] - 1])
					return false;
				if(board[x][y] != 0)
					sNums[board[x][y] - 1] = true;
			}
		}

		return true;
	}
}
