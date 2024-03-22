import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static class MinVartex implements Comparable<MinVartex> {
		int no;
		int weight;

		MinVartex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(MinVartex o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.weight, o.weight);
		}

	}

	static int n, m;
	static int[][] map;
	static Queue<Node> q = new LinkedList<>();
	static int cnt = 2;

	static int[][] adj;
	static boolean[] visited;
	static int[] minEdge;

	static int result = 0;

	static int[] drs = { 0, 0, 1, -1 };
	static int[] dcs = { 1, -1, 0, 0 };

	static int k = 0;

	static PriorityQueue<MinVartex> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		List<Node> pos = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					pos.add(new Node(i, j));
				}
			}
		}

		// 지도 섬 번호 매기기
		for (int i = 0; i < pos.size(); i++) {
			int r = pos.get(i).r;
			int c = pos.get(i).c;
			if (map[r][c] == 1) {
				setMap(r, c);
			}
		}

		// 프림
		adj = new int[cnt][cnt];
		visited = new boolean[cnt];
		minEdge = new int[cnt];

		// 다리 만들기
		for (int i = 0; i < pos.size(); i++) {
			int r = pos.get(i).r;
			int c = pos.get(i).c;
			makeBridge(r, c);

		}

		findMinVertex();
		for (int i = 2; i < cnt; i++) {
			if (!visited[i]) {
				result = -1;
				break;
			}
		}
		// 다리 길이 최솟값 구하기

		System.out.println(result);
	}

	// 지도 섬 번호 매기기
	static void setMap(int r, int c) {

		q.add(new Node(r, c));
		map[r][c] = cnt;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = drs[i] + cur.r;
				int nc = dcs[i] + cur.c;
				if (inRange(nr, nc) && map[nr][nc] == 1) {
					map[nr][nc] = cnt;
					q.add(new Node(nr, nc));
				}
			}
		}
		cnt++;
	}

	static private boolean inRange(int r, int c) {
		return 0 <= r && r < n && 0 <= c && c < m;
	}

	// 다리 만들기
	static void makeBridge(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r;
			int nc = c;
			int size = 0;

			while (true) {
				nr += drs[i];
				nc += dcs[i];

				if (!inRange(nr, nc) || map[nr][nc] == map[r][c]) {
					break;
				}

				if (map[nr][nc] == 0) {
					size++;
					continue;
				}

				if (size > 1) { // 다리 만든것
					if (size > 1) { // 다리 만든것
						if (adj[map[r][c]][map[nr][nc]] == 0 || adj[map[r][c]][map[nr][nc]] > size
								|| adj[map[nr][nc]][map[r][c]] > size) {
							adj[map[r][c]][map[nr][nc]] = size;
							adj[map[nr][nc]][map[r][c]] = size;
						}

					}

				}

				break;
			}

		}
	}

	// to, from 인점 행렬에 weight 저장

	// 프림을 이용해 최소 경로 찾기
	static void findMinVertex() {
		int t = 0;
		Arrays.fill(minEdge, 3, cnt, Integer.MAX_VALUE);

		pq.offer(new MinVartex(2, 0));

		while (!pq.isEmpty()) {

			MinVartex minVartex = pq.poll();

			if (visited[minVartex.no]) {
				continue;
			}

			if (++t == cnt - 1) {
				break;
			}

			visited[minVartex.no] = true;
			result += minVartex.weight;

			for (int j = 2; j < cnt; j++) {
				if (!visited[j] && adj[minVartex.no][j] != 0 && adj[minVartex.no][j] < minEdge[j]) {
					minEdge[j] = adj[minVartex.no][j];
					pq.offer(new MinVartex(j, minEdge[j]));
				}
			}
		}
	}

}
