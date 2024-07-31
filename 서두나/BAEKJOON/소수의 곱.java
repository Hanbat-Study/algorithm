import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static double max = Math.pow(2, 31);

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[] arr = new int[k];

		PriorityQueue<Long> pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < k; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			pq.add(Long.valueOf(arr[i]));
		}

		int cnt = 1;
		while (cnt < n) {
			long top = pq.poll();
			cnt++;
			for (int i = 0; i < k; i++) {
				if (top * arr[i] >= max) {
					break;
				}

				pq.add(top * arr[i]);

				if (top % arr[i] == 0) {
					break;
				}
			}
		}

		System.out.println(pq.peek());
	}
}
