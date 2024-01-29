import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int answer = 0;
		
		for(int i = 0; i < 10; i++) {
			int score = Integer.parseInt(br.readLine());
			sum += score;
			
			if(sum >= 100) {
				int temp = sum - score;
				if(sum - 100 == 100 - temp)
					answer = Math.max(sum, temp);
				else if(sum - 100 < 100 - temp)
					answer = sum;
				else
					answer = temp;
				break;
			}
			
			answer = sum;
		}
		
		System.out.println(answer);
	}
}
