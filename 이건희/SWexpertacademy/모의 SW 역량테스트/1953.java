import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class Solution {
    static int N, M, R, C, L, result;
    static int[][] arr, time;
    static int[][] dis = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] tg = {{}, {0, 1, 2, 3}, {0, 2}, {1, 3}, {0, 1}, {1, 2}, {2, 3}, {0, 3}};
    static boolean[][] visited;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
 
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            result = 1;
 
            arr = new int[N][M];
            time = new int[N][M];
            visited = new boolean[N][M];
 
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
 
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            bfs(R, C, arr[R][C], 1);
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
 
    private static void bfs(int y, int x, int d, int time) {
        LinkedList<int[]> queue = new LinkedList<>();
 
        visited[y][x] = true;
        queue.offer(new int[]{y, x, d, time});
 
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
 
            int ny = poll[0];
            int nx = poll[1];
            int nd = poll[2];
            int nTime = poll[3];
 
            for (int i = 0; i < tg[nd].length; i++) {
                int dy = ny + dis[tg[nd][i]][0];
                int dx = nx + dis[tg[nd][i]][1];
                int dd = tg[nd][i];
 
                if (0 <= dy && dy < N && 0 <= dx && dx < M && !visited[dy][dx] && 0 < arr[dy][dx] && nTime + 1 <= L) {
                    for (int j = 0; j < tg[arr[dy][dx]].length; j++) {
                        if ((dd == 0 && tg[arr[dy][dx]][j] == 2) || (dd == 1 && tg[arr[dy][dx]][j] == 3) || (dd == 2 && tg[arr[dy][dx]][j] == 0) || (dd == 3 && tg[arr[dy][dx]][j] == 1)) {
                            visited[dy][dx] = true;
                            result++;
                            queue.offer(new int[]{dy, dx, arr[dy][dx], nTime + 1});
                        }
                    }
                }
            }
        }
    }
}
