import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
 
class Solution{
    static int[] dr = {1, 1, -1, -1};//하좌 / 하 우/ 상오/ 상왼
    static int[] dc = {-1, 1, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int n, res, sr, sc;
    static HashSet<Integer> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            res = -1;
            map = new int[n][n];
 
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n ; i++) {
                for (int j = 0; j < n; j++) {
                    sr = i;
                    sc = j;
                    set = new HashSet<>();
                    visited = new boolean[n][n];
                    set.add(map[i][j]);
                    visited[i][j] = true;
                    start(i, j , 0);
 
 
 
 
                }
            }
            System.out.println("#"+ tc + " " + res);
        }
    }
 
    private static void start(int i, int j, int dir) {
        for (int d = dir; d < 4; d++) {
            int nr = i + dr[d];
            int nc = j + dc[d];
            if (!isIn(nr, nc)) continue;
            if (nr == sr && nc == sc && set.size() >= 3) {
                res = Math.max(res, set.size());
                return;
            }
            if (!set.contains(map[nr][nc]) && !visited[nr][nc]) {
                set.add(map[nr][nc]);
                visited[nr][nc] = true;
                start(nr, nc , d);
                visited[nr][nc] = false;
                set.remove(map[nr][nc]);
            }
        }
    }
 
    private static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < n && 0 <= nc && nc < n;
    }
}
