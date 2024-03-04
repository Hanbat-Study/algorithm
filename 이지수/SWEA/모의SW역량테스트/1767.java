import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static Point[] cores;
	static int[] connection;
	static int N, coreCnt, connectionCnt, result;
	static int[][] map, copy;
    // 갈 수 있는 방향
    static boolean[][] canGo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine().trim());

        String[] tmp;
        for(int t = 1; t <= TC; t++) {
        	N = Integer.parseInt(br.readLine().trim());
        	map = new int[N][N];
        	result = Integer.MAX_VALUE;
            coreCnt = 0;
            connectionCnt = 0;

        	for(int n = 0; n < N; n++) {
        		tmp = br.readLine().trim().split(" ");
        		for(int i = 0; i < N; i++) {
        			map[n][i] = Integer.parseInt(tmp[i]);
        			
        			if(map[n][i] == 1 && n > 0 && n < N - 1 && i > 0 && i < N - 1)
        				coreCnt++;
        		}        		
        	}
        	
            canGo = new boolean[coreCnt][4];
        	connection = new int[coreCnt];
        	cores = new Point[coreCnt];
        	for(int r = 0; r < N; r++) {
        		for(int c = 0; c < N; c++) {
        			if(map[r][c] == 1 && r > 0 && r < N - 1 && c > 0 && c < N - 1) {
        				boolean flag = false;
        				for(int k = 0; k < 4; k++) {
        					if(canConnect(map, k, r, c)) {
        						canGo[coreCnt - 1][k] = true;
        						flag = true;
        					}
        				}
        				
        				if(flag) {
        					cores[coreCnt - 1] = new Point(r, c);
        					coreCnt--;        					
        				}
        			}
        		}        		
        	}
        	
        	coreCnt = cores.length;

        	connect(0);
        	
        	System.out.println("#" + t + " " + result);
        }
	}
    
	private static void connect(int idx) {
		if(idx == coreCnt) {
			int cnt = 0;
			for(int i = 0; i < connection.length; i++) {
				if(connection[i] > 1)
					cnt++;
			}
			
			if(cnt > connectionCnt) {
				int tmp = calculate();
				
				if(tmp != -1) {
					result = tmp;
					connectionCnt = cnt;
				}
			}
			else if(cnt == connectionCnt) {
				int tmp = calculate();
				
				if(tmp != -1)
					result = Math.min(result, tmp);
			}
				
			return;
		}
		
		for(int c = idx; c < coreCnt; c++) {
			if(connection[c] != 0) continue;
			
			for(int i = 1; i <= 5; i++) {
				if(i > 1 && !canGo[c][i - 2]) continue;
				
				connection[c] = i;
				connect(c + 1);
				connection[c] = 0;
			}
		}
	}

	private static boolean canConnect(int[][] arr, int dir, int r, int c) {
		
		while(r >= 0 && r < N && c >= 0 && c < N) {
			r += dx[dir];
			c += dy[dir];
            
			if(r < 0 || r >= N || c < 0 || c >= N)
				return true;
			
			if(arr[r][c] == 1)
				return false;
		}
        
        return true;
	}

	private static int calculate() {
		copy = new int[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++)
				copy[r][c] = map[r][c];
		}
		
		int totalD = 0;
		for(int i = 0; i < connection.length; i++) {
			if(connection[i] > 1) {
				if(canConnect(copy, connection[i] - 2, cores[i].x, cores[i].y)) {
					int d = 0;
					int r = cores[i].x;
					int c = cores[i].y;
					while(r >= 0 && r < N && c >= 0 && c < N) {
						r += dx[connection[i] - 2];
						c += dy[connection[i] - 2];
						
						if(r < 0 || r >= N || c < 0 || c >= N) break;
						
						copy[r][c] = 1;
						d++;
					}
					
					totalD += d;
				}
				else 
					return -1;
			}
		}
		
		return totalD;
	}
}
