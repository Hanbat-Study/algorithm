import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution__2112 {
    static int d, w, k, res;
    static int [][] map, copy;
    static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new int[d][w];
            copy = new int[d][w];
            isSelected = new boolean[d];
            res = Integer.MAX_VALUE;
            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = copy[i][j] =Integer.parseInt(st.nextToken());
                }
            }
            if (isValid()) System.out.println("#"+ t +" 0");
            else {
                comb(0);
                System.out.println("#"+ t +" " + res);
            }
        }
    }
    //부분집합
    private static void comb(int cnt) {
        if (cnt == d) {
            dfs(isSelected, 0, 0);
            for (int i = 0; i < d; i++) {
                System.arraycopy(copy[i], 0,map[i], 0, w);
            }
            return;
        }
        isSelected[cnt] = true;
        comb(cnt + 1);
        isSelected[cnt] = false;
        comb(cnt + 1);
    }
    //재귀
    private static void dfs(boolean[] isSelected, int cnt, int idx) {

        if (cnt >= res)return;
        if (idx == d) {
            if (isValid()) res = Math.min(res, cnt);
            return;
        }
        if (isSelected[idx])
        {
            Arrays.fill(map[idx], 0);
            dfs(isSelected, cnt + 1, idx + 1);

            Arrays.fill(map[idx] , 1);
            dfs(isSelected, cnt + 1, idx + 1);
        }
        else {
            dfs(isSelected, cnt, idx + 1);
        }
    }

    private static boolean isValid() {
        for (int i = 0; i < w; i++) {
            int cnt = 1;
            int st = map[0][i];
            boolean flag = false;
            for (int j = 1; j < d; j++) {
                if (st == map[j][i]) cnt++;
                else {
                    st = map[j][i];
                    cnt = 1;
                }
                if (cnt == k) {
                    flag = true;
                    break;
                }
            }
            if (!flag) return false;
        }
        return true;
    }
}