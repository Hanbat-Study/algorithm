import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] seats = br.readLine().split("");
		
		int count = 1;
		for(int i = 0; i < N; i++) {
			if(seats[i].equals("S")) count++;
			else {
				i++;
				count++;
			}
		}
		
		if(count > N) 
			System.out.println(N);
		else
			System.out.println(count);
	}
}
