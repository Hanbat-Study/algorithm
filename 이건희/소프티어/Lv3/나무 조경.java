import java.io.*;
import java.util.*;

public class Main {
    static int n, result, maxCnt;
    static int[][] arr;
    static int[][] d = {{0, 1}, {1, 0}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        result = 0;
        arr = new int[n][n];
        visited = new boolean[n][n];
        
        if (n == 2) maxCnt = 2;
        else maxCnt = 4;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS( 0, 0);

        System.out.println(result);
    }

    public static void DFS(int sum, int cnt) {
        if (cnt == maxCnt) {
            result = Math.max(result, sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;

                for (int k = 0; k < 2; k++) {
                    int ny = i + d[k][0];
                    int nx = j + d[k][1];

                    if (0 <= ny && ny < n && 0 <= nx && nx < n && !visited[ny][nx]) {
                        visited[i][j] = true;
                        visited[ny][nx] = true;
                        DFS(sum + arr[ny][nx] + arr[i][j], cnt + 1);
                        visited[i][j] = false;
                        visited[ny][nx] = false;
                    }
                }
            }
        }
    }
}
