import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static class Node {
        int r, c;
 
        Node() {
 
        }
 
        void set(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
 
    static int n;
    static int[][] map;
    static Node[] core = new Node[12];
    static int cnt;
 
    static int[] drs = { 0, 0, 1, -1 };
    static int[] dcs = { 1, -1, 0, 0 };
 
    public static void main(String args[]) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
 
        int T;
        T = Integer.parseInt(br.readLine());
 
        for (int i = 0; i < 12; i++) {
            core[i] = new Node();
        }
 
        for (int test_case = 1; test_case <= T; test_case++) {
 
            n = Integer.parseInt(br.readLine());
 
            cnt = 0; // 코어 개수
 
            map = new int[n][n];
 
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
 
                    if (map[i][j] == 1 && !(i == 0 || j == 0 || i == n - 1 || j == n - 1)) {
                        core[cnt++].set(i, j);
                    }
                }
            }
 
            ans = Integer.MAX_VALUE;
            ansCnt = 0;
 
            connectComob(0, 0, 0);
 
            sb.append("#" + test_case + " " + ans + "\n");
        }
        System.out.println(sb.toString().trim());
    }
 
    static boolean[] visited = new boolean[12];
 
    static int ans = Integer.MAX_VALUE;
    static int ansCnt = 0;
 
    private static void connectComob(int depth, int coreCnt, int total) {
 
        if (depth == cnt) {
 
            if (ansCnt < coreCnt || (ansCnt == coreCnt && ans > total)) {
                ansCnt = coreCnt;
                ans = total;
            }
            return;
        }
 
        for (int d = 0; d < 4; d++) {
 
            int t = setDirect(depth, d);
 
            if (t > 0) {
                connectComob(depth + 1, coreCnt + 1, t + total);
                removeDirect(depth, d);
            }
 
        }
        connectComob(depth + 1, coreCnt, total);
    }
 
    private static int setDirect(int c, int d) {
 
        int total = 0;
 
        int nr = core[c].r;
        int nc = core[c].c;
 
        while (true) {
            nr += drs[d];
            nc += dcs[d];
 
            if (!inRange(nr, nc)) {
                break;
            }
 
            if (map[nr][nc] == 1) {
 
                while (true) {
                    nr -= drs[d];
                    nc -= dcs[d];
 
                    if (nr == core[c].r && nc == core[c].c) {
                        break;
                    }
 
                    map[nr][nc] = 0;
                }
                total = 0;
                break;
            }
 
            total++;
            map[nr][nc] = 1;
 
        }
        return total;
    }
 
    private static void removeDirect(int c, int d) {
 
        int nr = core[c].r;
        int nc = core[c].c;
        // 각 코어 연결
        // 연결할 코어 선택
 
        while (true) {
            nr += drs[d];
            nc += dcs[d];
 
            if (!inRange(nr, nc)) {
                break;
            }
            map[nr][nc] = 0;
        }
 
    }
 
    private static boolean inRange(int r, int c) {
        // TODO Auto-generated method stub
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}
