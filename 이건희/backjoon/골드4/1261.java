import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map, check;
    static int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        check = new int[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j) - '0';
            }

            Arrays.fill(check[i], -1);
        }

        go(0, 0, 0);

        if (check[N - 1][M - 1] == -1) System.out.println(0);
        else System.out.println(check[N - 1][M - 1]);
    }

    public static void go(int y, int x, int cnt) {
        if (y == N - 1 && x == M - 1) {
            if (check[N - 1][M - 1] == -1) check[N - 1][M - 1] = cnt;
            else check[N - 1][M - 1] = Math.min(check[N - 1][M - 1], cnt);

            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = y + d[i][0];
            int nx = x + d[i][1];

            if (0 <= ny && ny < N && 0 <= nx && nx < M) {
                if (check[ny][nx] == -1 || cnt < check[ny][nx]) {
                    check[ny][nx] = cnt;

                    if (map[ny][nx] == 1) go(ny, nx, cnt + 1);
                    else go(ny, nx, cnt);
                }
            }
        }
    }
}
