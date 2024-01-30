import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		for(int i = 1; i <= n; i++) {
			int x = 1;
			while(x <= Math.sqrt(i)) {
				if(i % x == 0)
					cnt++;
				x++;
			}
		}
		
		System.out.println(cnt);
	}
}
