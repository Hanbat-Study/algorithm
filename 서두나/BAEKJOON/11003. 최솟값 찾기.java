import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int value;
		int index;

		Node(int value, int index) {
			this.value = value;
			this.index = index;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Deque<Node> q = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int d = -l + 1;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());

			if (!q.isEmpty() && q.getFirst().index < d + i) {
				q.pollFirst();
			}

			while (!q.isEmpty() && q.getLast().value > temp) {
				q.pollLast();
			}

			q.addLast(new Node(temp, i));

			sb.append(q.getFirst().value + " ");
		}
		System.out.println(sb.toString());
	}
}
