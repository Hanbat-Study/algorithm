import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] array;
	static int N, M;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		int R = Integer.parseInt(tmp[2]);
		
		array = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			tmp = br.readLine().split(" ");
			for(int j = 0; j < M; j++)
				array[i][j] = Integer.parseInt(tmp[j]);
		}
		
		tmp = br.readLine().split(" ");
		for(int i = 0; i < R; i++) {
			int op = Integer.parseInt(tmp[i]);
			
			switch(op) {
				case 1:
					op1();
					continue;
				case 2:
					op2();
					continue;
				case 3:
					op3();
					continue;
				case 4:
					op4();
					continue;
				case 5:
					op5();
					continue;
				case 6:
					op6();
					continue;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				sb.append(array[i][j]).append(" ");
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
	private static void op1() {
		for(int i = 0; i < N / 2; i++) {
			int[] tmp = array[i];
			array[i] = array[N - i - 1];
			array[N - i - 1] = tmp;
		}
	}
	
	private static void op2() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M / 2; j++) {
				int tmp = array[i][j];
				array[i][j] = array[i][M - j - 1];
				array[i][M - j - 1] = tmp;
			}
		}
	}
	
	private static void op3() {
		int[][] newArr = new int[M][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				newArr[j][N - 1 - i] = array[i][j];
		}
		
		int tmp = M;
		M = N;
		N = tmp;

		array = newArr;
	}
	
	private static void op4() {
		int[][] newArr = new int[M][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++)
				newArr[M - 1 - j][i] = array[i][j];
		}
		
		int tmp = M;
		M = N;
		N = tmp;

		array = newArr;
	}
	
	private static void op5() {
		int[][] newArr = new int[N][M];
		
		int[] dx = {0, 1, -1, 0};
		int[] dy = {1, 0, 0, -1};
		int idx = 1;
		for(int i = 0; i < N; i++) {
			if(i == N / 2)
				idx += 2;
			for(int j = 0; j < M; j++) {
				if(j == 0)
					idx--;
				if(j == M / 2) 
					idx++;
				newArr[i + (N / 2) * dx[idx]][j + (M / 2) * dy[idx]] = array[i][j];
			}
		}
		
		array = newArr;
	}
	
	private static void op6() {
		int[][] newArr = new int[N][M];
		
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, -1, 1, 0};
		int idx = 1;
		for(int i = 0; i < N; i++) {
			if(i == N / 2)
				idx += 2;
			for(int j = 0; j < M; j++) {
				if(j == 0)
					idx--;
				if(j == M / 2) 
					idx++;
				newArr[i + (N / 2) * dx[idx]][j + (M / 2) * dy[idx]] = array[i][j];
			}
		}
		
		array = newArr;
	}
}
