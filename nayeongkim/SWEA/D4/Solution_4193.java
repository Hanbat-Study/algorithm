package D4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_4193 {
    private static int[][] map;
    private static boolean[][] visited;
    private static int res, n, er, ec;
    private static int[] dr = {0, 0, 1, -1};
    private static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t<= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st= new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sr = Integer.parseInt(st.nextToken());
            int sc = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            er = Integer.parseInt(st.nextToken());
            ec = Integer.parseInt(st.nextToken());
            res = Integer.MAX_VALUE;
            bfs(sr, sc);
            if (res == Integer.MAX_VALUE) res = -1;
            System.out.println("#" + t + " "+ res);
        }
    }
    private static void bfs(int sr, int sc) {
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[] {sr,sc, 0, 2});
        visited[sr][sc] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == er && cur[1] == ec) {
                visited[er][ec] = false;
                res = Math.min(res, cur[2]);
            }
            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                if (!isIn(nr, nc)|| map[nr][nc] == 1 || visited[nr][nc]) continue;
                if (map[nr][nc] == 2) {
                    if (cur[2] % 3 == 2) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc, cur[2] + 1});
                    }
                    else {
                        q.offer(new int[] {cur[0], cur[1], cur[2] + 1});
                    }
                }
                else if (map[nr][nc] == 0){
                    q.offer(new int[] {nr, nc, cur[2] + 1});
                    visited[nr][nc] = true;
                }
            }
        }

    }
    private static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < n && 0 <= nc && nc < n;
    }
}
