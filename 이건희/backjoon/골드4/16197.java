import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[] coin1, coin2;
    static char[][] map;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;
        coin1 = new int[]{-1, -1};
        coin2 = new int[]{-1, -1};
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");

            for (int j = 0; j < M; j++) {
                map[i][j] = s[j].charAt(0);

                if (map[i][j] == 'o') {
                    if (coin1[0] == -1 && coin1[1] == -1) coin1 = new int[]{i, j};
                    else coin2 = new int[]{i, j};
                }
            }
        }

        go(coin1[0], coin1[1], coin2[0], coin2[1], 1);

        if (result == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(result);
    }

    public static void go(int coin1Y, int coin1X, int coin2Y, int coin2X, int cnt) {
        if (10 < cnt) return;

        for (int i = 0; i < 4; i++) {
            int ny1 = coin1Y + d[i][0];
            int nx1 = coin1X + d[i][1];
            int ny2 = coin2Y + d[i][0];
            int nx2 = coin2X + d[i][1];

            boolean check1 = check(ny1, nx1);
            boolean check2 = check(ny2, nx2);

            if (!check1 && !check2) continue;

            if (!check1 || !check2) {
                result = Math.min(result, cnt);

                return;
            }

            if (map[ny1][nx1] == '#') {
                ny1 = coin1Y;
                nx1 = coin1X;
            }

            if (map[ny2][nx2] == '#') {
                ny2 = coin2Y;
                nx2 = coin2X;
            }

            if (ny1 == ny2 && nx1 == nx2) continue;

            go(ny1, nx1, ny2, nx2, cnt + 1);
        }
    }

    public static boolean check(int y, int x) {
        return 0 <= y && y < N && 0 <= x && x < M;
    }
}
