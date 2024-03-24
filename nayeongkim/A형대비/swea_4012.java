import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_swea_4012 {
    private static int n, res;
    private static int[][] map;
    private static boolean[] isSelected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            res = Integer.MAX_VALUE;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            isSelected = new boolean[n];
            for (int i = 0; i < n ; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            comb(0, 0);
            System.out.println("#" + t + " " + res);
        }
    }

    private static void comb(int cnt, int idx) {
        if (cnt == n/2) {
            res = Math.min(res, cal());
        }
        for (int i = idx; i < n; i++) {
            isSelected[i] = true;
            comb(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    private static int cal() {
        int sumA = 0, sumB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ( i == j) continue;
                if (isSelected[i] && isSelected[j]) {
                    sumA +=map[i][j];
                }
                else if (!isSelected[i] && !isSelected[j]){
                    sumB += map[i][j];
                }
            }
        }
        return Math.abs(sumA - sumB);
    }
}