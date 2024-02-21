import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	static ArrayList<Point> cctvs = new ArrayList<>();
	static int N, M;
	static int result = Integer.MAX_VALUE;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		int[][] map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(tmp[j]);
				if(map[i][j] != 0 && map[i][j] != 6) {
					Point p = new Point(i, j);
					cctvs.add(p);
				}
			}
		}
		
		search(map, 0, 0);
		
		System.out.println(result);
	}
	
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	private static void search(int[][] map, int camN, int dir) {
		if(camN == cctvs.size()) {
			int sum = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(map[i][j] == 0)
						sum++;
				}
			}
			
			result = Math.min(sum, result);
			return;
		}
			
		int[][] copy = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				copy[i][j] = map[i][j];
		}
		
		Point p = cctvs.get(camN);
		int type = copy[p.r][p.c];
		
		if(type == 1) {
			int nextR = p.r;
			int nextC = p.c;
			while(true) {
				nextR += dx[dir];
				nextC += dy[dir];
				
				if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
					break;
				
				if(copy[nextR][nextC] == 6) break;
				
				if(copy[nextR][nextC] != 0) continue;
				copy[nextR][nextC] = -1;
			}
			
			if(dir != 3) {
				search(map, camN, dir + 1);
				search(copy, camN + 1, 0);
			}
			else				
				search(copy, camN + 1, 0);
		}
		else if(type == 2) {
			for(int k = 0; k < 2; k++) {
				int nextR = p.r;
				int nextC = p.c;
				while(true) {
					nextR += dx[dir + k * 2];
					nextC += dy[dir + k * 2];
					
					if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
						break;
					
					if(copy[nextR][nextC] == 6) break;
					
					if(copy[nextR][nextC] != 0) continue;
					copy[nextR][nextC] = -1;
				}					
			}
			
			if(dir == 0) {
				search(map, camN, dir + 1);
				search(copy, camN + 1, 0);
			}
			else {				
				search(copy, camN + 1, 0);
			}
		}
		else if(type == 3) {
			if(dir == 0) {
				for(int k = 0; k < 2; k++) {
					int nextR = p.r;
					int nextC = p.c;
					while(true) {
						nextR += dx[dir + k * 3];
						nextC += dy[dir + k * 3];
						
						if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
							break;
						
						if(copy[nextR][nextC] == 6) break;
						
						if(copy[nextR][nextC] != 0) continue;
						copy[nextR][nextC] = -1;
					}					
				}
				
				search(map, camN, dir + 1);
				search(copy, camN + 1, 0);
			}
			else {
				for(int k = 0; k < 2; k++) {
					int nextR = p.r;
					int nextC = p.c;
					while(true) {
						nextR += dx[dir - 1 + k];
						nextC += dy[dir - 1 + k];						
						
						if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
							break;
						
						if(copy[nextR][nextC] == 6) break;
						
						if(copy[nextR][nextC] != 0) continue;
						copy[nextR][nextC] = -1;
					}					
				}
				
				if(dir != 3) {
					search(map, camN, dir + 1);
					search(copy, camN + 1, 0);					
				}
				else
					search(copy, camN + 1, 0);
			}
		}
		else if(type == 4) {
			if(dir == 0) {
				for(int k = 0; k < 3; k++) {
					int idx = 0;
					if(k >= 1)
						idx += (k + 1);

					int nextR = p.r;
					int nextC = p.c;
					while(true) {
						nextR += dx[idx];
						nextC += dy[idx];
						
						if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
							break;
						
						if(copy[nextR][nextC] == 6) break;
						
						if(copy[nextR][nextC] != 0) continue;
						copy[nextR][nextC] = -1;
					}					
				}
				search(map, camN, dir + 1);
				search(copy, camN + 1, 0);
			}
			else if(dir == 1) {
				for(int k = 0; k < 3; k++) {
					int idx = k;
					if(k > 1)
						idx++;

					int nextR = p.r;
					int nextC = p.c;
					while(true) {
						nextR += dx[idx];
						nextC += dy[idx];
						
						if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
							break;
						
						if(copy[nextR][nextC] == 6) break;
						
						if(copy[nextR][nextC] != 0) continue;
						copy[nextR][nextC] = -1;
					}					
				}
				search(map, camN, dir + 1);
				search(copy, camN + 1, 0);
			}
			else if(dir == 2) {
				for(int k = 0; k < 3; k++) {
					int nextR = p.r;
					int nextC = p.c;
					while(true) {
						nextR += dx[k];
						nextC += dy[k];

						if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
							break;
						
						if(copy[nextR][nextC] == 6) break;
						
						if(copy[nextR][nextC] != 0) continue;
						copy[nextR][nextC] = -1;
					}					
				}
				search(map, camN, dir + 1);
				search(copy, camN + 1, 0);
			}
			else {
				for(int k = 0; k < 3; k++) {
					int nextR = p.r;
					int nextC = p.c;
					while(true) {
						nextR += dx[k + 1];
						nextC += dy[k + 1];
						
						if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
							break;
						
						if(copy[nextR][nextC] == 6) break;
						
						if(copy[nextR][nextC] != 0) continue;
						copy[nextR][nextC] = -1;
					}					
				}
				search(copy, camN + 1, 0);
			}
		}
		else {
			for(int k = 0; k < 4; k++) {
				int nextR = p.r;
				int nextC = p.c;
				while(true) {
					nextR += dx[k];
					nextC += dy[k];
					
					if(nextR < 0 || nextR >= N || nextC < 0 || nextC >= M)
						break;
					
					if(copy[nextR][nextC] == 6) break;
					
					if(copy[nextR][nextC] != 0) continue;
					copy[nextR][nextC] = -1;
				}					
			}
			search(copy, camN + 1, 0);
		}
	}
}
