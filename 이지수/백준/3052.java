import java.io.BufferedReader;
import java.io.InputStreamReader;
//a.m. 10 : 49 ~
public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		int cnt = 0;
		
		for(int i = 0; i < 10; i++) {
			int N = Integer.parseInt(br.readLine()) % 42;
			char c = (char) ('0' + N);
			if(!str.contains("" + c)) {
				str += c;
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
