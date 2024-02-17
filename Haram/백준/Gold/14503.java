import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, r, c, d, room[][], answer = 0;
	
	// 북, 동, 남, 서
	static int[]  dx = {-1, 0, 1, 0};
	static int[]  dy = {0, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		inputs();
		
		cleanTheRoom(r, c);
		
		System.out.println(answer);
	}
	
	private static void cleanTheRoom(int x, int y) {
		if(room[x][y] == 0) {
			room[x][y] = 2;
			answer++;
		}
		
		boolean flag = false;
		for(int dir = 0; dir < 4; dir++) {
			int nx = x + dx[dir];
			int ny = y + dy[dir];
			
			if(!isIn(nx, ny) || room[nx][ny] != 0) continue; 
			// 청소 안 된 빈칸 있음
			flag = true;
			break;
		}
		
		if(flag) {
			rotate();
			if(room[x + dx[d]][y + dy[d]] == 0) {
				x += dx[d];
				y += dy[d];
			}
			cleanTheRoom(x, y);			
		}
		// 주변에 청소 안된 빈 칸 없음
		else {
			int[] temp = back(x, y);
			if(temp[0] == -1 && temp[1] == -1) return;
			else cleanTheRoom(temp[0], temp[1]);
		}
	}


	private static void rotate() {
		// 0: 북, 1: 동, 2: 남, 3: 서
		if(d == 0) d = 3;
		else if(d == 1) d = 0;
		else if(d == 2) d = 1;
		else d = 2;
	}

	private static int[] back(int x, int y) {
		int nr = 0, nc = 0;
		if(d == 0) {
			nr = x + dx[2];
			nc = y + dy[2];
		}
		else if(d == 1) {
			nr = x + dx[3];
			nc = y + dy[3];
		}
		else if(d == 2) {
			nr = x + dx[0];
			nc = y + dy[0];
		}
		else {
			nr = x + dx[1];
			nc = y + dy[1];
		}
		if(!isIn(nr, nc) || room[nr][nc] == 1) return new int[] {-1, -1};
		return new int[]{nr, nc};
	}

	private static boolean isIn(int nx, int ny) {
		if(0 < nx && nx < N-1 && 0 < ny && ny < M-1) return true;
		else return false;
	}

	private static void inputs() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st2.nextToken());
		c = Integer.parseInt(st2.nextToken());
		d = Integer.parseInt(st2.nextToken());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st3.nextToken());
			}
		}
	}
}
