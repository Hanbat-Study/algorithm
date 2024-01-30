package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 큰 사각형을 하나 만들고 사각형 영역을 표시해 넓이를 구했다.
public class B_2563 { // 10분
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;

		boolean arr[][] = new boolean[100][100];

		for (int k = 0; k < n; k++) {
			st = new StringTokenizer(br.readLine());
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			for (int i = r; i < r + 10; i++) {
				for (int j = c; j < c + 10; j++) {
					arr[i][j] = true;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j]) {
					result++;
				}
			}
		}
		System.out.println(result);
	}

}
