import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int H, G, result;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        result = 0;
        map = new char[H][G];

        for (int i = 0; i < H; i++) {
            String s = br.readLine();

            for (int j = 0; j < G; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < G; j++) {
                if (map[i][j] == 'L') go(i, j);
            }
        }

        System.out.println(result);
    }

    public static void go(int y, int x) {
        Deque<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, 0});
        boolean[][] visited = new boolean[H][G];
        visited[y][x] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curY = cur[0];
            int curX = cur[1];
            int cnt = cur[2];
            result = Math.max(result, cnt);

            for (int i = 0; i < 4; i++) {
                int dy = curY + d[i][0];
                int dx = curX + d[i][1];

                if (0 <= dy && dy < H && 0 <= dx && dx < G && map[dy][dx] == 'L' && !visited[dy][dx]) {
                    visited[dy][dx] = true;


                    q.add(new int[]{dy, dx, cnt + 1});
                }
            }
        }

    }
}
