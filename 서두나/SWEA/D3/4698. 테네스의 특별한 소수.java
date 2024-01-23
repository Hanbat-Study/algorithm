package algorithm.solve_240121;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int maxNum=1000000;
	static boolean[] isPrime= new boolean[maxNum+1];
	
	public static void setPrime() {
		isPrime[0]=isPrime[1]=false;
		
		for(int i=2;i*i<=maxNum;i++) {
			if(isPrime[i]) {
				for(int j=i*i;j<=maxNum;j+=i) {
					isPrime[j]=false;
				}
			}
		}
	}
	
	public static void main(String args[]) throws Exception {
		
		Arrays.fill(isPrime , true);
		setPrime();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			int cnt=0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			String d=st.nextToken();
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			
			for(int i=a;i<=b;i++) {
				if(isPrime[i] && String.valueOf(i).contains(d)) {
					cnt++;
				}
			}
		
		System.out.println("#"+test_case+" "+cnt);
		}
	}
}
