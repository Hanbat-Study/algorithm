import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs(int y, int x) {
        int[][] dis = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int nx, ny;

        Queue<Integer> q = new LinkedList<>();
        q.offer(y);
        q.offer(x);
        visited[y][x] = true;
        result++;

        while (!q.isEmpty()) {
            y = q.poll();
            x = q.poll();
            for (int i = 0; i < 4; i++) {
                nx = x + dis[i][1];
                ny = y + dis[i][0];

                if ((0 <= nx && nx < M && 0 <= ny && ny < N) && (map[ny][nx] > 0 && !visited[ny][nx])) {
                    visited[ny][nx] = true;
                    map[ny][nx] = map[y][x] + 1;
                    q.offer(ny);
                    q.offer(nx);
                }
            }
        }
    }
}
