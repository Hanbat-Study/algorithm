import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] receiveBalls = new int[N];
		
		boolean flag = true;

		int idx = 0;
		receiveBalls[idx] = 1;
		
		if(M == 1) 
			System.out.println(0);
		else {			
			while(flag) {
				if(receiveBalls[idx] % 2 == 1) {				
					idx += L;
					idx = (idx+N) % N;
					receiveBalls[idx]++;
					cnt++;
				} else {				
					idx -= L;
					idx = (idx+N) % N;
					receiveBalls[idx]++;
					cnt++;
				}
				
				if(isGameOver(receiveBalls, M))
					flag = false;
			}
			System.out.println(cnt);
		} 		
	}

	private static boolean isGameOver(int[] arr, int M) {
		for(int ele : arr) {
			if(ele == M)
				return true;
		}
		return false;
	}
}
