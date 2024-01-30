import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int cnt = 1;
		int now = 1;
		
		while (now < N) {
			now += cnt * 6;
			cnt++;
		}
		System.out.println(cnt);
	}
}
