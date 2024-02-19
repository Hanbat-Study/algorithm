import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, map[][], copyMap[][], result[][], temp[][], nums[], x1, y1, x2, y2, x, y, d, answer = Integer.MAX_VALUE;
    static boolean visited[][], checked[][], isSelected[];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws Exception {
    	input();
    	
    	isSelected = new boolean[K];
    	nums = new int[K];
    	permutation(0);
    	
    	System.out.println(answer);
    }
    
    // 수행할 수 있는 연산 모든 경우의 수 
	private static void permutation(int cnt) {
		if(cnt == K) {
			map = copyMap;
			for(int n : nums) {
				// 연산(회전) 후, 배열값 계산하여 최소값으로 정답 업데이트 
				operate(temp[n]);
			}
			return;
		}
		
		for(int i = 0; i < K; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			nums[cnt] = i;
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}


	private static void operate(int[] op) {
		result = new int[N][M];
		x1 = op[0] - op[2] - 1; 
		y1 = op[1] - op[2] - 1;
		x2 = op[0] + op[2]; 
		y2 = op[1] + op[2];
		
		visited = new boolean[N][M];
		checked = new boolean[N][M];
		while(true) {
			if(visited[x1][y1] || x1 == x2 || y1 == y2) 
				break;
			
			rotate();
			
			x1++;
			y1++;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(result[i][j] == 0) result[i][j] = map[i][j];
			}
		}
		
		map = result;
		
		// 배열값 계산 
		calArrValue();
	}

	private static void calArrValue() {
		for(int i = 0; i < N; i++) {
			int temp = 0;
			for(int j = 0; j < M; j++) {
				temp += result[i][j];
			}
			answer = Math.min(answer, temp);
		}
	}

	private static void rotate() {
        Queue<int[]> q = new LinkedList<>();
        x = x1; y = y1; d = 0;
        q.offer(new int[] {x, y});
        visited[x][y] = true;
        while(true) {
        	if(d > 3)  break;
            if(!isIn(x+dx[d], y+dy[d]) || visited[x+dx[d]][y+dy[d]]) {
            	++d;
            	continue;
            }
            x += dx[d];
            y += dy[d];
            visited[x][y] = true;
            q.offer(new int[] {x, y});
        }
        
        q.offer(q.poll());
        
        //boolean[][] checked = new boolean[N][M];
        x = x1; y = y1; d = 0;
        while(!q.isEmpty()) {
            if(!isIn(x+dx[d], y+dy[d]) || checked[x+dx[d]][y+dy[d]]) d++;
            checked[x][y] = true;
            int[] temp = q.poll();
            result[temp[0]][temp[1]] = map[x][y];
            if(d > 3) break;
            x += dx[d];
            y += dy[d];
        }
    }

	private static void input() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		copyMap = Arrays.copyOf(map, N);
		temp = new int[K][3];
		
		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			temp[k][0] = Integer.parseInt(st.nextToken());
			temp[k][1] = Integer.parseInt(st.nextToken());
			temp[k][2] = Integer.parseInt(st.nextToken());
		}
	}
	
    private static boolean isIn(int x, int y) {
        if(x1-1 < x && x < x2 && y1-1 < y && y < y2) return true;
        else return false;
    }
}