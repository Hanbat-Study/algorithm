import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static boolean check;
	static String[][] arr;
	static int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static LinkedList<int[]> sq = new LinkedList<>();
	static LinkedList<int[]> wq = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		check = true;
		arr = new String[R][C];
		int[] now = new int[2];
		
		for (int i = 0; i < R; i++) {
			String[] s = br.readLine().split("");
			
			for (int j = 0; j < C; j++) {
				arr[i][j] = s[j];
				
				if (s[j].equals("S")) now = new int[]{i, j};
				else if (s[j].equals("*")) wq.offer(new int[] {i, j});
				else if (s[j].equals(".")) sq.offer(new int[] {i, j});
			}
		}
		
		int result = bfs(now[0], now[1]);
		
		System.out.println(result == -1 ? "KAKTUS" : result);
	}

	private static int bfs(int y, int x) {
		LinkedList<int[]> q = new LinkedList<>();
		q.offer(new int[] {y, x});
		
		int[][] cnt = new int[R][C];
		cnt[y][x] = 1;
		
		for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j].equals("*"))
                    q.offer(new int[]{i, j});
            }
        }
		
		while (!q.isEmpty()) {
			int[] d = q.poll();
			String word = arr[d[0]][d[1]];
			
			for (int i = 0; i < 4; i++) {
				int ny = d[0] + dis[i][0];
				int nx = d[1] + dis[i][1];
				
				if (validation(ny, nx)) {
                    continue;
                }
				
				if (word.equals("S")) {
                    if (arr[ny][nx].equals("D")) {
                        return cnt[d[0]][d[1]];
                    }
                    if (arr[ny][nx].equals(".")) {
                    	arr[ny][nx] = "S";
                        q.offer(new int[]{ny, nx});
                        cnt[ny][nx] = cnt[d[0]][d[1]] + 1;
                    }
                }

                if (word.equals("*")) {
                    if (arr[ny][nx].equals(".") || arr[ny][nx].equals("S")) {
                    	arr[ny][nx] = "*";
                        q.offer(new int[]{ny, nx});
                    }
                }
			}
		}
		
		return -1;
	}
	
	private static boolean validation(int y, int x) {
        return !(0 <= y && y < R && 0 <= x && x < C);
    }
}
