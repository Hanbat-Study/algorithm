import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
    static class Core {
        int x, y;
        boolean dir[];
        
        Core(int x, int y) {
            this.x = x;
            this.y = y;
            this.dir = new boolean[4];
        }
        
        void setDir(int d) {            
            this.dir[d] = true;
        }
    }
    static int T, N, map[][], answer;
    static List<Core> cores;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(br.readLine().trim());
        
        for(int tc = 1; tc < T+1; tc++) {            
            N = Integer.parseInt(br.readLine().trim());
            map = new int[N][N];
            answer = Integer.MAX_VALUE;
            
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            // 하나 이상의 방향으로 연결할 수 있는 코어들로 리스트 만들기
            makeCoreList();
            
            
            //선택된 코어로 연결이 안되면 계속 진행, 연결이 되면 현재 코어 조합과 갯수가 같은 조합까지만 하기
            for(int n = cores.size(); n > 0; n--) {
            	selectedCores = new int[n];
            	isSelected = new boolean[cores.size()];
            	combinations(n, 0, 0);
         
            	if(answer != Integer.MAX_VALUE) break;
            }
            
            
            System.out.println("#" + tc + " " + answer);
        }
    }
    

	static int selectedCores[], drs[];
    static boolean isSelected[];
    private static void combinations(int n, int cnt, int start) {
		if(n == cnt) {
			// 코어별 방향
			drs = new int[n];
			permutation(0);
			return;
		}
		
    	for(int i = start; i < cores.size(); i++) {
    		if(isSelected[i]) continue;
    		isSelected[i] = true;
    		selectedCores[cnt] = i;
    		combinations(n, cnt+1, i+1);
    		isSelected[i] = false;
    	}
	}


	private static void permutation(int idx) {
        if(selectedCores.length == idx) {
        	answer = Math.min(answer, connect());
            return;
        }
        
        for(int d = 0; d < 4; d++) {
            // 처음부터 연결할 수 없는 방향
            if(!cores.get(selectedCores[idx]).dir[d]) 
            	continue;
            drs[idx] = d;
            permutation(idx+1);
        }
    }
    
    static int length;
    static boolean path[][];
    private static int connect() {
        length = 0;
        
        // 전선 가는 길
        path = new boolean[N][N];
        for(int idx = 0; idx < selectedCores.length; idx++) {
        	Core c = cores.get(selectedCores[idx]);
            backtracking(c.x, c.y, 0, idx);
            if(length == -1) return answer;
        }
        return length;
    }

    private static void backtracking(int x, int y, int cnt, int idx) {
        // 다른 전선이랑 겹침
        if(path[x][y]) {
            length = -1;
            return;    
        }
        
        // 무사히 연결 됨!
        if(x == 0 || x == N-1 || y == 0 || y == N-1) {
            length += cnt;
            return;
        }
        
        path[x][y] = true;
        backtracking(x + dx[drs[idx]], y + dy[drs[idx]], cnt+1, idx);
    }
    
    private static void makeCoreList() {
    	cores = new ArrayList<>();
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < N; j++) {
    			if(i == 0 || i == N-1 || j == 0 || j == N-1) continue;
    			// 아니면 리스트에 넣기
    			if(map[i][j] == 1) cores.add(new Core(i, j));
    		}
    	}
    	
    	
    	// 연결 가능한 방향 찾기
    	for(Core c : cores) {
    		for(int d = 0; d < 4; d++) {
    			int x = c.x;
    			int y = c.y;
    			while(true) {
    				x += dx[d];
    				y += dy[d];
    				
    				if(map[x][y] == 1) break;
    				if(x == 0 || x == N-1 || y == 0 || y == N-1) {
    					c.setDir(d);
    					break;
    				}
    			}                
    		}
    	}
    	
    	// 어느 방향으로도 연결할 수 없는 코어들 삭제
    	for(Iterator<Core> cur = cores.iterator(); cur.hasNext(); ) {
    		Core c = cur.next();
    		boolean flag = true;
    		for(boolean d : c.dir) {
    			if(d) flag = false;
    		}
    		if(flag) cur.remove();
    	}
    }
}
