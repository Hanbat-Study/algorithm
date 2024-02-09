import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_17406 {
    static int N, M, K;
    static int[][] map;
    static int[][] k;
    static boolean[] used;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        k = new int[K][3];
        used = new boolean[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            k[i][0] = Integer.parseInt(st.nextToken()) - 1;
            k[i][1] = Integer.parseInt(st.nextToken()) - 1;
            k[i][2] = Integer.parseInt(st.nextToken());
        }

        permute(0, map);
        System.out.println(result);
    }

    private static void permute(int cnt, int[][] arr) {
        if (cnt == K) {
            result = Math.min(result, findMinSum(arr));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!used[i]) {
                used[i] = true;
                permute(cnt + 1, rotate(arr, k[i][0], k[i][1], k[i][2]));
                used[i] = false;
            }
        }
    }

    private static int[][] rotate(int[][] arr, int r, int c, int s) {
        int[][] temp = copy(arr);

        for (int layer = 1; layer <= s; layer++) {
            int startR = r - layer;
            int startC = c - layer;
            int endR = r + layer;
            int endC = c + layer;

            int prev = temp[startR + 1][startC];
            for (int i = startC; i < endC; i++) {
                int tmp = temp[startR][i];
                temp[startR][i] = prev;
                prev = tmp;
            }
            for (int i = startR; i < endR; i++) {
                int tmp = temp[i][endC];
                temp[i][endC] = prev;
                prev = tmp;
            }
            for (int i = endC; i > startC; i--) {
                int tmp = temp[endR][i];
                temp[endR][i] = prev;
                prev = tmp;
            }
            for (int i = endR; i > startR; i--) {
                int tmp = temp[i][startC];
                temp[i][startC] = prev;
                prev = tmp;
            }
        }
        return temp;
    }

    private static int[][] copy(int[][] original) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(original[i], 0, newMap[i], 0, M);
        }
        return newMap;
    }

    private static int findMinSum(int[][] arr) {
        int minSum = Integer.MAX_VALUE;
        for (int[] row : arr) {
            int sum = 0;
            for (int val : row) sum += val;
            minSum = Math.min(minSum, sum);
        }
        return minSum;
    }
}