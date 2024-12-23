import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] arr;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        result = 0;
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;

                cal(i, j, arr[i][j], 0);

                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }
    public static void cal(int y, int x, int sum, int cnt) {
        if (cnt == 3) {
            result = Math.max(result, sum);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i][0];
            int dx = x + d[i][1];

            if (0 <= dy && dy < N && 0 <= dx && dx < M && !visited[dy][dx]) {
                if (cnt == 1) {
                    visited[dy][dx] = true;

                    cal(y, x, sum + arr[dy][dx], cnt + 1);

                    visited[dy][dx] = false;
                }

                visited[dy][dx] = true;

                cal(dy, dx, sum + arr[dy][dx], cnt + 1);

                visited[dy][dx] = false;
            }
        }
    }
}
