import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			int[] cityInfo = new int[N];
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++) {
				cityInfo[i] = Integer.parseInt(st2.nextToken());
			}
			
			int cnt = 0;
			for(int i = 0; i < N; i++) {
				if(cityInfo[i] == 0) 
					cnt++;
                else
                    cnt = 0;
				if(cnt == D) {
					answer++;
					cnt = 0;
				}
			}
			
			System.out.println("#" + (t+1) + " " + answer);
 		}
	}
}