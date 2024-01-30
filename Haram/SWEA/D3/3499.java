import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int answer = 0;
			
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String[] cardDeck = new String[N];
			String[] newCardDeck = new String[N];
			
			for(int i = 0; i < N; i++)
				cardDeck[i] = st.nextToken();
			
			int idx = 0;
			for(int i = 0; i < N; i++) {
				if(i % 2 == 0) {					
					newCardDeck[i] = cardDeck[idx];
					idx++;
				}
			}
			
			for(int i = 0; i < N; i++) {
				if(i % 2 == 1) {					
					newCardDeck[i] = cardDeck[idx];
					idx++;
				}
			}
				
			System.out.printf("#%d ", t+1);
			for(String card : newCardDeck) {
				System.out.print(card + " ");
			}
			System.out.println();
		}
	}		
}