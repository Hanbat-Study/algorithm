import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class bj_14502 {
    static int res, n, m;
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        res = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        select(0);
        System.out.println(res);
    }

    private static void select(int cnt) {
        if (cnt == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0;j < n; j++) {
                if (map[i][j] == 0){
                    map[i][j] = 1;
                    select(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }

    }

    private static void bfs() {
        int[][] tmp = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(map[i], 0, tmp[i], 0 , m);
        }
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 2) q.offer(new int[] {i, j});
            }
        }
        int cnt = 0;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (isIn(nr, nc) && tmp[nr][nc] == 0) {
                    tmp[nr][nc] = 2;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        count(tmp);
    }

    private static void count(int[][] tmp) {
        int cnt = 0;
        for (int i  = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) cnt++;
            }
        }
        res = Math.max(res, cnt);
    }

    private static boolean isIn(int nr, int nc) {
        return 0<= nr && nr < n && 0 <= nc && nc < m;
    }


}
