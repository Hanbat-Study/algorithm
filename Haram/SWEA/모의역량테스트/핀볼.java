import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
	static int T, N, map[][], answer, d, nx, ny;
	static List<Point> startPoints;
	static Map<Integer, Point[]> wormholes;
	
	// 시계 방향
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc < T+1; tc++) {
			// 입출력 및 초기화
			input();
			
			// 게임 정보 세팅: 시작 지점 찾기, 웜홀 위치 파악하기
			setting();
			
			// 모든 시작 위치와 시작 방향에 따른 게임을 하고 점수 최댓값 찾기
			simulation();
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	private static void simulation() {		
		for(Iterator<Point> cur = startPoints.iterator(); cur.hasNext(); ) {
			Point start = cur.next();
			
			for(d = 0;  d < 4; d++) {
				// 시작 지점 초기화
				nx = start.x;
				ny = start.y;
				// 이번 라운드 점수 알아내고 정답 업데이트
				int thisRoudScore = playTheGame();
				answer = Math.max(answer, thisRoudScore);
			}
			
			// 이 시작 포인트에서 모든 게임을 완료 했다면 삭제하기 // 굳이 안해도 됨..
			cur.remove();
		}
	}

	private static int playTheGame() {
		int score = 0, cnt = 0;
		int x = nx, y = ny, originD = d; // 초기 위치, 방향 기억하기
		while(true) {
			// 초기 위치로 돌아오거나 블랙홀로 빠지면 
			if((cnt > 0 && x == nx && y == ny) || map[nx][ny] == -1) {				
				d = originD;
				break;
			}
			
			nx += dx[d];
			ny += dy[d];
			
			// 벽 만남
			if(!isIn(nx, ny)) {
				nx -= dx[d];
				ny -= dy[d];
				d = (d + 2) % 4;
				score++;
			}

			// 블록 만남
			if(1 <= map[nx][ny] && map[nx][ny] <= 5) {
				block();
				score++;
			}
			
			// 웜홀 빠짐
			if(6 <= map[nx][ny] && map[nx][ny] <= 10)
				wormhole(map[nx][ny]);
			
			cnt++;
		}
		
		return score;
	}

	private static void wormhole(int num) {
		for(Point hole : wormholes.get(num)) {
			if(nx == hole.x && ny == hole.y) continue;
			// 반대쪽 홀로 이동
			nx = hole.x;
			ny = hole.y;
			return;
		}
	}

	private static void block() {
		switch (map[nx][ny]) {
		case 1:
			if(d == 0 || d == 1) d = (d+2) % 4;
			else if(d == 2) d = 1;
			else if(d == 3) d = 0;
			break;
		case 2:
			if(d == 1 || d == 2) d = (d+2) % 4;
			else if(d == 0) d = 1;
			else if(d == 3) d = 2;
			break;
		case 3:
			if(d == 2 || d == 3) d = (d+2) % 4;
			else if(d == 1) d = 2;
			else if(d == 0) d = 3;
			break;
		case 4:
			if(d == 0 || d == 3) d = (d+2) % 4;
			else if(d == 1) d = 0;
			else if(d == 2) d = 3;
			break;
		case 5:
			d = (d+2) % 4;
			break;
		}
	}

	private static boolean isIn(int x, int y) {
		if(-1 < x && x < N && -1 < y && y < N) return true;
		else return false;
	}

	private static void setting() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				// 시작 지점이 될 수 있는 좌표들
				if(map[i][j] == 0) startPoints.add(new Point(i, j));
				// 웜홀 
				if(6 <= map[i][j] && map[i][j] <= 10) {
					Point[] values = new Point[2];
					if(wormholes.containsKey(map[i][j])) {
						values[0] = wormholes.get(map[i][j])[0];
						values[1] = new Point(i, j);
					} else {
						values[0] = new Point(i, j);					
					}
					wormholes.put(map[i][j], values);
				}
			}
		}
	}

	private static void input() throws Exception {
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		startPoints = new ArrayList<>();
		wormholes = new HashMap<>();
		answer = Integer.MIN_VALUE;
	}
}
