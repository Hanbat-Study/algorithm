import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		
		for(int i = 1; i < (int) Math.sqrt(N)+1; i++) {
			for(int j = i; j < N+1; j++) {
				if(i * j <= N)
					cnt++;
				else 
					break;
			}
		}
		
		System.out.println(cnt);
	}
}
