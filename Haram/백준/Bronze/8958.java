import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		String input = "";
		for(int i = 0; i < T+1; i++) {
			while((input = br.readLine()) != null) {
				String[] result = input.split("");
				
				int answer = 0;
				int currScore = 1;
				for(int j = 0; j < result.length; j++) {
					if(result[j].equals("O")) {					
						answer += currScore;
						currScore++;
					}
					else 
						currScore = 1;
				}
				
				System.out.println(answer);
			}
		}
		
	}
}
