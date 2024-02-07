import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Tomato {
        int x, y; // 좌표 값
        int status; // 0: 안 익음, 1: 익음, -1: 토마토 없음
        int ripenDay; // 토마토가 익는 날
        
        Tomato(int x, int y, int day, int status) {
            this.x = x;
            this.y = y;
            this.ripenDay = day;
            this.status = status;
        }
    }

    static int M, N, days, answer;
    static Tomato[][] box;
    static Queue<Tomato> q;
    static boolean[][] visited;
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken()); // 상자의 가로 칸 y
        N = Integer.parseInt(st.nextToken()); // 상자의 세로 칸 x

        box = new Tomato[N][M];
        visited = new boolean[N][M];
        q = new LinkedList<>();
        int[][] temp = new int[N][];
                
        for(int i = 0; i < N; i++) {
            temp[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for(int j = 0; j < M; j++) { 
                // 토마토가 이미 익어 있으면 0일에 익은 것, 아니면 -1
                box[i][j] = new Tomato(i, j, temp[i][j] == 1 ? 0 : -1, temp[i][j]);  
            }
        }
        
        bfs();
        
        answer = -1;
        boolean cannotRippen = false;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j].status == 0)
                    cannotRippen = true;
                if(box[i][j].ripenDay > answer)
                    answer = box[i][j].ripenDay;
            }
        }
        
        System.out.println(cannotRippen ? "-1" : answer);
    }
    
    private static void bfs() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 익은 토마토 큐에 넣기
                if(box[i][j].status == 1) {
                	visited[i][j] = true;
                	q.offer(new Tomato(i, j, 0, 1));                	
                }
            }
        }
        
        while(!q.isEmpty()) {
            Tomato t = q.poll(); // 현재 토마토
            box[t.x][t.y].status = 1;
            box[t.x][t.y].ripenDay = t.ripenDay;
            
            for(int d = 0; d < 4; d++) {
                int x = t.x + dx[d];
                int y = t.y + dy[d];
                
                if(!isIn(x, y) || visited[x][y]) continue;
                if(box[x][y].status == 0) {                	
                	visited[x][y] = true;          	
                	q.offer(new Tomato(x, y,  t.ripenDay+1, 1));
                }
            }
        }
    }

    private static boolean isIn(int x, int y) {
        if(-1 < x && x < N && -1 < y && y < M) return true;
        else return false;
    }

}