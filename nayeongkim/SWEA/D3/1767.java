import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution_1767 {
    static int res, n, maxCore;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static ArrayList<int[]> cores;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <=T; tc++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            visited = new boolean[n][n];
            res = Integer.MAX_VALUE;
            maxCore = 0;
            cores =  new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) {
                        if (i == 0 || i == n - 1 || j == 0 || j == n - 1) continue;
                        cores.add(new int[] {i, j});
                    }
                }
            }
            connect(0, 0, 0);
            System.out.println("#"+tc + " "+ res);
        }
    }

    private static void connect(int idx, int core, int len) {
        if (idx == cores.size()) {
            if (maxCore < core){
                maxCore = core;
                res = len;
            }
            else if (maxCore == core) res = Math.min(res, len);
            return;
        }
        int r = cores.get(idx)[0];
        int c = cores.get(idx)[1];
       for (int d = 0; d < 4; d++) {
           int count = 0;
           int nr = r;
           int nc = c;
           while (true) {
               nr += dr[d];
               nc += dc[d];
               if (!isIn(nr, nc)) break;
               if (map[nr][nc] != 0) {
                   count = 0;
                   break;
               }
               count++;

           }
           if (count > 0) {
               nr = r;
               nc = c;
               for (int i = 0; i < count; i++) {
                   nr += dr[d];
                   nc += dc[d];
                   map[nr][nc] = 2;
               }
               connect(idx + 1, core + 1, len + count);
               nr = r;
               nc = c;
               for (int i = 0; i < count; i++) {
                   nr += dr[d];
                   nc += dc[d];
                   map[nr][nc] = 0;
               }
           }
       }
       connect(idx + 1, core, len);
    }

    private static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < n && 0 <= nc && nc < n;
    }

}