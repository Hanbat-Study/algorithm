import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int result, n;
    static int[][] arr;
    static int[][] d = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
    static boolean[] dessert;
    static boolean[][] visited;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
 
        for (int test_case = 1; test_case <= t; test_case++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][n];
            result = 0;
 
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            for (int i = 1; i < n - 1; i++) {
                for (int j = 0; j < n - 2; j++) {
                    dessert = new boolean[101];
                    dessert[arr[i][j]] = true;
                    visited = new boolean[n][n];
                    visited[i][j] = true;
 
                    check(1, i, j, i, j, 0);
                }
            }
 
            if (result == 0) result = -1;
 
            System.out.printf("#%d %d\n", test_case, result);
        }
    }
 
    public static void check(int cnt, int y, int x, int initY, int initX, int prevD) {
        for (int i = prevD; i < 4; i++) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];
 
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (ny == initY && nx == initX && cnt > 2) {
                    result = Math.max(cnt, result);
                    return;
                }
 
                if (!visited[ny][nx] && !dessert[arr[ny][nx]]) {
                    dessert[arr[ny][nx]] = true;
                    visited[ny][nx] = true;
                    check(cnt + 1, ny, nx, initY, initX, i);
                    dessert[arr[ny][nx]] = false;
                    visited[ny][nx] = false;
                }
            }
        }
    }
}
