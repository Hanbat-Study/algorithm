import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1시간 8분 20초
public class Solution {
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("src/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] primeNums = new boolean[1000000];
		for(int i = 1; i < 1000001; i++) {
			primeNums[i-1] = isPrimeNumber(i-1);
		}
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int answer = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int D = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(int num = A; num < B; num++) {
				if(primeNums[num] && isSpecialNumber(D, num))
						answer++;
			}
				
			System.out.printf("#%d %d\n", t+1, answer);
		}
	}

	private static boolean isSpecialNumber(int d, int num) {
		while(num != 0) {
			if(num % 10 == d)
				return true;
			num /= 10;
		}
		return false;
	}

	private static boolean isPrimeNumber(int num) {
		if(num == 1) 
			return false;
					
		for(int i = 2; i < num-1; i++) {
			if(num % i == 0) 
				return false;
		}
		
		return true;
	}		
}