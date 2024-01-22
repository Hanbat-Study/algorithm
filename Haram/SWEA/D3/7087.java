import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] firstChars = new int[N];
			
			for(int i = 0; i < N; i++) {
				firstChars[i] = br.readLine().charAt(0) - 'A';
			}
			
			int alpha = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(alpha == firstChars[j])
						alpha++;
				}
			}
			
			System.out.println("#" + (t+1) + " " + alpha);
		}
	}
}