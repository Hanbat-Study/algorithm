import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main_15686{
    static int N,M, res;
    static int[][] map;
    static ArrayList<int[]> chi = new ArrayList<>();
    static ArrayList<int[]> home = new ArrayList<>();
    static boolean[] check;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) chi.add(new int[]{i, j});
                else if (map[i][j] == 1) home.add(new int[] { i, j});
            }
        }
        check = new boolean[chi.size()];
        res = Integer.MAX_VALUE;
        comb(0, 0);
        System.out.println(res);
    }

    private static void comb(int cnt, int idx) {
        if (cnt == M) {
            res = Math.min(res, cal());
            return;
        }
        for (int i = idx; i < chi.size(); i++) {
            if (check[i]) continue;
            check[i] = true;
            comb(cnt + 1, i + 1);
            check[i] = false;
        }
    }

    private static int cal() {
        int minSum = 0;
        for (int i = 0; i < home.size(); i++) {
            int minDis = Integer.MAX_VALUE;
            for (int j = 0; j < chi.size(); j++) {
                if (check[j]) {
                    int dist = Math.abs(chi.get(j)[0] - home.get(i)[0]) + Math.abs(chi.get(j)[1] - home.get(i)[1]);
                    minDis = Math.min(minDis, dist);
                }
            }
            minSum += minDis;
        }
        return minSum;
    }
}