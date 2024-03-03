// 메모리: 22,640 kb
// 실행시간: 141 ms
// 코드 길이: 2,844
// 풀이 시간: 1시간 14분
import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, K, map[][], copyMap[][], answer, peakHeight;
	static boolean visited[][];
	static List<Point> peaks;
	static BufferedReader br;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T+1; tc++) {
			input();
			
			findPeakHeight();
			
			makePeakList();
			
			for(Point peak : peaks) {
				visited = new boolean[N][N];
				visited[peak.x][peak.y] = true;
				dfs(peak.x, peak.y, 1, 1, map);
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void dfs(int x, int y, int chance, int length, int[][] map) {
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			// 범위 벗어남 
			if(!(0 <= nx && nx < N && 0 <= ny && ny < N)) {	
				answer = Math.max(answer, length);
				continue;
			}
			
			// 왔던 곳
			if(visited[nx][ny]) {
				answer = Math.max(answer, length);
				continue;
			}
			
			// 더 이상 갈 수 없다
			if(chance == 0 && map[x][y] <= map[nx][ny]) {
				answer = Math.max(answer, length);
				continue;								
			}

			// 그냥 지나갈 수 있으면 지나가기
			if(map[x][y] > map[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny, chance, length+1, map);
				visited[nx][ny] = false;
			}
			
			// 지형 깎을 수 있는 기회 남아있고, 깎아서 앞으로 갈 수 있을 때 
			if(chance == 1) {
				// 최대 K만큼 깎을 수 있으므로 
				for(int k = 0; k <= K; k++) {
					if(map[x][y] > map[nx][ny] - k) {
						visited[nx][ny] = true;
						map[nx][ny] -= k;
						dfs(nx, ny, 0, length+1, map);				
						visited[nx][ny] = false;
						map[nx][ny] += k;
					}
				}
			}
		}
	}

	private static void findPeakHeight() {
		peakHeight = map[0][0];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(peakHeight < map[i][j]) peakHeight = map[i][j];
			}
		}
	}
	
	private static void makePeakList() {		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == peakHeight) peaks.add(new Point(i, j));
			}
		}
	}

	private static void input() throws Exception {
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		copyMap = Arrays.copyOf(map, N);
		
		answer = Integer.MIN_VALUE;
		peaks = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
}
