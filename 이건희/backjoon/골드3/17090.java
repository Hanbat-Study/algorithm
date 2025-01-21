import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static char[][] map;
    static int[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dp[i][j] == 0) cal(i, j);
            }
        }

        for (int[] ints : dp) {
            for (int anInt : ints) {
                if (anInt == 2) result++;
            }
        }

        System.out.println(result);
    }

    public static void cal(int y, int x) {
        if (visited[y][x]) {
            dp[y][x] = 1;

            return;
        }

        if (dp[y][x] != 0) return;

        visited[y][x] = true;
        int dy = y;
        int dx = x;

        if (map[y][x] == 'U') dy -= 1;
        else if (map[y][x] == 'R') dx += 1;
        else if (map[y][x] == 'D') dy += 1;
        else if (map[y][x] == 'L') dx -= 1;

        if (dy < 0 || dx < 0 || N <= dy || M <= dx) dp[y][x] = 2;
        else {
            if (dp[dy][dx] == 0) cal(dy, dx);

            dp[y][x] = dp[dy][dx];
        }

        visited[y][x] = false;

    }
}
