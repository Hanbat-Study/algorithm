import java.io.BufferedReader;
import java.io.InputStreamReader;
//a.m. 10 : 05 ~
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] mushrooms = new int[10];
		
		for(int i = 0; i < 10; i++)
			mushrooms[i] = Integer.parseInt(br.readLine());
		
		int result = 0;
		for(int i = 0; i < 10; i++) {
			int score = 0;
			for(int j = 0; j <= i; j++) {
				score += mushrooms[j];
			}
			
			if(Math.abs(result - 100) >= Math.abs(score - 100))
				result = score;
			else if(Math.abs(result - 100) < Math.abs(score - 100) && score > 100)
				break;
		}
		
		System.out.println(result);
	}
}
