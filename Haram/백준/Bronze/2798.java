import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
				
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		int[] cards = new int[N];
		
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(st2.nextToken());
		}
		
		List<Integer> result = new ArrayList<Integer>();
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) {
				for(int k = j+1; k < N; k++) {
					int sum = cards[i] + cards[j] + cards[k];
					if(M < sum)
						continue;
					result.add(sum);
				}
			}
		}
		
		for(int ele : result) {
			if(answer < ele)
				answer = ele;
		}
		
		System.out.println(answer);
	}
}
