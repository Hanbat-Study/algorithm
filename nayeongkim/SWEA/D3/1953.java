import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_1953 {
    static int n, m, r, c, l, res;
    static int[][] map;
    static boolean[][] visited;
    static int [] dr = {-1, 1, 0, 0};//상 하 좌 우
    static int [] dc = {0, 0, -1, 1};
    static int[][] directions = {
            {0, 1, 2, 3},// 1번 상 하 좌 우
            {0, 1}, // 2번 상 하
            {2, 3}, // 3번 좌 우
            {0, 3}, // 4번 상 우
            {1, 3}, // 5번 하 우
            {1, 2}, // 6번 하 좌
            {0, 2} // 7번 상 좌
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs(r, c);
            System.out.println("#" + tc + " " + res);
        }

    }

    private static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { r, c});
        visited[r][c] = true;
        int day = 1;
        res = 0;
        while (!q.isEmpty()) {
            if (day > l) return;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                res++;
                int curR = cur[0];
                int curC = cur[1];
                int dir = map[curR][curC] - 1;
                for (int d : directions[dir]) {
                    int nr = curR + dr[d];
                    int nc = curC + dc[d];
                    if (!isIn(nr, nc)) continue;
                    if (isValid(nr, nc, d) && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[] { nr, nc});
                    }
                }
            }
            day++;
        }
    }

    private static boolean isValid(int nr, int nc, int d) {
            if (d == 0 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 5 || map[nr][nc] == 6 )) return true;
            else if (d == 1 && (map[nr][nc] == 1 || map[nr][nc] == 2 || map[nr][nc] == 4 || map[nr][nc] == 7 )) return true;
            else if (d == 2 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 4 || map[nr][nc] == 5 )) return true;
            else if (d == 3 && (map[nr][nc] == 1 || map[nr][nc] == 3 || map[nr][nc] == 6 || map[nr][nc] == 7 )) return true;
            return false;
    }

    private static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < n && 0 <= nc && nc < m;
    }
}