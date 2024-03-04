import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, map[][], copyMap[][], result[][], ops[][], nums[];
    static int x1, y1, x2, y2, answer = Integer.MAX_VALUE;
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

    // 연산 순서 다 해보기 
	private static void permutation(int cnt) {
		if(cnt == K) {
			map = copyMap;
			for(int n : nums) {
				// 연산(회전) 후, 배열값 계산하여 최소값으로 정답 업데이트 
				operate(ops[n]);
			}
			
			// 배열값 계산 
			calArrValue();
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

	// 회전 연산 
	private static void operate(int[] op) {
		// 회전 후 배열
		result = new int[N][M];
		
		// 회전 할 부분 시작, 끝 좌표
		x1 = op[0] - op[2] - 1; 
		y1 = op[1] - op[2] - 1;
		x2 = op[0] + op[2]; 
		y2 = op[1] + op[2];

		visited = new boolean[N][M];
		checked = new boolean[N][M];
		while(true) {
			if(visited[x1][y1]) 
				break;

			rotate();

			x1++;
			y1++;
		}
		
		// 회전 하지 않은 나머지 부분 채워주기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(result[i][j] == 0) result[i][j] = map[i][j];
			}
		}

		map = result;
	}

	// 회전
	private static void rotate() {
        Queue<int[]> q = new LinkedList<>();
        
        int x = x1; 
        int y = y1; 
        int d = 0;
        
        while(true) {
        	q.offer(new int[] {x, y});
        	visited[x][y] = true;
        
            if(!isIn(x+dx[d], y+dy[d]) || visited[x+dx[d]][y+dy[d]])
            	++d;
        
            if(d > 3 || visited[x+dx[d]][y+dy[d]])  break;
            
            x += dx[d];
            y += dy[d];
        }
        
        // 한 칸씩 이동하므로 젤 앞에 있는 요소를 젤 끝으로 보낸다.
        q.offer(q.poll());

        x = x1; y = y1; d = 0;
        // Queue에서 하나씩 빼면서 배열 채워가기
        while(true) {
        	int[] temp = q.poll();
        	result[temp[0]][temp[1]] = map[x][y];
        	checked[x][y] = true;
        	
            if(!isIn(x+dx[d], y+dy[d]) || checked[x+dx[d]][y+dy[d]]) d++;
            
            if(d > 3 || q.isEmpty()) break;
            
            x += dx[d];
            y += dy[d];
        }
    }

	// 배열 값 계산후 최소값으로 정답 업데이트
	private static void calArrValue() {
		int value = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			int sum = 0;
			for(int j = 0; j < M; j++) {
				sum += result[i][j];
			}
			value = Math.min(value, sum);
		}
		answer = Math.min(answer, value);
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

		copyMap = Arrays.copyOf(map, N); // 원본 배열 복사해두기
		
		// 연산 정보 배열
		ops = new int[K][3];

		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			ops[k][0] = Integer.parseInt(st.nextToken());
			ops[k][1] = Integer.parseInt(st.nextToken());
			ops[k][2] = Integer.parseInt(st.nextToken());
		}
	}

    private static boolean isIn(int x, int y) {
        if(x1-1 < x && x < x2 && y1-1 < y && y < y2) return true;
        else return false;
    }
}