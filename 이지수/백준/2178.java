import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
	
	static int[][] maze;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		
		maze = new int[N + 2][M + 2];
		for(int i = 1; i <= N; i++) {
			String[] tmp = br.readLine().split("");
			for(int j = 1; j <= M; j++) {
				maze[i][j] = Integer.parseInt(tmp[j - 1]);
			}
		}
		
		System.out.println(nextDir(N, M));
	}
	
	private static int nextDir(int endR, int endC) {
		Queue<int[]> hasToVisit = new ArrayDeque<int[]>();
		int depth = 0;
		int[] cur = {1, 1};
		hasToVisit.offer(cur);
		
		int[] dx = {1, 0, 0, -1};
		int[] dy = {0, 1, -1, 0};
		
		maze[0][0] = 0;
		while(cur[0] != endR || cur[1] != endC) {
			int cnt = hasToVisit.size();
			while(cnt > 0) {
				cur = hasToVisit.poll();

				if(cur[0] == endR && cur[1] == endC) break;
				maze[cur[0]][cur[1]] = 0;

				for(int i = 0; i < 4; i++) {
					if(maze[cur[0] + dx[i]][cur[1] + dy[i]] == 1) {
						hasToVisit.offer(new int[] {cur[0] + dx[i], cur[1] + dy[i]});
						maze[cur[0] + dx[i]][cur[1] + dy[i]] = 0;
					}
				}
				cnt--;
			}
			depth++;
		}
		
		return depth;
	}
}
