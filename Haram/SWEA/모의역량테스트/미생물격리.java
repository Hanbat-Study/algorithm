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
    static class Group {
    	int x, y, num, d;
    	
        public Group(int x, int y, int num, int d) {
        	this.x = x;
        	this.y = y;
            this.num = num;
            this.d = d;
        }
        
        public void setPos(int x, int y) {
        	this.x = x;
        	this.y = y;
        }
        
        public void setNum(int num) {
        	this.num = num;
        }
        
        public void setD(int d) {
        	this.d = d;
        }
    }
    
    static int T, N, M, K;
    static Map<Point, List<Group>> points;
    static List<Group> groups;
    static BufferedReader br;
    
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine());
        
        for(int tc = 1 ; tc < T+1; tc++) {
            input();
            
            simulation();
            
            System.out.println("#" + tc + " " + count());
        }
    }
    
    private static void simulation() {
        while(M-- > 0) {
        	
        	// 좌표 해시맵 초기화
        	initPoints();
        	
        	for(Iterator<Group> cur = groups.iterator(); cur.hasNext(); ) { 
                Group group = cur.next();
                
                int x = group.x;
                int y = group.y;
                int num = group.num;
                int d = group.d;
                
                // 군집 이동
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                // 약품에 닿음
                if(!isSafe(nx, ny)) {
                	group.setNum(num/2);
                	group.setD(changeDir(d));
                }
                
                // 좌표 업데이트
                group.setPos(nx, ny);
                
                // 군집에 미생물이 없어서 사라짐
                if(group.num == 0) {
                	cur.remove();
                	continue;
                }   
                
                // 좌표를 키 값으로 군집 넣어주기
                addPoints(new Point(nx, ny), group);
            }
        	
        	for(Map.Entry<Point, List<Group>> entry : points.entrySet()) {
        		if(entry.getValue().size() == 1) continue;
        		
        		// 포인트를 키로 하는 딕셔너리에서 2개 이상 요소를 가지면 합쳐지는 군집
        		int num = 0; // 합쳐질 군집의 미생물 수
        		Group target = entry.getValue().get(0);
        		int targetNum = target.num;
        		for(Group g : entry.getValue()) {
        			num += g.num;
        			if(target.num < g.num) {
        				target = g;
        				targetNum = g.num;
        			}        			
        		}
        		
        		for(Iterator<Group> cur = groups.iterator(); cur.hasNext(); ) {
        			Group g = cur.next();
        			
        			if(entry.getKey().x == g.x && entry.getKey().y == g.y && g.num != targetNum) cur.remove();
        		}
        		
        		target.setNum(num);
        	}
        }
    }

	private static int changeDir(int d) {
		if(d == 1) return 2;
		else if(d == 2) return 1;
		else if(d == 3) return 4;
		else return 3;
	}

	private static boolean isSafe(int x, int y) {
		if(0 < x && x < N-1 && 0 < y && y < N-1) return true;
		else return false;
	}

	private static int count() {
        int cnt = 0;
        for(Group group : groups) {
        	cnt += group.num;
        }
        return cnt;
    }

    private static void input() throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        groups = new ArrayList<>();
        
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            Group newGroup = new Group(x, y, num, d);
            groups.add(newGroup);
        }
    }

	private static void initPoints() {
		points = new HashMap<>();		
	}

	private static void addPoints(Point key, Group newGroup) {
		List<Group> list = new ArrayList<>();
		if(!points.containsKey(key)) {
			list.add(newGroup);
			points.put(key, list);
		}
		else {
			list = points.get(key);
			list.add(newGroup);
			points.put(key, list);
		}
	}

}
