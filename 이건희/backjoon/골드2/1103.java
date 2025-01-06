import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static boolean stop;
    static int[][] dp;
    static char[][] arr;
    static boolean[][] visited;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 1;
        stop = false;
        dp = new int[N][M];
        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visited[0][0] = true;

        game(0, 0,  1);

        System.out.println(result);
    }

    public static void game(int y, int x, int cnt) {
        if (stop) return;

        result = Math.max(result, cnt);

        for (int i = 0; i < 4; i++) {
            int dy = y + d[i][0] * (arr[y][x] - '0');
            int dx = x + d[i][1] * (arr[y][x] - '0');

            if (0 <= dy && dy < N && 0 <= dx && dx < M && arr[dy][dx] != 'H' && dp[dy][dx] < cnt + 1) {
                if (visited[dy][dx]) {
                    stop = true;
                    result = -1;

                    return;
                }

                dp[dy][dx] = cnt + 1;
                visited[dy][dx] = true;

                game(dy, dx, cnt + 1);

                visited[dy][dx] = false;
            }
        }
    }
}
