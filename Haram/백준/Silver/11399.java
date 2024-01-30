import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		int[] times = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			times[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(times);
		
		int[] result = times.clone();
 		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) 
				result[i] += times[j];
		}
		
		int answer = 0;
		for(int ele : result)
			answer += ele;
		
		System.out.println(answer);
	}
}
