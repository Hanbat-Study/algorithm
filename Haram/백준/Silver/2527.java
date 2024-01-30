import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int idx = 0; idx < 4; idx++) {
			char answer;
			String[] temp = br.readLine().split(" ");

			int[] aRect = new int[4];
			int[] bRect = new int[4];		
			
			for(int i = 0; i < 8; i++) {
				if(i < 4) 
					aRect[i] = Integer.parseInt(temp[i]);
				else
					bRect[i-4] = Integer.parseInt(temp[i]);
			}
			
			if(aRect[0] > bRect[2] || aRect[2] < bRect[0] || aRect[1] > bRect[3] || aRect[3] < bRect[1]) {
				answer = 'd';
			} 
			else if((aRect[0] == bRect[2] && aRect[1] == bRect[3]) || (aRect[3] == bRect[1] && aRect[2] == bRect[0]) || (aRect[0] == bRect[2] && aRect[3] == bRect[1]) || (aRect[2] == bRect[0] && aRect[1] == bRect[3])) {
				answer = 'c';
			}
			else if(aRect[0] == bRect[2] || aRect[2] == bRect[0] || aRect[1] == bRect[3] || aRect[3] == bRect[1]) {
				answer = 'b';
			}
			else {
				answer = 'a';
			}
			
			System.out.println(answer);
		}
	}
}
