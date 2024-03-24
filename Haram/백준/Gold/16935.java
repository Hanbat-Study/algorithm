import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R, map[][], operators[], result[][], X, Y, temp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // x
		M = Integer.parseInt(st.nextToken()); // y
		R = Integer.parseInt(st.nextToken());
		map = new int[N][];
		operators = new int[R];
		
		for(int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		
		operators = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		result = map;
		for(int r : operators) {
			N = result.length;
			M = result[0].length;
			result = cal(r);
		}
		
		printMap(result.length, result[0].length);
	}

	private static int[][] cal(int r) {
		if(r == 1) {
			temp = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					temp[i][j] = result[N-i-1][j];
				}			
			}
			return temp;
		}
		else if(r == 2) {
			temp = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					temp[i][j] = result[i][M-j-1];
				}			
			}
			return temp;
		}
		else if(r == 3) {
			temp = new int[M][N];
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					temp[i][j] = result[N-j-1][i];
				}
			}
			return temp;
		}
		else if(r == 4) {
			temp = new int[M][N];
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					temp[i][j] = result[j][M-i-1];
				}
			}
			return temp;
		}
		else if(r == 5) {
			temp = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(-1 < i && i < N/2 && -1 < j && j < M/2)
						temp[i][j] = result[i + N/2][j];
					
					else if(-1 < i && i < N/2 && M/2-1 < j && j < M)
						temp[i][j] = result[i][j - M/2];
					
					else if(N/2-1 < i && i < N && -1 < j && j < M/2) 
						temp[i][j] = result[i][j + M/2];
					
					else if(N/2-1 < i && i < N && M/2-1 < j && j < M)
						temp[i][j] = result[i - N/2][j];
				}
			}
			return temp;
		}
		else if(r == 6) {
			temp = new int[N][M];			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					if(-1 < i && i < N/2 && -1 < j && j < M/2)
						temp[i][j] = result[i][j + M/2];
					
					else if(-1 < i && i < N/2 && M/2-1 < j && j < M)
						temp[i][j] = result[i + N/2][j];
					
					else if(N/2-1 < i && i < N && -1 < j && j < M/2) 
						temp[i][j] = result[i - N/2][j];
					
					else if(N/2-1 < i && i < N && M/2-1 < j && j < M)
						temp[i][j] = result[i][j - M/2];
				}
			}
			return temp;
		}
		
		return temp;
	}

	private static void printMap(int x, int y) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < x; i++) {
			sb.append(result[i][0]);
			for(int j = 1; j < y; j++)
				sb.append(" " + result[i][j]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
