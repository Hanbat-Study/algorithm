import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		int N = Integer.parseInt(tmp[0]);
		int M = Integer.parseInt(tmp[1]);
		
		String[] cards = br.readLine().split(" ");
		int result = 0;
		for(int i = 0; i < N - 2; i++) {
			for(int j = i + 1; j < N - 1; j++) {
				int sum = 0;
				for(int k = j + 1; k < N; k++) {
					sum = Integer.parseInt(cards[i]) + Integer.parseInt(cards[j]) + Integer.parseInt(cards[k]);
					if(sum <= M && Math.abs(M - sum) < Math.abs(M - result))
						result = sum;
				}
			}
		}
		System.out.println(result);
	}
}
