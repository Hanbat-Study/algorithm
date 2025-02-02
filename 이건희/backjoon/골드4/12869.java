import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, result;
    static int[][] d = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = Integer.MAX_VALUE;
        int[] arr = new int[3];
        dp = new int[61][61][61];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        attack(arr, 0);

        System.out.println(result);
    }

    public static void attack(int[] arr, int cnt) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if (result <= cnt) return;

        if(dp[a][b][c] != 0 && dp[a][b][c] <= cnt) return;

        dp[a][b][c] = cnt;

        if (a == 0 && b == 0 && c == 0) {
            result = cnt;

            return;
        }

        for (int i = 0; i < 6; i++) {
            attack(new int[] {Math.max(a - d[i][0], 0), Math.max(b - d[i][1], 0), Math.max(c - d[i][2], 0)}, cnt + 1);
        }
    }
}
