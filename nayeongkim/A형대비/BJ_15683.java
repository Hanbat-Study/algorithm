import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class BJ_15683 {
    private static int n, m, res;
    private static int[][] map;
    static int[] dr = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int[] dc = {0, 1, 0, -1};
    static int[][][] directions = {
            {{0}},
            {{0},{1},{2},{3}},//1번
            {{0, 2}, {1, 3}}, // 2번
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번
            {{0, 1, 2, 3}} // 5번
    };
    static ArrayList<int[]> cctvs = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (1<= map[i][j] && map[i][j] <= 5) cctvs.add(new int[] {i, j, map[i][j]});
            }
        }
        res = Integer.MAX_VALUE;
        dfs(0, map);
        System.out.println(res);
    }

    private static void dfs(int cnt, int[][] arr) {
        if(cnt == cctvs.size()) {
            res = Math.min(res, cal(arr));
            return;
        }
        int[] cctv = cctvs.get(cnt);
        int[][] tmp = new int[n][m];
        for (int[] dir : directions[cctv[2]] ) {
            for (int i = 0; i < n; i++) {
                System.arraycopy(arr[i], 0, tmp[i], 0, m);
            }
            for (int d : dir) {
                int nr = cctv[0];
                int nc = cctv[1];
                while (true) {
                    nr += dr[d];
                    nc += dc[d];
                    if (!inIn(nr, nc) || tmp[nr][nc] == 6) break;
                    if (tmp[nr][nc] == 0) tmp[nr][nc] = -1;
                }
            }
        dfs(cnt + 1, tmp);
        }
    }

    private static boolean inIn(int nr, int nc) {
        return 0 <= nr && nr < n && 0 <= nc && nc < m;
    }

    private static int cal(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                if (arr[i][j] == 0) sum++;
            }
        }
        return sum;
    }
}
