import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_1012 {
    static int N, M, K;
    static boolean [][] visited;
    static boolean[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,-0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new boolean[N][M];
            visited = new boolean[N][M];
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[y][x] = true;
            }
            int count =0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(!visited[i][j] && map[i][j]) {
                        visited[i][j] = true;
                        protect(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }

    private static void protect(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {x, y});
        visited[x][y] = true;
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX+ dx[i];
                int ny = nowY+ dy[i];

                if(nx<0 || nx>=N||ny<0||ny>=M) continue;
                if(visited[nx][ny] || !map[nx][ny]) continue;
                q.add(new int[] {nx, ny});
                visited[nx][ny] = true;

            }

        }
    }
}