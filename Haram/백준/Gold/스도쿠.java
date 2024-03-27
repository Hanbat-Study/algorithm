import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int[][] map = new int[9][9];
	static ArrayList<int[]> list = new ArrayList<>(); 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<9; i++) {
			String str = br.readLine();
			for(int j=0; j<9; j++) {
				map[i][j] = str.charAt(j) - '0';
				if(map[i][j] == 0) {
					list.add(new int[] {i, j});
				}
			}
		}
		dfs(0);
	}
	
	static void dfs(int cnt) {
		
		if(list.size() == cnt) {
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.exit(0);
		}
		
		
		int x = list.get(cnt)[0];
		int y = list.get(cnt)[1];
		
		boolean[] check = new boolean[10];
		
		// 가로 
		for(int i=0; i<9; i++) {
			if(map[x][i] != 0) {
				check[map[x][i]] = true;
			}
		}
		
		// 세로 
		for(int i=0; i<9; i++) {
			if(map[i][y] != 0) {
				check[map[i][y]] = true;
			}
		}
		
		// 3x3
		int startX = (x / 3) * 3;
		int startY = (y / 3) * 3;
		for(int i = startX; i < startX + 3; i++) {
			for(int j = startY; j < startY + 3; j++) {
				if(map[i][j] != 0) {
					check[map[i][j]] = true;
				}
			}
		}
		
		for(int i=1; i<=9; i++) {
			if(!check[i]) {
				map[x][y] = i;
				dfs(cnt + 1);
				map[x][y] = 0;
			}
		}
	}	
	
}
