import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int answer = 0;
			
			String str = br.readLine();
			int memoryLength = str.length();
			int[] memory = new int[memoryLength];
		
			for(int i = 0; i < memoryLength; i++) {
				memory[i] = str.charAt(i)-'0';
			}
			
			if(memory[0] == 1) 
				answer++;
			
			for(int i = 0; i < memoryLength-1; i++) {
				if(memory[i] != memory[i+1]) 
					answer++;
			}
			
			System.out.printf("#%d %d\n", t+1, answer);
		}
	}
}