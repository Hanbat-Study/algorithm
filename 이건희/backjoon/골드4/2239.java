import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int[][] sudoku;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		sudoku = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			String[] s = br.readLine().split("");
			
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		dfs(0);
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				sb.append(sudoku[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

	private static void dfs(int cnt) {
		if (cnt == 81) {
			flag = true;
			return;
		}
		
		int r = cnt / 9;
		int c = cnt % 9;
		
		if (sudoku[r][c] != 0) dfs(cnt + 1);
		else {
			for (int i = 1; i <= 9; i++) {
				if (check(i, r, c)) {
					sudoku[r][c] = i;
					dfs(cnt + 1);
					
					if (flag) return;
					sudoku[r][c] = 0;
				}
			}
		}
	}

	private static boolean check(int num, int r, int c) {
		for (int i = 0; i < 9; i++) {
			if (sudoku[i][c] == num || sudoku[r][i] == num) return false;
		}
		
		int nc = c - c % 3;
		int nr = r / 3 * 3;
		
		for (int i = nc; i < nc + 3; i++) {
			for (int j = nr; j < nr + 3; j++) {
				if (sudoku[j][i] == num) return false;
			}
		}
		return true;
	}
}
