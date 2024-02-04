package algorithm.baekjoon.s_0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//선택하는 구역을 배열을 만들어 표시, 조각을 많이 선택하는 자와, 많이 선택된자를 비교 연산자로 구했다.
public class B_3985 {	//20분

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[l];
		StringTokenizer st;
		int start = 0;
		int end = 0;
		int diff = 0;
		int n1 = 0;
		int cnt = 0;
		int n2 = 0;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			if (diff < end - start) {
				diff = end - start;
				n1 = i;
			}
			int temp = 0;

			for (int j = start - 1; j < end; j++) {
				if (arr[j] == 0) {
					arr[j] = i + 1;
					temp++;
				}
			}
			if (cnt < temp) {
				cnt = temp;
				n2 = i;
			}
		}
		System.out.println(n1 + 1);
		System.out.println(n2 + 1);
	}
}
