import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_2178 {
    static int N,M,cnt;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cnt = 0;
        map = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            String[] str = br.readLine().split("");
            for(int j= 0; j<M;j++){
                map[i][j] = Integer.parseInt(str[j]);
            }
        }
        visited[0][0] = true;
        bfs(0, 0);
        System.out.println(map[N-1][M-1]);

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while(!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for(int i =0; i<4;i++){
                int nx = nowX +dx[i];
                int ny = nowY +dy[i];
                if(nx<0 ||ny<0||nx>=N ||ny>=M) continue;
                if(visited[nx][ny] || map[nx][ny] == 0) continue;
                q.add(new int[]{nx, ny});
                map[nx][ny] = map[nowX][nowY]+1;
                visited[nx][ny] = true;

            }
        }
    }
}