import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int K = Integer.parseInt(tmp[1]);
		
		int[][] stuCnt = new int[2][6];
		for(int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			int S = Integer.parseInt(str[0]);
			int Y = Integer.parseInt(str[1]);
			stuCnt[S][Y - 1]++;
		}
		
		int result = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				if(stuCnt[i][j] == 0) continue;
				
				if(stuCnt[i][j] < K)
					result++;
				else {
					result += stuCnt[i][j] / K;
					if(stuCnt[i][j] % K != 0)
						result++;
				}
			}
		}
		System.out.println(result);
	}
}
