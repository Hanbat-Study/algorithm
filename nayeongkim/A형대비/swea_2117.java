import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class swea_2117 {
    static int n, m, res;
    static int[][] map;
    static int[] K;
    static ArrayList<int[]> homes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][n];
            K = new int[n + 2];
            for (int i = 1; i <= n + 1; i++) {
                K[i] = (i * i) + ((i - 1) * (i - 1));
            }
            homes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) homes.add(new int[]{i, j});
                }
            }
            res = 1;
            for (int i = 1; i<= n + 1; i++) {
                service(i);
            }
            System.out.println("#" + t + " " + res);
        }
    }

    private static void service(int k) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int[] home : homes) {
                    int dist = Math.abs(home[0] - i) + Math.abs(home[1] - j);
                    if (dist < k) count++;
                }
                if (count * m >= K[k])
                    res = Math.max(res, count);
            }
        }
    }
}
