import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	static int[][] location;
	static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        location = new int[N][M];
        
        tmp = br.readLine().split(" ");
        int[] cur = new int[] {Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1])};
        int dir = Integer.parseInt(tmp[2]);

        
        for(int i = 0; i < N; i++) {
        	tmp = br.readLine().split(" ");        	
        	for(int j = 0; j < M; j++) {
        		location[i][j] = Integer.parseInt(tmp[j]);
        	}
        }
        
        System.out.println(DFS(dir, cur));
    }
    
    static private int DFS(int dir, int[] cur) {
    	Stack<int[]> hasToVisit = new Stack<int[]>();
    	hasToVisit.push(cur);
    	
    	int[] dx = {-1, 0, 1, 0};
    	int[] dy = {0, 1, 0, -1};
    	
    	int result = 0;
    	while(!hasToVisit.isEmpty()) {
    		cur = hasToVisit.pop();
    		if(location[cur[0]][cur[1]] == 0) {
    			result++;
    			location[cur[0]][cur[1]] = -1;
    		}
    		
    		int i = 0;
    		int idx = dir;
    		for(; i < 4; i++) {
    			if(idx == 0)
    				idx = 3;
    			else
    				idx--;

    			int r = cur[0] + dx[idx];
    			int c = cur[1] + dy[idx];
    			
    			if(r < 0 || r >= N || c < 0 || c >= M || location[r][c] != 0) continue;
    			
    			hasToVisit.push(new int[] {cur[0] + dx[idx], cur[1] + dy[idx]});
    			dir = idx;
    			break;
    		}

    		if(i == 4) {
    			if(cur[0] - dx[dir] < 0 || cur[0] - dx[dir] >= N || cur[1] - dy[dir] < 0 || cur[1] - dy[dir] >= M || location[cur[0] - dx[dir]][cur[1] - dy[dir]] == 1)
    				break;
    			
    			hasToVisit.push(new int[] {cur[0] - dx[dir], cur[1] - dy[dir]});
    		}
    		
    	}
    	
    	return result;
    }
}
