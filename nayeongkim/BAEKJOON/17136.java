import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
    static int[][] map = new int[10][10];
    static boolean[][] visited = new boolean[10][10];
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int[] cnts = {0, 5, 5, 5, 5, 5};
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
        dfs(0, 0);
         System.out.println(res == Integer.MAX_VALUE? -1 : res);
    }

    private static void dfs(int idx, int cnt) {
         if (idx == 100) {
             res = Math.min(res, cnt);
             return;
         }
         if (res <= cnt) return;
         int r = idx / 10;
         int c = idx % 10;
         if (map[r][c] == 0) dfs(idx + 1 ,cnt);
         else {
             for (int i = 1; i <= 5; i++) {
                 if (cnts[i] > 0 && isIn(r, c, i)) {
                     cover(r,c,i,0);
                     cnts[i]--;
                     dfs(idx+ 1, cnt +1);
                     cover(r,c,i,1);
                     cnts[i]++;
                 }
             }
         }
    }

    private static void cover(int r, int c, int size, int paper) {
         for(int i = r; i < r+ size; i++) {
             for (int j = c; j < c + size; j++) {
                 map[i][j] = paper;
             }
         }
    }

    private static boolean isIn(int r, int c, int size) {
         for (int i = r; i < r + size; i++) {
             for (int j = c; j < c + size; j++) {
                 if (i >= 10 || j >= 10 || map[i][j] != 1) return false;
             }
         }
         return true;
    }
}
