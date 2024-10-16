package algorithm.s_1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n];
		
		String[] input = br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			a[i] = Integer.parseInt(input[i]);
		}
		
		input = br.readLine().split(" ");
		
		int b = Integer.parseInt(input[0]);
		int c = Integer.parseInt(input[1]);
		
		long ans=0;
		for(int i=0;i<n;i++) {
			a[i]-=b;
			ans++;
			
			if(a[i]>0) {
				ans+=a[i]/c;
				if(a[i]%c!=0) {
					ans++;
				}
			}
		}
		
		System.out.println(ans);
	}
}
