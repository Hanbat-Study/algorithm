import java.io.*;
import java.util.*;

public class Main {
    static int n, m, result;
    static int[][] arr, friends;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = 0;
        arr = new int[n][n];
        friends = new int[m][2];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            friends[i] = new int[]{a, b};
            visited[a][b] = true;
            result += arr[a][b];
        }

        dfs(friends[0][0], friends[0][1], 0, 0, result);

        System.out.println(result);
    }

    public static void dfs(int y, int x, int cnt, int time, int sum) {
        result = Math.max(result, sum);

        if (time == 3) {
            if(cnt + 1 < m) {
                dfs(friends[cnt + 1][0], friends[cnt + 1][1], cnt + 1, 0, sum);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int ny = y + d[i][0];
                int nx = x + d[i][1];

                if (0 <= ny && ny < n && 0 <= nx && nx < n && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dfs(ny, nx, cnt, time + 1, sum + arr[ny][nx]);
                    visited[ny][nx] = false;
                }
            }
        }
    }
}
