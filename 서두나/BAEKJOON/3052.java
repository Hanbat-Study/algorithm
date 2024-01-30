package algorithm.baekjoon.s_0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 나머지 값을 표시할 배열을 만들었다. 저장후 배열을 탐색후 나머지 개수를 셌다.
public class B_3052 { //7분
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean[] arr = new boolean[42];
	
	for(int i=0;i<10;i++) {
		int n = Integer.parseInt(br.readLine());
		arr[n%42]=true;
	}
	
	int cnt=0;
	for(int i=0;i<42;i++) {
		if (arr[i]) {
			cnt++;			
		}
	}
	System.out.println(cnt);
}
}

