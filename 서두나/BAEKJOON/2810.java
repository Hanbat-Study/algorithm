package algorithm.baekjoon.s_0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 컵홀더가 L인 경우 중간에 하나가 빠져서 조건문으로 건너뛰게 만들었다.
public class B_2810 { //15분

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String temp = br.readLine();
		int cur = 0;
		int cnt = 1;

		while (cur < n) {
			if (temp.charAt(cur) == 'L') {
				cur++;
			}
			cnt++;
			cur++;
		}
		System.out.println(Math.min(cnt, n));
	}
}
