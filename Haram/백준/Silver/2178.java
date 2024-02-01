// 메모리: 21224kb 시간: 316ms 코드길이: 1806

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, maze[][], answer;
	static boolean[][] visited;
	static Point start;
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		maze = new int[N][];
		
		for(int i = 0; i < N; i++) {
			maze[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}
	
		start = Point(0, 0);
		visited = new boolean[N][M];
		
		bfs(start);
		
		bw.write(maze[N-1][M-1] + "\n");
		bw.flush();
		bw.close();
	}
	
	private static void bfs(Point p) {
		Queue<Point> q = new LinkedList<>();
		q.add(p);
		
		while(!q.isEmpty()) {
			Point go = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int x = go.x + dx[d];
				int y = go.y + dy[d];
				Point move = Point(x, y);
				
				if(!isIn(move) || visited[move.x][move.y] || maze[move.x][move.y] == 0) continue;
				visited[move.x][move.y] = true;
				q.offer(move);
				maze[move.x][move.y] += maze[go.x][go.y];
			}
		}
		
	}

	private static boolean isIn(Point p) {
		if(-1 < p.x && p.x < N && -1 < p.y && p.y < M) return true;
		else return false;
	}

	private static Point Point(int i, int j) {
		Point p = new Point();
		
		p.x = i;
		p.y = j;
		
		return p;
	}
}
