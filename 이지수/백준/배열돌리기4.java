import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[][] arr, operations;
	static int[] opOrder;
	static boolean[] isSelected;
	static int N, M, K;
	static int result = 5001;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		K = Integer.parseInt(tmp[2]);
		
		arr = new int[N][M];
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for(int j = 0; j < M; j++)
				arr[i][j] = Integer.parseInt(tmp[j]);
		}
		
		operations = new int[K][3];
		opOrder = new int[K];
		isSelected = new boolean[K];
		for(int i = 0; i < K; i++) {
			tmp = br.readLine().split(" ");
			int r = Integer.parseInt(tmp[0]);
			int c = Integer.parseInt(tmp[1]);
			int s = Integer.parseInt(tmp[2]);
			
			operations[i] = new int[] {r, c, s};
		}
			
		getPermu(0);
		System.out.println(result);
	}
	
	private static void rotate(int r, int c, int s) {		
		int[] dx = {0, 1, 0, -1};
		int[] dy = {1, 0, -1, 0};
		for(int i = 0; i < s; i++) {
			int idx = 0;
			int cnt = 8 * s - 8 * i;
			int x = r - s - 1 + i;
			int y = c - s - 1 + i;
			int tmp = arr[x][y];
			while(cnt > 0) {
				int idx1 = x + dx[idx];
				int idx2 = y + dy[idx];
				if(idx1 < r - s - 1 + i || idx1 >= r + s - i || idx2 < c - s - 1 + i || idx2 >= c + s - i) {
					idx++;
					continue;
				}
				
				int tmp2 = arr[idx1][idx2];
				arr[idx1][idx2] = tmp;
				tmp = tmp2;
				
				x = idx1;
				y = idx2;
				
				cnt--;
			}
		}
	}
	
	private static void getPermu(int cnt) {
		if(cnt == K) {
			int[][] newArr = new int[N][M];
			for(int i = 0; i < N; i++)
				newArr[i] = Arrays.copyOf(arr[i], M);
			
			for(int i = 0; i < K; i++)
				rotate(operations[opOrder[i]][0], operations[opOrder[i]][1], operations[opOrder[i]][2]);
			
			for(int x = 0; x < N; x++) {
				int sum = 0;
				for(int y = 0; y < M; y++)
					sum += arr[x][y];
				
				result = Math.min(result, sum);
			}
			
			arr = newArr;
            return;
		}
		
		for(int i = 0; i < K; i++) {
			if(isSelected[i]) continue;
			
			isSelected[i] = true;
			opOrder[cnt] = i;
			getPermu(cnt + 1);
			isSelected[i] = false;
		}
	}
}
