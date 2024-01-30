import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int result = 0;
			boolean cont = false;
			int cnt = 0;
			String ans = br.readLine();
			for(int j = 0; j < ans.length(); j++) {
				char c = ans.charAt(j);
				if(c == 'O' && cont) {
					cnt++;
					result += cnt;
				}
				else if(c == 'O') {
					cnt++;
					cont = true;
					result += cnt;
				}
				else
					cnt = 0;
				
			}
			System.out.println(result);
		}
		
	}
}
