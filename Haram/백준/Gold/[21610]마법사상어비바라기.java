import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][];
	static boolean cloud[][];
	
	// 0, 1, 2, 3, 4, 5, 6, 7
	// ←, ↖, ↑, ↗, →, ↘, ↓, ↙ 
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cloud = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {			
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 초기 구름 : (N, 1), (N, 2), (N-1, 1), (N-1, 2)
		cloud[N-1][0] = true;
		cloud[N-1][1] = true;
		cloud[N-2][0] = true;
		cloud[N-2][1] = true;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			
			move(d, s);
			
			rain();
		}
		
		System.out.println(sum());
	}
	
	private static int sum() {
		int water = 0;
		
		for(int i = 0; i < N; i++) {			
			for(int j = 0; j < N; j++) {
				water += map[i][j];
			}
		}
		
		return water;
	}

	private static void rain() {
		for(int i = 0; i < N; i++) {			
			for(int j = 0; j < N; j++) {
				if(cloud[i][j]) {			
					int cnt = 0;
					for(int d = 1; d < 8; d=d+2) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						if(isIn(nx, ny) && map[nx][ny] >= 1) cnt++;
					}
					map[i][j] += cnt;
				}
			}
		}
		
		for(int i = 0; i < N; i++) {			
			for(int j = 0; j < N; j++) {
				if(cloud[i][j]) {
					cloud[i][j] = false;
				}
				else if(map[i][j] >= 2) {
					map[i][j] -= 2;	
					cloud[i][j] = true;
				}				
			}
		}
	}

	private static boolean isIn(int x, int y) {
		if(-1 < x && x < N && -1 < y && y < N) return true;
		else return false;
	}

	private static void move(int d, int s) {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {			
			for(int j = 0; j < N; j++) {
				if(cloud[i][j]) q.offer(new int[] {i, j});
			}
		}
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			int nx = (N + cur[0] + dx[d] * (s % N)) % N;
			int ny = (N + cur[1] + dy[d] * (s % N)) % N;
			
			visited[nx][ny] = true;
			map[nx][ny]++;
		}
		
		cloud = visited;
	}

}
