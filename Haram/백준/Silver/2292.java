import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int i = 1;
		int j = 1;
		int cnt = 0;
		
		boolean flag = true;
		
		while(flag) {
			if(i <= N && N <= j) 
				flag = false;

			cnt++;

			i = j+1;
			j = i + 6 * cnt - 1;			
		}
		
		System.out.println(cnt);
 	}
}