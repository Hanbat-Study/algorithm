import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_7576 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M, count;
    static boolean[][] visited;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[] {i, j});
                }
            }
        }
        count = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {

                int[] now = q.poll();
                int nowX = now[0];
                int nowY = now[1];

                for (int d = 0; d < 4; d++) {
                    int nx = nowX + dx[d];
                    int ny = nowY + dy[d];


                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                    if (map[nx][ny] == -1 || visited[nx][ny]) continue;
                    map[nx][ny] = 1;
                    q.offer(new int[] {nx, ny});
                    visited[nx][ny] = true;

                }
            }
            count++;
        }
        for(int i = 0; i< M; i++){
            for (int j = 0; j <N; j++) {
                if(map[i][j] == 0) {
                    count = - 1;
                    break;
                }
            }
        }
        System.out.println(count);
    }


}