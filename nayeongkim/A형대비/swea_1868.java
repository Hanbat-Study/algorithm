import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class swea_1868 {
    static int n,res;
    static char[][] map;
    static  boolean[][] visited;
    static  int[] dr = {1,-1, 0, 0, 1, -1, 1, -1};
    static  int[] dc = {0,0, 1, -1, 1, 1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            res = 0;
            map = new char[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < n; j++) {
                    map[i][j] = s.charAt(j);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) {
                        boolean flag = false;
                        for (int d = 0; d < 8; d++) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if (isIn(nr, nc) && map[nr][nc] == '*') {
                                flag = true;
                                break;
                            }
                        }
                        if (!flag) {
                            bfs(i, j);
                            res++;
                        }

                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) res++;
                }
            }
            System.out.println("#" + t+ " " + res);
        }

    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j});
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int cnt = 0;
            if (!isIn(r, c)) continue;
            for (int d = 0; d < 8; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (isIn(nr, nc) && map[nr][nc] == '*') cnt++;
            }
            map[r][c] = (char) (cnt + '0');
            if (map[r][c] == '0') {
                for (int d = 0; d < 8; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (isIn(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r <n && c >= 0 && c < n;
    }
}