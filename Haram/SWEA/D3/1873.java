import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int UP = 0;
	static int DOWN = 1;
	static int LEFT = 2;
	static int RIGHT = 3;
	
	static char UP_TANK = '^';
	static char DOWN_TANK = 'v';
	static char LEFT_TANK = '<';
	static char RIGHT_TANK = '>';
	static char GROUND = '.';
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		int t = 0;
		while(t++ < T) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			
			for(int i = 0; i < H; i++) {
				String str = br.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			int d = 0;
			int tx = 0;
			int ty = 0;
			boolean flag = false;
			
			for(int i = 0; i < H; i++) {
				if(flag) break;
				for(int j = 0; j < W; j++) {
					if(map[i][j] == UP_TANK) {
						d = UP; 
						tx = i; 
						ty = j;
						flag = true;
					}
					else if(map[i][j] == DOWN_TANK) {
						d = DOWN; 
						tx = i; 
						ty = j;
						flag = true;
					}
					else if(map[i][j] == LEFT_TANK) {
						d = LEFT; 
						tx = i; 
						ty = j;
						flag = true;
					}
					else if(map[i][j] == RIGHT_TANK) {
						d = RIGHT; 
						tx = i; 
						ty = j;		
						flag = true;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String[] inputs = br.readLine().split("");
			
			for(String input : inputs) {
				if(input.equals("U")) {
					d = UP;
					map[tx][ty] = UP_TANK;
					if((-1 < tx-1 && tx-1 < H) && map[tx-1][ty] == GROUND) {
						map[tx][ty] = GROUND;
						map[--tx][ty] = UP_TANK;
					}
				}
				else if(input.equals("D")) {
					d = DOWN;
					map[tx][ty] = DOWN_TANK;
					if((-1 < tx+1 && tx+1 < H) && map[tx+1][ty] == GROUND) {						
						map[tx][ty] = GROUND;
						map[++tx][ty] = DOWN_TANK;
					}
				}
				else if(input.equals("L")) {
					d = LEFT;
					map[tx][ty] = LEFT_TANK;
					if((-1 < ty-1 && ty-1 < W) && map[tx][ty-1] == GROUND) {						
						map[tx][ty] = GROUND;
						map[tx][--ty] = LEFT_TANK;
					}
				}
				else if(input.equals("R")) {
					d = RIGHT;
					map[tx][ty] = RIGHT_TANK;
					if((-1 < ty+1 && ty+1 < W) && map[tx][ty+1] == GROUND) {
						map[tx][ty] = GROUND;
						map[tx][++ty] = RIGHT_TANK;
					}
				}
				else if(input.equals("S")) {
					shoot(map, d, tx, ty, H, W);
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < H; i++) {
				for(int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		} 		
	}
	
	private static void shoot(char[][] map, int d, int tx, int ty, int H, int W) {
		while(true) {
			tx += dx[d];
			ty += dy[d];
			if(!isIn(tx, ty, H, W)) {
				break;
			}
			// 강철로 만들어진 벽 -> 아무일도...
			else if(map[tx][ty] == '#') {
				break;
			}
			// 벽돌로 만든 벽 -> 평지됨
			else if(map[tx][ty] == '*') { 
				map[tx][ty] = '.';
				break;
			}
		}
	}
	
	private static boolean isIn(int x, int y, int H, int W) {
		if(-1 < x && x < H && -1 < y && y < W) return true;
		return false;
	}
}