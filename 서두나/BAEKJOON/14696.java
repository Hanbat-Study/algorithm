package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 조건에 없는 카드를 안받기 위해 조건문을 설정, 각 카드의 종류 개수를 세기 위해 배열을 만들었다., 비트연산을 사용하면 더 효율적인 코드가 나올것같다.
public class Main2 {

	static int[] a;
	static int[] b;

	static char getResult() {

		if (a[4] > b[4]) {
			return 'A';
		}
		if (a[4] < b[4]) {
			return 'B';
		}
		if (a[3] > b[3]) {
			return 'A';
		}
		if (a[3] < b[3]) {
			return 'B';
		}
		if (a[2] > b[2]) {
			return 'A';
		}
		if (a[2] < b[2]) {
			return 'B';
		}
		if (a[1] > b[1]) {
			return 'A';
		}
		if (a[1] < b[1]) {
			return 'B';
		}

		return 'D';
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 조건
		// 별 : 4, 동그라미: 3, 네모: 2, 세모: 1
		// 비트 연산 가능할듯

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			a = new int[5];
			b = new int[5];
			st = new StringTokenizer(br.readLine());
			while (st.countTokens() > 0) {
				int temp = Integer.parseInt(st.nextToken());
				if (0 < temp && temp < 5) {
					a[temp] += 1;
				}
			}
			st = new StringTokenizer(br.readLine());
			while (st.countTokens() > 0) {
				int temp = Integer.parseInt(st.nextToken());
				if (0 < temp && temp < 5) {
					b[temp] += 1;
				}
			}

			System.out.println(getResult());
		}
	}
}
