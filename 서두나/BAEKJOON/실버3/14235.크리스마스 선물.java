import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());

			if (k == 0) {
				if (pq.isEmpty()) {
					sb.append(-1);
					sb.append("\n");
				} else {
					sb.append(pq.poll());
					sb.append("\n");
				}
			} else {
				for (int j = 0; j < k; j++) {
					pq.offer(Integer.parseInt(st.nextToken()));
				}
			}
		}

		System.out.println(sb.toString());
	}
}
