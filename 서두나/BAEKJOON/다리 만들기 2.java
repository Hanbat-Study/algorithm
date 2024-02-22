// 다리를 만들 수 있는 경우의 수를 구하고,
// 해당 다리 길이 순으로 최소 신장 트리를 이용해 다리 길이의 최솟값을 구했다.

package algorithm.baekjoon.s_0219;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17472 {

	static int n, m;
	static int cnt = 1;
	static int[][] arr;

	static class Node {

		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static class Edge implements Comparable<Edge> {
		int to;
		int from;
		int size;

		Edge(int to, int from, int size) {
			this.to = to;
			this.from = from;
			this.size = size;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.size, o.size);
		}

	}

	static PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
	static int[] parents;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		cnt = 2;
		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 섬 번호 부여
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 1) {
					setNum(i, j);
					cnt++;
				}
			}
		}

		parents = new int[cnt];

		// 다리 놓기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] != 0) {
					makeBridge(i, j);
				}
			}
		}

		// 부모 초기화
		for (int i = 0; i < cnt; i++) {
			parents[i] = i;
		}

//		System.out.println(cnt);

		int ans = 0;
		int k = 0;
		// 다리 연결하기
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			if (!union(edge.to, edge.from)) { // 이미 연결이 된건, 다리도 연결된것
				continue;
			}
			k++;
			ans += edge.size;
			if (k == cnt - 3) {  // k=0, cnt=2 부터 시작(-2), 간선은 정점 - 1 (cnt-1)
				break;
			}

//			System.out.println("to= " + edge.to + " from= " + edge.from + " " + ans + " " + edge.size);
		}

		System.out.println(k == cnt - 3 ? ans : -1);
	}

	static int[] drs = { 0, 0, 1, -1 };
	static int[] dcs = { 1, -1, 0, 0 };

	static Queue<Node> q = new LinkedList<>();

	static void setNum(int r, int c) {

		q.offer(new Node(r, c));
		arr[r][c] = cnt;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = cur.r + drs[i];
				int nc = cur.c + dcs[i];
				if (inRange(nr, nc) && arr[nr][nc] == 1) {
					arr[nr][nc] = cnt;
					q.offer(new Node(nr, nc));
				}
			}
		}
	}

	static void makeBridge(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			int size = 0;
			while (true) {
				nr += drs[i];
				nc += dcs[i];

				if (!inRange(nr, nc) || arr[nr][nc] == arr[r][c]) {
					break;
				}

				// 다리가 1개 만들어지고 바로 육지가 나오는 경우 방지, 바다일때
				if (arr[nr][nc] == 0) {
					size++;
					continue;
				}

				if (size > 1) {// 다른 육지, 다리는 2이상
					pq.offer(new Edge(arr[r][c], arr[nr][nc], size));
				}
				
				break;	// 다른 섬에 도착했지만, 다리길이가 1이면 연결 못하므로 종료
			}
		}
	}

	static boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	static int find(int a) {

		if (a == parents[a]) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot == bRoot) {
			return false;
		}

		parents[bRoot] = aRoot;
		return true;
	}
}
