import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] str = br.readLine().split(" ");
		int[] waiting = new int[N];
		
		for(int i = 0; i < N; i++)
			waiting[i] = Integer.parseInt(str[i]);
		
		Arrays.sort(waiting);
		
		int result = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <= i; j++) {
				result += waiting[j];
			}
		}
		System.out.println(result);
	}
}
