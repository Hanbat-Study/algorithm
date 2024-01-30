package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 크로아티아 알파벳을 배열에 저장해 비교했다. subString 을 이용해 2~3개로 잘라서 비교를 했다.
public class B_2941 {	//30분

	static int cnt = 0;
	static String str;
	static String[] alphabet = { "c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=" };

	static int getpos(int i) {
		for (int j = 2; j < 4; j++) {
			for (String s : alphabet) {
				if (i + j < str.length() + 1 && str.substring(i, i + j).equals(s)) {
					cnt++;
					return i + j - 1;
				}
			}
		}
		cnt++;
		return i;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();

		int i = 0;
//		int cnt=0;
		while (i < str.length()) {
			i = getpos(i);
			i++;
		}
		System.out.println(cnt);
	}
}
