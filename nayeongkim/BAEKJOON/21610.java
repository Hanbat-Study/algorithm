import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_21610 {
    static int[][] map;
    static boolean[][] cloud, water;
    static int n, m, ans;
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n ][n ];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cloud = new boolean[n][n];
        cloud[n - 1][0] = true;
        cloud[n - 1][1] = true;
        cloud[n - 2][0] = true;
        cloud[n - 2][1] = true;
        water = new boolean[n ][n ];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            cloudCheck(d, s);
            waterCheck();
            removeWater();
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                ans += map[i][j];
            }
        }
        System.out.println(ans);
    }

    private static void removeWater() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!water[i][j] && map[i][j] > 1) {
                    map[i][j] -= 2;
                    cloud[i][j] = true;
                }
                else if (water[i][j]) water[i][j] = false;
            }
        }

    }

    private static void waterCheck() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (water[i][j]) {
                    for (int d = 2; d <= 8; d += 2) {
                            int nr = i + dr[d];
                            int nc = j + dc[d];
                            if (isIn(nr,nc) &&map[nr][nc] > 0) {
                                map[i][j]++;
                            }

                    }

                }
            }
        }
    }

    private static boolean isIn(int nr, int nc) {
        return 0<= nr && nr < n && 0 <= nc && nc < n;
    }

    private static void cloudCheck(int d, int s) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cloud[i][j]) {
                    int nr = (i + dr[d] * s % n + n) % n;
                    int nc = (j + dc[d] * s % n + n) % n;
                    water[nr][nc] = true;
                    map[nr][nc]++;
                    cloud[i][j] = false;
                }
            }
        }
    }
}