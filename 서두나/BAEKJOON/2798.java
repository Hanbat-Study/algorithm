package algorithm.baekjoon.s_0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 3개의 값의 합이 m보다 크지 않고 근접한 값을 구하기 위해, 3개의 값을 스택에 저장해 사용, 3개까지는 수를 담고, 3개 이상이 되면 요구하는 수가 끝났으니 안담는 재귀로 간다.
public class B_2798 {	//30분

	static int[] arr;
	static Stack<Integer> stack = new Stack<>();
	static int total, m;

	static void getNums(int k) {
		if (k == 0) {
			if (stack.size() == 3) {
				int temp = 0;
				for (int i = 0; i < 3; i++) {
					temp += stack.get(i);
				}
				if (temp <= m && m - total > m - temp) {
					total = temp;
				}
			}
			return;
		}

		if (stack.size() < 3) {
			stack.add(arr[k - 1]);
			getNums(k - 1);
			stack.pop();
		}
		getNums(k - 1);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		total = -100_000;

		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		getNums(n);
		System.out.println(total);

	}
}
