import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N, nCnt, bCnt;
	static String painting[][];
	static boolean visited[][];
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		painting = new String[N][];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			painting[i] = br.readLine().split("");
		}
		
		// 적록색약이 아닌 사람이 보는 그림
		watch(true);
		
		// 적록색약인 사람이 보는 그림
		visited = new boolean[N][N];
		watch(false);
		
		System.out.println(nCnt + " " + bCnt);
	}
	
	private static void watch(boolean isNormal) {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j]) continue;
				if(isNormal) {
					nCnt++;
					if(painting[i][j].equals("R"))	dfs(i, j, "R", "");
					else if(painting[i][j].equals("G"))  dfs(i, j, "G", "");
					else if(painting[i][j].equals("B"))  dfs(i, j, "B", "");
				}
				else {
					bCnt++;
					if(painting[i][j].equals("R") || painting[i][j].equals("G"))  dfs(i, j, "R", "G");
					else if(painting[i][j].equals("B"))	dfs(i, j, "B", "");
				}
			}
		}
	}

	private static void dfs(int x, int y, String color1, String color2) {
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int mx = x + dx[d];
			int my = y + dy[d];
			
			if(!isIn(mx, my) || visited[mx][my]) continue;
			if(painting[mx][my].equals(color1) || (!color2.equals("") && painting[mx][my].equals(color2))) {
				dfs(mx, my, color1, color2);
			}
		}
	}
	
	private static boolean isIn(int x, int y) {
		if(-1 < x && x < N && -1 < y && y < N) return true;
		else return false;
	}
}
