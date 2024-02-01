package algorithm.baekjoon.s_0201;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int pos;
		int d;

		Node(int pos, int d) {
			this.pos = pos;
			this.d = d;
		}

	}

	static boolean inRange(int n) {
		return 0 <= n && n < 100_001;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		boolean[] isVisited = new boolean[100_001];

		Queue<Node> q = new LinkedList<>();

		q.offer(new Node(n, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();

			if (cur.pos == k) {
				System.out.print(cur.d);
				break;
			}

			if (inRange(cur.pos - 1) && !isVisited[cur.pos - 1]) {
				q.offer(new Node(cur.pos - 1, cur.d + 1));
				isVisited[cur.pos - 1] = true;
			}
			if (inRange(cur.pos + 1) && !isVisited[cur.pos + 1]) {
				q.offer(new Node(cur.pos + 1, cur.d + 1));
				isVisited[cur.pos + 1] = true;
			}
			if (inRange(cur.pos * 2) && !isVisited[cur.pos * 2]) {
				q.offer(new Node(cur.pos * 2, cur.d + 1));
				isVisited[cur.pos * 2] = true;
			}
		}

	}
}
