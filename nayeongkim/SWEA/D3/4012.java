import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution_4012 {
    static int N;
    static int[][] map;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            visited = new boolean[N];
            ans = Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            comb(0, 0);
            System.out.println("#"+ tc +" "+ ans);
        }
    }

    private static void comb(int cnt, int idx) {
        if (cnt == N/2) {
            ans = Math.min(ans, cal());
            return;
        }
        for (int i = idx; i < N; i++) {
            visited[i] = true;
            comb(cnt + 1, i+ 1);
            visited[i] = false;
        }
    }

    private static int cal() {
        int x = 0;
        int y = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <N; j++) {
                if (i == j) continue;
                if (visited[i] && visited[j]) {
                    x += map[i][j];
                }
                else if (!visited[i] && !visited[j]) {
                    y += map[i][j];
                }

            }
        }
        return Math.abs(x - y);
    }
}