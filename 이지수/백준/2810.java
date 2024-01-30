import java.io.BufferedReader;
import java.io.InputStreamReader;
//a.m. 10 : 20 ~
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String seat = br.readLine();
		
		int result = 1;
		boolean couple = false;
		for(int i = 0; i < seat.length(); i++) {
			char c = seat.charAt(i);
			if(c == 'L' && !couple) {
				couple = true;
				continue;
			}
			if(c == 'L' && couple)
				couple = false;
			result++;
		}
		
		System.out.println(Math.min(N, result));
	}
}
