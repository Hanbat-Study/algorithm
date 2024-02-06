import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int N, M, result;
	static int[][] arr;
	static int[][] dis = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
	static ArrayList<int[]> v;
	static LinkedList<int[]> queue;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		result = 0;
		arr = new int[N][M];
		v = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) v.add(new int[] {i, j});
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] != 0) continue;
				
				for (int k = 0; k < N; k++) {
					for (int l = 0; l < M; l++) {
						if ((i == k) && (j == l) || arr[k][l] != 0) continue;
						
						for (int o = 0; o < N; o++) {
							for (int p = 0; p < M; p++) {
								if (((i == o) && (j == p)) || ((k == o) && (l == p)) || arr[o][p] != 0) continue;
								bfs(i, j, k, l, o, p);
							}
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
	
	private static void bfs(int y1, int x1, int y2, int x2, int y3, int x3) {
		int[][] box = new int[N][M];
		queue = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			box[i] = arr[i].clone();
		}
		
		box[y1][x1] = 1;
		box[y2][x2] = 1;
		box[y3][x3] = 1;
		
		for (int[] d : v) {
			queue.offer(d);
		}
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int x = now[1];
			int y = now[0];
			
			for (int i = 0; i < 4; i++) {
				int dx = x + dis[i][1];
				int dy = y + dis[i][0];
				
				if (0 <= dx && dx < M && 0 <= dy && dy < N && box[dy][dx] == 0) {
					box[dy][dx] = 2;
					queue.offer(new int[] {dy, dx});
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) cnt++;
			}
		}
		
		result = Math.max(result, cnt);
	}
}
