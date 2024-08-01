package algorithm.baekjoon.s_0731;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2243 {

	static int[] arr;
	static int candy;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new int[1_000_001 * 4];

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == 1) {
				sb.append(find(1, 1, 1_000_000, b) + "\n");
			} else {
				int c = Integer.parseInt(st.nextToken());
				update(1, 1, 1_000_000, b, c);
			}
		}
		System.out.println(sb.toString());
	}

	private static int find(int node, int left, int right, int order) {

		if (left == right) {
			arr[node]--;
			return left;
		}

		int mid = (left + right) / 2;

		int temp = 0;
		if (arr[node * 2] >= order) {
			temp = find(node * 2, left, mid, order);
		} else {
			temp = find(node * 2 + 1, mid + 1, right, order - arr[node * 2]);
		}

		arr[node] = arr[node * 2] + arr[node * 2 + 1];
		return temp;
	}

	private static void update(int node, int left, int right, int index, int value) {
		if (left > index || right < index) {
			return;
		}
		if (left == right) {
			arr[node] += value;
			return;
		}

		int mid = (left + right) / 2;

		update(node * 2, left, mid, index, value);
		update(node * 2 + 1, mid + 1, right, index, value);

		arr[node] = arr[node * 2] + arr[node * 2 + 1];
	}
}
