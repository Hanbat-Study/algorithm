import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_14503 {
    static int n, m, d, r ,c, cnt;
    static int[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static boolean isPossible;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        cnt = 0;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(r,c, d);
        System.out.println(cnt);
    }
    private static boolean isIn(int x, int y) {
        return (0<=x && x < n && 0<=y && y <m);
    }
    private static void dfs(int r, int c, int dir) {
        if (!visited[r][c]) {
            visited[r][c] = true;
            cnt++;
        }
        isPossible = false;
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if( isIn(nr, nc) && map[nr][nc] != 1 && !visited[nr][nc]) {
                    dfs(nr, nc, dir);
                    isPossible = true;
                    break;
            }

        }
        if (!isPossible) {
            int back = (dir + 2) % 4;
            int br = r + dr[back];
            int bc = c + dc[back];
            if (isIn(br, bc) && map[br][bc] != 1) {
                dfs(br, bc, dir);
            }

        }
    }

}