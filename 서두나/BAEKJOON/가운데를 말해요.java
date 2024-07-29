import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws Exception {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(br.readLine());
			if (i % 2 == 0) { // 왼쪽에 넣을때
				if (minHeap.size() > 0 && minHeap.peek() < k) {
					maxHeap.add(minHeap.poll());
					minHeap.add(k);
				} else {
					maxHeap.add(k);
				}
			} else { // 오른쪽에 넣을때
				if (maxHeap.size() > 0 && maxHeap.peek() > k) {
					minHeap.add(maxHeap.poll());
					maxHeap.add(k);
				} else {
					minHeap.add(k);
				}
			}

			sb.append(maxHeap.peek() + "\n");
		}

		System.out.println(sb.toString());
	}
}
