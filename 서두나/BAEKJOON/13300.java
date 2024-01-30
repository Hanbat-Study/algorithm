package com.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//학년과 성별로 구성된 배열을 만들어 각 조건에 맞는곳에 개수를 저장했다.
// 나누기 연산을 이용해 방의 개수를 구했다.
public class B_13300 {	//13 분
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[2][6];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			arr[s][g - 1] += 1;
		}

		int ans = 0;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				ans += arr[i][j] / k;
				if (arr[i][j] % k != 0) {
					ans += 1;
				}
			}
		}
		System.out.println(ans);
	}
}
