import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_17136 {
    static int[][] map = new int[10][10];
    static boolean[][] visited = new boolean[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5};

    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        res = Integer.MAX_VALUE;
        bfs(0, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
    }

    private static void bfs(int cnt, int idx) {
        if (idx == 100) {
            res = Math.min(res, cnt);
            return;
        }
        if (res <= cnt) {
            return;
        }
        int r = idx / 10;
        int c = idx % 10;
        if (map[r][c] == 1) {
            for (int i = 5; i > 0; i--) {
                if (paper[i] > 0 && check(r, c, i)) {
                    fill(r, c, i, 0);
                    paper[i]--;
                    bfs(cnt + 1, idx + i);
                    paper[i]++;
                    fill(r, c, i, 1);
                }
            }
        } else {
            bfs(cnt, idx + 1);
        }
    }

    private static void fill(int r, int c, int size, int papper) {
        for (int i = r; i< r + size; i++) {
            for (int j = c; j < c + size; j++) {
                map[i][j] = papper;
            }
        }
    }

    private static boolean check(int r, int c, int size) {
       for (int i = r; i < r + size; i++) {
           for (int j = c; j < c + size; j++) {
               if (i < 0 || i >= 10 || j < 0 || j >= 10 || map[i][j] == 0) {
                   return false;
               }
           }
       }
       return true;
    }
}
