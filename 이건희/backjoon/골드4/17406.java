import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, m, k, res;
	static int[][] map;
	static int[][] K;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		K = new int[k][3];
		visited = new boolean[k];
		for (int i = 0; i <n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <m; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			K[i][0] = Integer.parseInt(st.nextToken()) -1;
			K[i][1] = Integer.parseInt(st.nextToken()) -1;
			K[i][2] = Integer.parseInt(st.nextToken());
		}
		res = Integer.MAX_VALUE;
		
		permut(0, map);
		System.out.println(res);
	}
	private static void permut(int cnt, int[][] arr) {
		if (cnt == k) {
			res = Math.min(res, cal(arr));
			return;
		}
		for (int i = 0; i< k; i++) {
			if (visited[i]) continue;
			visited[i] = true;
			permut(cnt + 1, rotate(arr, K[i][0], K[i][1], K[i][2]));
			visited[i] = false;
		}
	}
	private static int cal(int[][] arr) {
		int minSum = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += arr[i][j];
			}
			minSum = Math.min(minSum, sum);
		}
		return minSum;
	}
	private static int[][] rotate(int[][] arr, int r, int c, int s) {
		// TODO Auto-generated method stub
		int[][] tmp = copy(arr);
		
		for (int l = 1; l <= s; l++) {
			int sR = r - l;
			int sC = c - l;
			int eR = r + l;
			int eC = c + l;
			int prev = tmp[sR + 1][sC];
			
			for (int i = sC; i < eC; i++) {
				int temp = tmp[sR][i];
				tmp[sR][i] = prev;
				prev = temp;
			}
			for (int i = sR; i < eR; i++) {
				int temp = tmp[i][eC];
				tmp[i][eC] = prev;
				prev = temp;
			}
			for (int i = eC; i > sC; i--) {
				int temp = tmp[eR][i];
				tmp[eR][i] = prev;
				prev = temp;
			}
			for (int i = eR; i > sR; i--) {
				int temp = tmp[i][sC];
				tmp[i][sC] = prev;
				prev = temp;
			}
		}
		return tmp;
	}
	private static int[][] copy(int[][] arr) {
		int[][] map2 = new int[n][m];
		for (int i = 0; i <n; i++) {
			System.arraycopy(arr[i], 0, map2[i], 0, m);
		}
		return map2;
	}
}
