package algorithm.baekjoon.s_0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// r,c를 입력받은 문자열의 길이 제곱근 부터 길이에 나눠떨어지는 가장큰 수를 r로 잡고 나머지를 c로 했다.
// 열 기준 배열을 입력받고 행 순으로 출력을 했다.
public class B_2999 { //20분
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();

		int n = (int) Math.sqrt(temp.length());
		int r, c;
		r = c = 0;

		for (int i = n; i > 0; i--) {
			if (temp.length() % i == 0) {
				r = i;
				c = temp.length() / i;
				break;
			}
		}

		char[][] arr = new char[r][c];
		for (int j = 0; j < c; j++) {
			for (int i = 0; i < r; i++) {
				arr[i][j] = temp.charAt(i + j * r);
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j]);
			}
		}
	}
}
