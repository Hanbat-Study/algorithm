package algorithm.baekjoon.s_0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 100과 근접한 값은 서로 값의 차 절대값으로 비교, 같은 경우 큰수를 저장, 중간에 끝기면 더이상 탐색을 안해 완탐으로 값을 더해가는 방식을 사용
public class B_2851 { //20분

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[10];
		int temp = 0;
		int total = -100;

		for (int i = 0; i < 10; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < 10; i++) {
			temp += arr[i];

			if (Math.abs(100 - temp) < Math.abs(100 - total)
					|| (Math.abs(100 - temp) == Math.abs(100 - total) && temp > total)) {
				total = temp;
			}
		}
		// getNums(0);
		System.out.println(total);
	}

}
