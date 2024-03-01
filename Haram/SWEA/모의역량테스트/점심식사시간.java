import java.awt.Point;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static class Stair {
		int x, y, length;
		
		Stair(int x, int y, int length) {
			this.x = x;
			this.y = y;
			this.length = length;
		}
	}
	
	static int T, N, map[][], answer;
	static List<Point> people;
	static Stair stairs[];
	static BufferedReader br;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc < T+1; tc++) {
			input();
			
			answer = Integer.MAX_VALUE;
			int n = people.size();
			
			for(int r = 0; r < n+1; r++) {
				isSelected = new boolean[n];
				combinations(n, r, 0, 0);
			}
			
			System.out.println("#" + tc + " " + answer);
		}
	}
	
	static boolean isSelected[];
	static List<Integer> group1, group2;
	private static void combinations(int n, int r, int cnt, int start) {
		if(cnt == r) {
			group1 = new ArrayList<>();
			group2 = new ArrayList<>();
			
			for(int i = 0; i < n; i++) {
				if(isSelected[i]) group1.add(i);
				else group2.add(i);				
			}
			
			answer = Math.min(answer, letsgo());
		}
		
		for(int i = start; i < n; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			combinations(n, r, cnt+1, i+1);
			isSelected[i] = false;
		}
	}
	
	static int time;
	private static int letsgo() {
		time = 0;
		
		// 계단 상태
		int[] s1 = {-1, -1, -1};
		int[] s2 = {-1, -1, -1};
		// 대기줄
		Queue<Integer> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();
		
		while(true) {
			downTheStairs(group1, stairs[0], s1, q1);
			downTheStairs(group2, stairs[1], s2, q2);
			
			time++;
			if(group1.size() == 0 && q1.isEmpty() && isEmpty(s1) && group2.size() == 0 && q2.isEmpty() && isEmpty(s2)) 
				break;
		}
		
		return time;
	}

	private static void downTheStairs(List<Integer> group, Stair stair, int[] status, Queue<Integer> q) {		
		// 계단 내려가기
		for(int i = 0; i < 3; i++) {
			if(status[i] == 0) {
				status[i] = -1;
			}
			if(status[i] > 0) status[i]--;
		}
		
		// 대기 줄에 사람 있는데 계단에 자리 있을 때
		if(!q.isEmpty()) {
			while(!isFull(status)) {
				if(arrive(status, stair.length-1)) group.remove(q.poll());			
			}
		}
		
		// 계단에 도착한 사람들
		for(Iterator<Integer> cur = group.iterator(); cur.hasNext(); ) {
			int pIdx = cur.next();
			Point p = people.get(pIdx);
			
			int distance = Math.abs(stair.x - p.x) + Math.abs(stair.y - p.y);
			if(distance == time) {
				// 계단이 꽉 차 있으면 대기
				if(isFull(status)) q.add(pIdx);
				// 빠이염 나는 계단 내려간다!
				else {
					if(arrive(status, stair.length-1)) cur.remove();
				}
			}
		}

	}

	private static boolean isEmpty(int[] status) {		
		boolean flag = true;
		for(int i = 0; i < 3; i++) {
			if(status[i] != -1) flag = false;
		}
		return flag;
	}

	private static boolean isFull(int[] status) {
		boolean flag = true;
		for(int i = 0; i < 3; i++) {
			if(status[i] == -1) flag = false;
		}
		return flag;
	}

	private static boolean arrive(int[] status, int length) {
		for(int i = 0; i < 3; i++) {
			if(status[i] == -1) {
				status[i] = length;
				return true;
			}
		}
		return false;
	}

	private static void input() throws Exception {
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		stairs = new Stair[2];
		people = new ArrayList<>();
		
		int idx = 0;
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) people.add(new Point(i, j));
				if(2 <= map[i][j]) stairs[idx++] = new Stair(i, j, map[i][j]);
			}
		}		
	}
}
