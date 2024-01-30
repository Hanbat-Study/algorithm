package algorithm.baekjoon.s_0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// o일때는 연속적으로 점수가 올라가도록, x는 값을 0으로 초기화
public class B_8958 { //11분
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			String temp=br.readLine();
			int result=0;
			int cnt=0;
			
			for(int j=0;j<temp.length();j++) {
				if(temp.charAt(j)=='O') {
					cnt+=1;
				}
				else if(temp.charAt(j)=='X') {
					cnt=0;
				}
				result+=cnt;
			}
			System.out.println(result);
		}
	}
}
