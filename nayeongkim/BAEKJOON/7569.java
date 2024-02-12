import java.io.*;
import java.util.*;
class Main_7569 {
    static int M, N, K, result;
    static int[][][] map;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[K][N][M];
        visited = new boolean[K][N][M];
        Queue<int[]> q = new LinkedList<>();
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[k][i][j] =  Integer.parseInt(st.nextToken());
                    if (map[k][i][j] == 1) q.offer(new int[] {k, i, j});
                }
            }
        }
        result =  -1;
        int[] dh = {0, 0, 0, 0, 1, -1};
        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, 1, -1, 0, 0};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] now = q.poll();
                int h = now[0];
                int x = now[1];
                int y = now[2];

                for (int d = 0; d < 6; d++) {
                    int nh = h + dh[d];
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (nh < 0 || nh >= K || nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                    if (map[nh][nx][ny] != 0 || visited[nh][nx][ny]) continue;
                    map[nh][nx][ny] = 1;
                    visited[nh][nx][ny] = true;
                    q.offer(new int[] {nh, nx, ny});
                }


            }
            result++;
        }
        for (int k = 0; k < K; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(map[k][i][j] == 0) {
                        result = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(result);

    }


}