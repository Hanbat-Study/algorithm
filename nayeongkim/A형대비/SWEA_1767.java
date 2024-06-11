import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


class SWEA_1767 {
    static int n, res, core, count;
    static int[][] map;
    static ArrayList<int[]> list;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j <n ;j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1 && i != 0 && i != n -1 && j !=0 && j != n-1)
                        list.add(new int[]{i, j});
                }
            }
            core = 0;
            res = 144;
            dfs(0, 0, 0);
            System.out.println("#" + t + " "+ res);
        }
    }

    private static void dfs(int idx, int c, int line) {
        if (idx == list.size()) {
            if (core < c){
                core = c;
                res = line;
            } else if (core == c) {
                res = Math.min(res, line);

            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (isConnected(list.get(idx), i)) {
                fill(list.get(idx), i, 2);
                dfs(idx + 1, c + 1, line + count);
                fill(list.get(idx), i, 0);
            }
        }
        dfs(idx + 1, c, line);
    }

    private static void fill(int[] index, int i, int value) {
        count = 0;
        int r = index[0] + dr[i];
        int c = index[1] + dc[i];
        while (isIn(r, c)) {
            map[r][c] = value;
            count++;
            r += dr[i];
            c += dc[i];
        }
    }

    private static boolean isConnected(int[] index, int i) {
        int r = index[0] + dr[i];
        int c = index[1] + dc[i];
        while(isIn(r, c)) {
            if (map[r][c] != 0) return false;
            r += dr[i];
            c += dc[i];
        }
        return true;
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }
}