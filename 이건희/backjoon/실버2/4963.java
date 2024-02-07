import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int w, h, result;
	static int[][] arr;
	static LinkedList<int[]> queue = new LinkedList<>();
	static int[][] dis = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String[] s = br.readLine().split(" ");
			
			if (s[0].equals("0") && s[1].equals("0")) break;
			
			w = Integer.parseInt(s[0]);
			h = Integer.parseInt(s[1]);
			result = 0;
			arr = new int[h][w];
			
			for (int i = 0; i < h; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (arr[i][j] == 1) {
						bfs(i, j);						
					}
				}
			}
			
			System.out.println(result);			
		}
	}
	
	private static void bfs(int y, int x) {
		queue.offer(new int[] {y, x});
		result++;
		
		while (!queue.isEmpty()) {
			int[] d = queue.poll();
			int nx = d[1];
			int ny = d[0];
			
			for (int i = 0; i < 8; i++) {
				int dx = nx + dis[i][1];
				int dy = ny + dis[i][0];
				
				if (0 <= dx && dx < w && 0 <= dy && dy < h && arr[dy][dx] == 1) {
					queue.offer(new int[] {dy, dx});
					arr[dy][dx] = 0;
				}
			}
		}
	}
}
