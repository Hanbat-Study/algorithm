import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, map[][], answer = Integer.MAX_VALUE;
	static boolean open[];
	
	static List<Point> home;
	static List<Point> chicken;
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		input();
		
		open = new boolean[chicken.size()];
		solve(0, 0);
		
		System.out.println(answer);
	}
	
	private static void solve(int cnt, int start) {
		if(cnt == M) {
			// 문 연 치킨 집과 집 사이 거리 계산해서 치킨 거리 계산하기
			int sum = 0; // 도시 전체 치킨 거리
			for(int h = 0; h < home.size(); h++) {
				int temp = Integer.MAX_VALUE;
				int distance = 0;
				for(int i = 0; i < chicken.size(); i++) {
					// 문 닫은 사업장
					if(!open[i]) continue;
					distance = Math.abs(chicken.get(i).x - home.get(h).x) + Math.abs(chicken.get(i).y - home.get(h).y);
					temp = Math.min(temp, distance);
				}
				sum += temp;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for(int i = start; i < chicken.size(); i++) {
			if(open[i] == true) continue;
			open[i] = true;
			solve(cnt+1, i+1);
			open[i] = false;
		}
	}

	private static void input() throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		home = new ArrayList<Point>();
		chicken = new ArrayList<Point>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) home.add(new Point(i, j));
				else if(map[i][j] == 2) chicken.add(new Point(i, j));
			}
		}
	}

}
