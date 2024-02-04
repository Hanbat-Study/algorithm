import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main_2468{
    static int N, count, ch;
    static int[][] nums;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N + 1][N + 1];
        int maxResult = 1;
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nums[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, nums[i][j]);
            }
        }
        for (ch = 1; ch <= maxH; ch++) {
            visited = new boolean[N][N];
            int safeArea = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(nums[i][j] > ch &&!visited[i][j]){
                        bfs(i, j);
                        safeArea++;
                    }
                }
                maxResult = Math.max(maxResult, safeArea);
            }
        }
        System.out.println(maxResult);

    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visited[x][y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if (nums[nx][ny] <= ch || visited[nx][ny]) continue;
                q.add(new int[]{nx ,ny});
                visited[nx][ny] = true;
            }
        }
    }
}