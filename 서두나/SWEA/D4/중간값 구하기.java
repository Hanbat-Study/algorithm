import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	static int mod = 20171109;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T;
		T = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> minHeap = new PriorityQueue<>((i1, i2) -> i1 - i2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i1, i2) -> i2 - i1);

		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			long answer = 0;

			minHeap.add(a);

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				if (x > y) {
					minHeap.add(x);
					maxHeap.add(y);
				} else {
					maxHeap.add(x);
					minHeap.add(y);
				}

				if (minHeap.peek() < maxHeap.peek()) {
					int n1 = minHeap.poll();
					int n2 = maxHeap.poll();
					maxHeap.add(n1);
					minHeap.add(n2);
				}

				answer = (answer + minHeap.peek()) % mod;
			}
			System.out.println("#" + test_case + " " + answer);
			minHeap.clear();
			maxHeap.clear();
		}
	}
}
