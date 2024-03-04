import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

class Main_1987 {
    static int R, C, res;
    static char[][] map;
    static boolean[] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        res = 1;
        visited=new boolean[26];
        for (int i = 0; i<R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) map[i][j] = s.charAt(j);
        }
        visited[map[0][0] - 'A'] = true;
        alphabet(0, 0, 1);
        System.out.println(res);

    }
    private static void alphabet(int x, int y, int length) {
        res = Math.max(res, length);
        for (int d = 0; d < 4; d ++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            if (0 <= nx && nx <R && 0 <=ny && ny < C && !visited[map[nx][ny] - 'A']) {
                visited[map[nx][ny] - 'A'] = true;
                alphabet(nx, ny, length + 1);
                visited[map[nx][ny] - 'A'] = false;
            }
        }
    }


}
