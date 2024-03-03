import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Person implements Comparable<Person>{
		Point p;
		int sNum;
		int d1;
		int d2;
		
		Person(Point p, int sNum, int d1, int d2) {
			this.p = p;
			this.sNum = sNum;
			this.d1 = d1;
			this.d2 = d2;
		}

		@Override
		public int compareTo(Person o) {
			if(sNum == 0)
				return Integer.compare(this.d1, o.d1);
			
			return Integer.compare(this.d2, o.d2);
		}
	}
	
	static int N, result;
	static int[][] map;
	static boolean[] selected;
	static Point s1;
	static Point s2;
	static ArrayList<Person> people = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine().trim());

        String[] tmp;
        for(int t = 1; t <= TC; t++) {
        	N = Integer.parseInt(br.readLine().trim());
        	map = new int[N][N];
        	result = Integer.MAX_VALUE;
        	s1 = null;
        	s2 = null;
        	
        	for(int r = 0; r < N; r++) {
        		tmp = br.readLine().trim().split(" ");
        		for(int c = 0; c < N; c++) {
        			map[r][c] = Integer.parseInt(tmp[c]);
        			
        			if(map[r][c] == 1)
        				people.add(new Person(new Point(r, c), -1, 0, 0));
        			else if(map[r][c] > 1 && s1 == null)
        				s1 = new Point(r, c);
        			else if(map[r][c] > 1)
        				s2 = new Point(r, c);
        		}
        	}

        	calD();
        	
        	selected = new boolean[people.size()];
        	select(0);
        	
        	System.out.println("#" + t + " " + result);
        	people.clear();
        }
	}
    
	private static void calD() {
		for(Person p : people) {
			p.d1 = Math.abs(s1.x - p.p.x) + Math.abs(s1.y - p.p.y);
			p.d2 = Math.abs(s2.x - p.p.x) + Math.abs(s2.y - p.p.y);
		}
	}

	private static void select(int cnt) {
		if(cnt == people.size()) {
			PriorityQueue<Person> pq1 = new PriorityQueue<>();
			PriorityQueue<Person> pq2 = new PriorityQueue<>();
			
			for(int i = 0; i < people.size(); i++) {
				if(selected[i]) {
					people.get(i).sNum = 0;
					pq1.offer(people.get(i));
				}
				else {
					people.get(i).sNum = 1;
					pq2.offer(people.get(i));
				}
			}
			
			result = Math.min(result, move(pq1, pq2));
			return;
		}
		
		selected[cnt] = true;
		select(cnt + 1);
		selected[cnt] = false;
		select(cnt + 1);
	}

	private static int move(PriorityQueue<Person> pq1, PriorityQueue<Person> pq2) {
		int t1 = 0;
		int t2 = 0;
		int[] timeTable1 = new int[200];
		int[] timeTable2 = new int[200];

		while(!pq1.isEmpty()) {
			Person p = pq1.poll();
			int start = p.d1;
			int end = start + map[s1.x][s1.y];
			
			for(int i = start + 1; i <= end; i++) {
				if(timeTable1[i] == 3)
					end++;
				else
					timeTable1[i]++;
			}
			
			t1 = Math.max(t1, end + 1);
		}
		
		while(!pq2.isEmpty()) {
			Person p = pq2.poll();
			int start = p.d2;
			int end = start + map[s2.x][s2.y];
			
			for(int i = start + 1; i <= end; i++) {
				if(timeTable2[i] == 3)
					end++;
				else
					timeTable2[i]++;
			}
			
			t2 = Math.max(t2, end + 1);
		}

		return Math.max(t1, t2);
	}
}
