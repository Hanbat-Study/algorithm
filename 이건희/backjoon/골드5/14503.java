import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, result;
    static int[][] arr;
    static int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = 0;

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(r, c, d);

        System.out.println(result);
    }

    private static void clean(int r, int c, int d) {
        if (arr[r][c] == 0) {
            arr[r][c] = 2;
            result++;
        }

        boolean check = false;

        for (int i = 0; i < 4; i++) {
            int nd = (d + 3) % 4;
            int nr = r + dis[nd][0];
            int nc = c + dis[nd][1];

            if (0 <= nr && nr < N && 0 <= nc && nc < M && arr[nr][nc] == 0) {
                clean(nr, nc, nd);
                check = true;
                break;
            }
            d = (d + 3) % 4;
        }

        if (!check) {
            int nd = (d + 2) % 4;
            int nr = r + dis[nd][0];
            int nc = c + dis[nd][1];

            if (0 <= nr && nr < N && 0 <= nc && nc < M && arr[nr][nc] != 1) {
                clean(nr, nc, d);
            }
        }
    }
}
