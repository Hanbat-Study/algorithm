package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// <, > 일때 확인을 해줘 해당 안의 문자는 뒤집지 않고 저장, 나머지는 공백 기준으로 임시 저장을해, 공백이 나올때 뒤집어 저장을 했다.
public class B_17413 { //20분
	public static void main(String[] args) throws IOException {
		int check = 0;
		StringBuilder word = new StringBuilder();
		StringBuilder ans = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String temp = br.readLine();

		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '<') {
				if (word.length() > 0) {
					ans.append(word.reverse());
					word.setLength(0);
				}
				ans.append('<');
				check = 1;
			} else if (temp.charAt(i) == '>') {
				ans.append('>');
				check = 0;
			} else if (check == 0 && temp.charAt(i) == ' ') {
				ans.append(word.reverse());
				ans.append(' ');
				word.setLength(0);
			} else if (check == 0) {
				word.append(temp.charAt(i));
			} else if (check == 1) {
				ans.append(temp.charAt(i));
			}

		}
		if (word.length() > 0) {
			ans.append(word.reverse());
		}
		System.out.println(ans.toString());
	}
}
