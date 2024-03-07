import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Solution_1949 {
    static int n , k, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static Queue<int[]> q1 = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            int max = 0;
            res = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    max = Math.max(max, map[i][j]);
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j] == max) {
                        for (int r = 0; r < n; r++) {
                            for (int c = 0; c < n; c++) {
                                if (r == i && c == j) continue;
                                map[r][c] -= k;
                                visited = new boolean[n][n];
                                res = Math.max(res, bfs(i, j));
                                map[r][c] += k;
                            }
                        }
                    }
                }
            }
            System.out.println("#" + tc + " "+ res);
        }

    }

    private static int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { i, j});
        int sum = 1;
        visited[i][j] = true;
        while (!q.isEmpty()) {
            int size = q.size();
            sum++;
            for (int k = 0; k <size; k++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (!isIn(nr, nc)) continue;
                    if (map[nr][nc] < map[r][c] && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        System.out.println(nr + "   "+ nc);
                        //System.out.println(sum);
                        q.offer(new int[] {nr, nc});
                        sum = Math.max(sum, bfs(nr, nc) + 1);

                    }

                }

            }

            System.out.println(sum);
        }
        System.out.println();
        return sum;
    }

    private static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < n && 0 <= nc && nc < n;
    }
}
