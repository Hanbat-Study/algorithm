import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_5650 {
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
    static int N, res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            res = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) {
                        for (int d = 0; d < 4; d++) {
                            simul(i, j, d);
                        }
                    }
                }
            }
            System.out.println("#" + tc + " " + res);
        }
    }

    private static void simul(int x, int y, int d) {
        int score = 0;
        int nx = x, ny = y;
        while (true) {
            nx += dr[d];
            ny += dc[d];

            if (!isIn(nx, ny) || map[nx][ny] == -1) {
                res = Math.max(res, score);
                return;
            }

            if (nx == x && ny == y) {
                res = Math.max(res, score);
                return;
            }

            if (map[nx][ny] >= 1 && map[nx][ny] <= 5) {
                d = changeDir(map[nx][ny], d);
                score++;
            }
            else if (map[nx][ny] >= 6 && map[nx][ny] <= 10) {
                int[] wormhole = findWormhole(nx, ny, map[nx][ny]);
                nx = wormhole[0];
                ny = wormhole[1];
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static int changeDir(int blockType, int dir) {
        int[][] blockDirs = {
                {1, 3, 0, 2},
                {3, 0, 1, 2},
                {2, 0, 3, 1},
                {1, 2, 3, 0},
                {1, 0, 3, 2}
        };
        return blockDirs[blockType - 1][dir];
    }

    // 웜홀 위치 찾기
    static int[] findWormhole(int x, int y, int num) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == num && (i != x || j != y)) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{x, y};
    }
}
