import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4044 {
	public static int N, X;
	public static int[][] map;
	public static boolean[] isSelected;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("");
		StringTokenizer st = null;		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int answer = 0;
			for (int i = 0; i < N; ++i) {
				isSelected = new boolean[N];
				if (goX(i, 0)) {
					answer++;
				}
				
				isSelected = new boolean[N];
				if (goY(0, i)) {
					answer++;
				}
			}
			
		
			System.out.println("#" + t + " " + answer);
		}
		
	}
	
	public static boolean goX(int y, int x) {
		for (int i = 0; i < N - 1; ++i) {
			int idx = x + i + 1;
			int height = map[y][idx] - map[y][x + i];
			
			if (height == 1) {
				for (int j = i; j > i - X; j--) {
					if (j < 0) {
						return false;
					}
					
					if (map[y][idx] - map[y][j] != 1) {
						return false;
					}
					
					if (isSelected[j]) {
						return false;
					}
					
					isSelected[j] = true;
				}
			}
			else if (height == -1) {
				for (int j = idx; j < idx + X; ++j) {
					if (j >= N) {
						return false;
					}
					
					if (map[y][j] - map[y][i] != -1) {
						return false;
					}
					
					if (isSelected[j]) {
						return false;
					}
					
					isSelected[j] = true;
				}
			}
			else if (height > 1 || height < -1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean goY(int y, int x) {
		for (int i = 0; i < N - 1; ++i) {
			int idx = y + i + 1;
			int height = map[idx][x] - map[y + i][x];
			
			if (height == 1) {
				for (int j = i; j > i - X; j--) {
					if (j < 0) {
						return false;
					}
					
					if (map[idx][x] - map[j][x] != 1) {
						return false;
					}
					
					if (isSelected[j]) {
						return false;
					}
					
					isSelected[j] = true;
				}
			}
			else if (height == -1) {
				for (int j = idx; j < idx + X; ++j) {
					if (j >= N) {
						return false;
					}
					
					if (map[j][x] - map[i][x] != -1) {
						return false;
					}
					
					if (isSelected[j]) {
						return false;
					}
					
					isSelected[j] = true;
				}
			}
			else if (height > 1 || height < -1) {
				return false;
			}
		}
		
		return true;
	}
}
