import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        result = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 1, 0);

        System.out.println(result);
    }

    private static void dfs(int y, int x, int d) {
        if (y == N - 1 && x == N - 1) {
            result++;
            return;
        }

        if (d == 0) {
            if (x + 1 < N && arr[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }
        } else if (d == 1) {
            if (y + 1 < N && arr[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
        } else if (d == 2) {
            if (x + 1 < N && arr[y][x + 1] == 0) {
                dfs(y, x + 1, 0);
            }
            if (y + 1 < N && arr[y + 1][x] == 0) {
                dfs(y + 1, x, 1);
            }
        }

        if (y + 1 < N && x + 1 < N && arr[y][x + 1] == 0 && arr[y + 1][x] == 0 && arr[y + 1][x + 1] == 0) {
            dfs(y + 1, x + 1, 2);
        }
    }
}
