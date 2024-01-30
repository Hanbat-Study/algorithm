import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] remainders = new int[42];
		
		for(int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			remainders[n % 42]++;
		}
		
		int cnt = 0;
		for(int i = 0; i < 42; i++) {
			if(remainders[i] > 0)
				cnt++;
		}
		
		System.out.println(cnt);
	}
}
