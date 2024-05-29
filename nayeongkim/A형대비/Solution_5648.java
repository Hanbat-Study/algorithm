import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution_5648 {
    static int n, res, mR, mC, max;
    static int[][] map  = new int[4001][4001];
    static Queue<int[]> q = new LinkedList<>();
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            res = 0;
            mR = Integer.MIN_VALUE;
            mC = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken()) * 2 + 2000;
                int r = Integer.parseInt(st.nextToken()) * 2 + 2000;
                r = Math.abs(r - 4000);
                mR = Math.max(mR, r);
                mC = Math.max(mC, c);
                int dir = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                map[r][c] = val;
                q.offer(new int[]{c, r, dir, val});
            }
            max = Math.max(mR, mC);
            bfs();
            System.out.println("#"+ t+ " " + res);
        }

    }

    private static void bfs() {
        while (max-->0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[1];
                int c = cur[0];
                int dir = cur[2];
                int k = cur[3];
                if (map[r][c] != k) {
                    map[r][c] = 0;
                    res += k;
                    continue;
                }
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                move(nr, nc, cur);
            }
        }
    }

    private static void move(int nr, int nc, int[] cur) {
        map[cur[1]][cur[0]] -= cur[3];
        if (isIn(nr, nc)) {
            map[nr][nc] += cur[3];
            cur[1] = nr;
            cur[0] = nc;
            q.offer(new int[]{cur[0], cur[1], cur[2], cur[3]});
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r <=mR && c>= 0 && c <= mC;
    }
}