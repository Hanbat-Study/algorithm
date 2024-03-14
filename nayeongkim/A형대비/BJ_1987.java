import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_bj_1987 {
    static int r, c, res;
    static int[][] map;
    static boolean[] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[26];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j) - 'A';
            }
        }
        res = 1;
        visited[map[0][0]] =true;
        dfs(0, 0, 1);
        System.out.println(res);
    }

    private static void dfs(int r, int c, int len) {
        res = Math.max(res, len);
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (isIn(nr, nc) && !visited[map[nr][nc]]){
                visited[map[nr][nc]] = true;
                dfs(nr, nc, len + 1);
                visited[map[nr][nc]] = false;
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return 0 <= nr && nr < r && 0 <= nc && nc < c;
    }
}