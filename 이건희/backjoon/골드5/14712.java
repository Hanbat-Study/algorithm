import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;
        map = new int[N][M];

        cal(0, 0);

        System.out.println(result);
    }

    public static void cal(int r, int c) {
        if (r == N) {
           result++;

           return;
        }

        int nextR, nextC;

        if (c == M - 1) {
            nextR = r + 1;
            nextC = 0;
        } else {
            nextR = r;
            nextC = c + 1;
        }

        cal(nextR, nextC);

        if (0 < r && 0 < c && map[r - 1][c] == 1 && map[r][c - 1] == 1 && map[r - 1][c - 1] == 1) return;

        map[r][c] = 1;

        cal(nextR, nextC);

        map[r][c] = 0;
    }
}
