import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_bj_17406 {
    static int n, m, k, res;
    static int[][] map, K;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        K = new int[k][3];
        visited = new boolean[k];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            K[i][0] = Integer.parseInt(st.nextToken()) - 1;
            K[i][1] = Integer.parseInt(st.nextToken()) - 1;
            K[i][2] = Integer.parseInt(st.nextToken());
        }
        res = Integer.MAX_VALUE;
        permutat(0, map);
        System.out.println(res);
    }

    private static void permutat(int cnt, int[][] arr) {
        if (cnt == k) {
            res = Math.min(res, cal(arr));
            return;
        }
        for (int i = 0; i < k; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            permutat(cnt + 1, rotate(K[i][0], K[i][1], K[i][2], arr));
            visited[i] = false;
        }
    }

    private static int cal(int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += arr[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }

    private static int[][] rotate(int r, int c, int S, int[][] arr) {
        int[][] arr2 = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(arr[i], 0, arr2[i], 0, m);
        }
        for (int s = 1; s <=S; s++) {
            int sr = r - s; int sc = c - s;
            int er = r + s; int ec = c + s;
            int prev = arr2[sr + 1][sc];
            for (int i = sc; i <ec; i++) {
                int tmp = arr2[sr][i];
                arr2[sr][i] = prev;
                prev = tmp;
            }
            for (int i = sr; i < er; i++) {
                int tmp = arr2[i][ec];
                arr2[i][ec] = prev;
                prev = tmp;
            }
            for (int i = ec; i > sc; i--) {
                int tmp = arr2[er][i];
                arr2[er][i] = prev;
                prev = tmp;
            }
            for (int i = er; i > sr; i--) {
                int tmp = arr2[i][sc];
                arr2[i][sc] = prev;
                prev = tmp;
            }
        }
        return arr2;
    }
}