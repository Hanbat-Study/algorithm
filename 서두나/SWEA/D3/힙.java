import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String args[]) throws Exception {
		 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> heap = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());

			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int check = Integer.parseInt(st.nextToken());
				int x = 0;
				if (st.hasMoreTokens()) {
					x = Integer.parseInt(st.nextToken());
				}

				if (check == 1) { // 최대 힙에 x를 추가하는 연산
					heap.add(-x);

				} else { // 최대 힙의 루트 노드의 키값을 출력하고 해당 노드를 삭제하는 연산
					if (heap.isEmpty()) {
						sb.append("-1 ");
					} else {
						sb.append(-heap.poll() + " ");
					}
				}
			}
			System.out.println("#" + test_case + " " + sb.toString());
			sb.setLength(0);
			heap.clear();
		}
	}
}
