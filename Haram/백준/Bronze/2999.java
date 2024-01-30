import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String email = br.readLine();
		int N = email.length();
		int R = N;
		
		for(int i = (int) Math.sqrt(N); i > 0; i--) {
			if(N % i == 0) {
				R = i;
				break;
			}
		}
		
		int C = N/R;
		
		char[][] map = new char[C][R];
		
		int idx = 0;
		for(int i = 0; i < C; i++) {
			for(int j = 0; j < R; j++) {
				map[i][j] = email.charAt(idx++);
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				System.out.print(map[j][i]);
			}
		}
	}
}
