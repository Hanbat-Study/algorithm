import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Tomato {
		int x;
		int y;
		int z;
		int status;
		int ripenDay;
		
		Tomato(int x, int y, int z, int status) {
			this.x = x;
			this.y = y;
			this.z = z;
			this.status = status;
		}
	}
	
	static int M, N, H, answer;
	static Tomato[][][] box;
	static boolean visited[][][], alreadyAllRipen, isCannotRipen;
	static Queue<Tomato> q;
	
	static int[] dx = {-1, 1, 0, 0, 0, 0};
	static int[] dy = {0, 0, -1, 1, 0, 0};
	static int[] dz = {0, 0, 0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken()); // y
		N = Integer.parseInt(st.nextToken()); // x
		H = Integer.parseInt(st.nextToken()); // z
		
		answer = 0;
		alreadyAllRipen = true;
		isCannotRipen = false;
		visited = new boolean[H][N][M];
		box = new Tomato[H][N][M];
		q = new LinkedList<Tomato>();
		
		
		for(int k = 0; k < H; k++) {
			for(int i = 0; i < N; i++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; j++) {
					int status = Integer.parseInt(st2.nextToken());
					// 토마토 박스에 넣기
					Tomato tt = new Tomato(i, j, k, status);
					box[k][i][j] = tt;
					
					if(status != 1) {
						alreadyAllRipen = false;
						continue;
					}
					// 익은 토마토 큐에 넣어두기
					q.offer(box[k][i][j]);
					box[k][i][j].ripenDay = 0;
					visited[k][i][j] = true;
				}
			}
		}
		
		if(alreadyAllRipen)
			System.out.println("0");
		else {			
			bfs();
			
			firstLoop:
			for(int k = 0; k < H; k++) {
				for(int i = 0; i < N; i++) {
					for(int j =0; j < M; j++) {
						if(box[k][i][j].status == 0) {
							isCannotRipen = true;
							break firstLoop;
						}
						if(box[k][i][j].status == 1) {
							if(answer < box[k][i][j].ripenDay)
								answer = box[k][i][j].ripenDay;
						}
					}
				}
			}
			
			System.out.println(isCannotRipen ? "-1" : answer);
		}		
	}
	
	private static void bfs() {
		while(!q.isEmpty()) {
			Tomato ct = q.poll(); // current tomato
			
			for(int d = 0; d < 6; d++) {				
				int z = ct.z + dz[d];
				int x = ct.x + dx[d];
				int y = ct.y + dy[d];
				
				if(!isIn(z, x, y) || visited[z][x][y]) continue;
				if(box[z][x][y].status == 0) {					
					visited[z][x][y] = true;
					box[z][x][y].status = 1;
					box[z][x][y].ripenDay = ct.ripenDay + 1;
					q.offer(box[z][x][y]);
				}
			}
		}
		
	}

	private static boolean isIn(int z, int x, int y) {
		if(-1 < z && z < H && -1 < x && x < N && -1 < y && y < M) return true;
		else return false;
	}

}