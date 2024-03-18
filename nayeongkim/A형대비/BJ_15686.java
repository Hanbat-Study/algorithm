import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main_bj_15686 {
    static int n, m, res;
    static boolean[] isSelected;
    static int[][] map;
    static ArrayList<int[]> chickens = new ArrayList<>();
    static ArrayList<int[]> homes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) homes.add(new int[]{i, j});
                else if (map[i][j] == 2) chickens.add(new int[]{i, j});
            }
        }
        isSelected = new boolean[chickens.size()];
        res = Integer.MAX_VALUE;
        comb(0, 0);
        System.out.println(res);
    }

    private static void comb(int cnt, int idx) {
        if (cnt == m) {
            res = Math.min(res, cal());
            return;
        }
        for (int i = idx; i <chickens.size();i++) {
            if(isSelected[i]) continue;
            isSelected[i] = true;
            comb(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    private static int cal() {
        int sum = 0;
        for (int i = 0; i < homes.size(); i++) {
            int minDist = Integer.MAX_VALUE;
            for (int j = 0; j < chickens.size(); j++) {
                if (isSelected[j]) {
                    int dist = Math.abs(homes.get(i)[0] - chickens.get(j)[0]) + Math.abs(homes.get(i)[1] - chickens.get(j)[1]);
                    minDist = Math.min(minDist, dist);
                }
            }
            sum += minDist;
        }
        return sum;
    }
}