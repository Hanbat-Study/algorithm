import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, t;
    static int[][] a;
    static int[] cleanerUp, cleanerDown;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());
        a = new int[r][c];
        cleanerUp = new int[2];
        cleanerDown = new int[2];

        int idx = 0;
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                if (a[i][j] == -1) {
                    if (idx == 0) cleanerUp = new int[]{i, j};
                    else cleanerDown = new int[]{i, j};
                    idx++;
                }
            }
        }

        for (int time = 0; time < t; time++) {
            diffuse();
            cleanAir();
        }

        System.out.println(sumDust());
    }

    private static void diffuse() {
        int[][] spread = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] > 0) {
                    int amount = a[i][j] / 5;
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (0 <= nr && nr < r && 0 <= nc && nc < c && a[nr][nc] != -1) {
                            spread[nr][nc] += amount;
                            a[i][j] -= amount;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                a[i][j] += spread[i][j];
            }
        }
    }

    private static void cleanAir() {
        int upR = cleanerUp[0];
        int downR = cleanerDown[0];

        for (int i = upR - 1; i > 0; i--) a[i][0] = a[i - 1][0];
        for (int i = 0; i < c - 1; i++) a[0][i] = a[0][i + 1];
        for (int i = 0; i < upR; i++) a[i][c - 1] = a[i + 1][c - 1];
        for (int i = c - 1; i > 1; i--) a[upR][i] = a[upR][i - 1];
        a[upR][1] = 0;

        for (int i = downR + 1; i < r - 1; i++) a[i][0] = a[i + 1][0];
        for (int i = 0; i < c - 1; i++) a[r - 1][i] = a[r - 1][i + 1];
        for (int i = r - 1; i > downR; i--) a[i][c - 1] = a[i - 1][c - 1];
        for (int i = c - 1; i > 1; i--) a[downR][i] = a[downR][i - 1];
        a[downR][1] = 0;
    }

    private static int sumDust() {
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (a[i][j] > 0) sum += a[i][j];
            }
        }
        return sum;
    }
}
