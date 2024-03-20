import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Soluution_swea_1952 {
    static int day, month, months, year, res;
    static int[] plan;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            plan = new int[13];
            StringTokenizer st = new StringTokenizer(br.readLine());
            day = Integer.parseInt(st.nextToken());
            month = Integer.parseInt(st.nextToken());
            months = Integer.parseInt(st.nextToken());
            year = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 12; i++) {
                plan[i] = Integer.parseInt(st.nextToken());
            }
            res = Integer.MAX_VALUE;
            dfs(0, 0);
            System.out.println("#"+ t + " " + res);
        }
    }

    private static void dfs(int cnt, int sum) {
        if (cnt >= 12) {
            res = Math.min(res, sum);
            return;
        }
        dfs(cnt + 1, sum + day*plan[cnt]);
        dfs(cnt + 1, sum + month);
        dfs(cnt + 3, sum + months);
        dfs (cnt + 13, sum + year);
    }
}