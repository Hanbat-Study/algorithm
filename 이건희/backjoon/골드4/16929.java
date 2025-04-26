import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean result;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = false;
        arr = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited = new boolean[N][M];

                dfs(i, j, i, j, 1);
            }
        }

        if (!result) System.out.println("No");
        else System.out.println("Yes");
    }

    public static void dfs(int y, int x, int startY, int startX, int cnt) {
        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i][0];
            int dx = x + d[i][1];

            if (0 <= dy && dy < N && 0 <= dx && dx < M && arr[dy][dx] == arr[startY][startX]) {
                if (dy == startY && dx == startX && 4 <= cnt) {
                    result = true;

                    return;
                }

                if (!visited[dy][dx]) dfs(dy, dx, startY, startX, cnt + 1);
            }
        }
    }
}
