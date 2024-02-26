import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Enemy implements Comparable<Enemy> {
		int x, y, d;

		public Enemy(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Enemy o) {
			return this.d == o.d ? this.y - o.y : this.d - o.d;
		}
	}

	static int N, M, D, archer[], answer = Integer.MIN_VALUE;
	static int map[][];
	static List<Point> list;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		archer = new int[3];
		
		// 적 정보
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) list.add(new Point(i, j));
			}
		}
		
		// M개의 성 중 3개에 궁수 배치
		combinations(0, 0);
		
		System.out.println(answer);
	}

	private static void combinations(int idx, int start) {
		if (idx == 3) { 
			init(); // 궁수 위치가 달라질 때마다 적 정보 초기화
			attack();
			return;
		}
		for (int i = start; i < M; i++) {
			archer[idx] = i;
			combinations(idx + 1, i + 1);
		}
	}

	private static void init() {
		list.clear();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) list.add(new Point(i, j));
			}
		}
	}

	private static void attack() {
		int count = 0;

		while (true) {
			if (list.isEmpty())
				break;
			
			// 죽을 애들
			List<Point> targets = new ArrayList<>();

			for (int k = 0; k < 3; k++) {
				PriorityQueue<Enemy> pq = new PriorityQueue<>();

				for (int i = 0; i < list.size(); i++) {
					Point cur = list.get(i);
					int dist = Math.abs(cur.x- N) + Math.abs(cur.y - archer[k]);
					if (dist <= D)
						pq.add(new Enemy(cur.x, cur.y, dist));
				}

				if (!pq.isEmpty()) {
					Enemy target = pq.poll();
					// 궁수의 목표가 중복되는지 확인 (*같은 적이 여러 궁수에게 공격당할 수 있다.)
					boolean flag = false;
					for (int i = 0; i < targets.size(); i++) {
						Point cur = targets.get(i);
						if (target.x == cur.x && target.y == cur.y)
							flag = true;
					}
					if (!flag) {
						targets.add(new Point(target.x, target.y));
					}
				}
			}
			
			// targets에 있는 적들 다 죽이기
			for (int i = 0; i < targets.size(); i++) {
				for (int j = list.size() - 1; j >= 0; j--) {
					if (targets.get(i).x == list.get(j).x && targets.get(i).y == list.get(j).y) {
						list.remove(j);
						count++;
						break;
					}
				}
			}
			
			// 이동 후 성에 닿으면 사라짐
			for (int i = list.size() - 1; i >= 0; i--) {
				list.get(i).x += 1;
				if (list.get(i).x == N)
					list.remove(i);
			}
		}
		
		answer = Math.max(answer, count);
	}
}
