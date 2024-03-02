import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution_5656 {
    static int n, w, h, res, nums[];
    static int[][] map;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            visited = new boolean[h][w];
            nums = new int[n];
            res = Integer.MAX_VALUE;
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            perm(0, map);
            System.out.println("#" + tc + " "+ res);
        }
    }

    private static void perm(int cnt, int[][]prev) {
        if (cnt == n) {
            res = Math.min(res, cal(prev));
            return;
        }
        for (int i = 0; i < w;i++) {
            perm(cnt + 1, remove(prev, i));
        }
    }

    private static int cal(int[][] temp) {
        int sum = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (temp[i][j] > 0) sum++;
            }
        }

        return sum;
    }

    private static int[][] remove(int[][]prev, int idx) {
        int[][] temp = new int[h][w];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i <h; i++) {
            System.arraycopy(prev[i], 0, temp[i], 0, w);
        }
        for (int i = 0; i < h; i++) {
            if (temp[i][idx] != 0) {
                q.offer(new int[] {i , idx , temp[i][idx] - 1});
                temp[i][idx] = 0;
                while (!q.isEmpty()) {
                    int[] cur = q.poll();
                    for (int d= 0; d < 4; d++) {
                        int nr = cur[0];
                        int nc = cur[1];
                        for (int k = 0; k < cur[2]; k++) {
                            nr += dr[d];
                            nc += dc[d];
                            if (isIn(nr, nc) && temp[nr][nc] > 0) {
                                q.offer(new int[] {nr ,nc, temp[nr][nc] - 1});
                                temp[nr][nc] = 0 ;
                            }
                        }
                    }
                }
                Stack<Integer> stack = new Stack<>();
                for (int c = 0; c < w; c++) {
                    for (int r = 0; r < h; r++) {
                        if (temp[r][c] != 0) stack.push(temp[r][c]);
                    }
                    for (int r = h - 1; r >= 0; r--) {
                        if (!stack.isEmpty()) temp[r][c] = stack.pop();
                        else temp[r][c] = 0;
                    }
                }
                break;
            }
        }
        return temp;
    }

    private static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < h && 0 <= nc && nc < w;
    }
}