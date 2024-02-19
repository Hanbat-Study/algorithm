import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_17070 {
    static int n, res;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        visited[0][0] = true;
        visited[0][1] = true;
        dfs(0, 1, 1);
        System.out.println(res);
    }

    private static void dfs(int r, int c, int d) {
        if (r == n -1 && c == n -1 ) {
            res++;
            return;
        }
        if(!visited[r][c]) {
            visited[r][c] = true;

        }
        if (isIn(r + 1, c+ 1) && map[r + 1][c + 1] == 0 && isIn(r, c+ 1) && map[r][c+ 1] == 0 && isIn(r + 1, c)&& map[r+1][c] == 0)
            dfs(r+1, c+1, 0);
        if ((d == 1 || d == 0) && isIn(r, c+1) && map[r][c+1] == 0)
            dfs(r, c+1, 1);
        if ((d == 2 || d == 0) && isIn(r+1, c) && map[r+1][c] == 0)
            dfs(r+1, c, 2);
    }

    private static boolean isIn(int r, int c) {
        return (0 <= r && r < n && 0 <= c && c < n);
    }
}